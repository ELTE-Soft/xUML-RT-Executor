package hu.eltesoft.modelexecution.ide.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Copied from SMapUtils in Apache Jasper compiler
 */
public class SDEInstaller {

	static final String nameSDE = "SourceDebugExtension"; //$NON-NLS-1$

	byte[] orig;
	byte[] sdeAttr;
	byte[] gen;

	int origPos = 0;
	int genPos = 0;

	int sdeIndex;

	public static void install(File inClassFile, File attrFile, File outClassFile) throws IOException {
		new SDEInstaller(inClassFile, attrFile, outClassFile);
	}

	static void install(File inOutClassFile, File attrFile) throws IOException {
		File tmpFile = new File(inOutClassFile.getPath() + "tmp"); //$NON-NLS-1$
		new SDEInstaller(inOutClassFile, attrFile, tmpFile);
		if (!inOutClassFile.delete()) {
			throw new IOException("inOutClassFile.delete() failed"); //$NON-NLS-1$
		}
		if (!tmpFile.renameTo(inOutClassFile)) {
			throw new IOException("tmpFile.renameTo(inOutClassFile) failed"); //$NON-NLS-1$
		}
	}

	static void install(File classFile, byte[] smap) throws IOException {
		File tmpFile = new File(classFile.getPath() + "tmp"); //$NON-NLS-1$
		new SDEInstaller(classFile, smap, tmpFile);
		if (!classFile.delete()) {
			throw new IOException("classFile.delete() failed"); //$NON-NLS-1$
		}
		if (!tmpFile.renameTo(classFile)) {
			throw new IOException("tmpFile.renameTo(classFile) failed"); //$NON-NLS-1$
		}
	}

	SDEInstaller(File inClassFile, byte[] sdeAttr, File outClassFile) throws IOException {
		if (!inClassFile.exists()) {
			return;
			// throw new FileNotFoundException("no such file: " + inClassFile);
		}

		this.sdeAttr = sdeAttr;
		// get the bytes
		orig = SDEInstaller.readWhole(inClassFile);
		gen = new byte[orig.length + sdeAttr.length + 100];

		// do it
		addSDE();

		// write result
		FileOutputStream outStream = new FileOutputStream(outClassFile);
		outStream.write(gen, 0, genPos);
		outStream.close();
	}

	SDEInstaller(File inClassFile, File attrFile, File outClassFile) throws IOException {
		this(inClassFile, SDEInstaller.readWhole(attrFile), outClassFile);
	}

	static byte[] readWhole(File input) throws IOException {
		FileInputStream inStream = new FileInputStream(input);
		int len = (int) input.length();
		byte[] bytes = new byte[len];
		if (inStream.read(bytes, 0, len) != len) {
			inStream.close();
			throw new IOException("expected size: " + len); //$NON-NLS-1$
		}
		inStream.close();
		return bytes;
	}

	void addSDE() throws UnsupportedEncodingException, IOException {
		copy(4 + 2 + 2); // magic min/maj version
		int constantPoolCountPos = genPos;
		int constantPoolCount = readU2();
		writeU2(constantPoolCount);

		// copy old constant pool return index of SDE symbol, if found
		sdeIndex = copyConstantPool(constantPoolCount);
		if (sdeIndex < 0) {
			// if "SourceDebugExtension" symbol not there add it
			writeUtf8ForSDE();

			// increment the countantPoolCount
			sdeIndex = constantPoolCount;
			++constantPoolCount;
			randomAccessWriteU2(constantPoolCountPos, constantPoolCount);

		} else {
			// nothing to do here
		}
		copy(2 + 2 + 2); // access, this, super
		int interfaceCount = readU2();
		writeU2(interfaceCount);
		copy(interfaceCount * 2);
		copyMembers(); // fields
		copyMembers(); // methods
		int attrCountPos = genPos;
		int attrCount = readU2();
		writeU2(attrCount);
		// copy the class attributes, return true if SDE attr found (not copied)
		if (!copyAttrs(attrCount)) {
			// we will be adding SDE and it isn't already counted
			++attrCount;
			randomAccessWriteU2(attrCountPos, attrCount);
		}
		writeAttrForSDE(sdeIndex);
	}

	void copyMembers() {
		int count = readU2();
		writeU2(count);
		for (int i = 0; i < count; ++i) {
			copy(6); // access, name, descriptor
			int attrCount = readU2();
			writeU2(attrCount);
			copyAttrs(attrCount);
		}
	}

	boolean copyAttrs(int attrCount) {
		boolean sdeFound = false;
		for (int i = 0; i < attrCount; ++i) {
			int nameIndex = readU2();
			// don't write old SDE
			if (nameIndex == sdeIndex) {
				sdeFound = true;
			} else {
				writeU2(nameIndex); // name
				int len = readU4();
				writeU4(len);
				copy(len);
			}
		}
		return sdeFound;
	}

	void writeAttrForSDE(int index) {
		writeU2(index);
		writeU4(sdeAttr.length);
		for (byte element : sdeAttr) {
			writeU1(element);
		}
	}

	void randomAccessWriteU2(int pos, int val) {
		int savePos = genPos;
		genPos = pos;
		writeU2(val);
		genPos = savePos;
	}

	int readU1() {
		return orig[origPos++] & 0xFF;
	}

	int readU2() {
		int res = readU1();
		return (res << 8) + readU1();
	}

	int readU4() {
		int res = readU2();
		return (res << 16) + readU2();
	}

	void writeU1(int val) {
		gen[genPos++] = (byte) val;
	}

	void writeU2(int val) {
		writeU1(val >> 8);
		writeU1(val & 0xFF);
	}

	void writeU4(int val) {
		writeU2(val >> 16);
		writeU2(val & 0xFFFF);
	}

	void copy(int count) {
		for (int i = 0; i < count; ++i) {
			gen[genPos++] = orig[origPos++];
		}
	}

	byte[] readBytes(int count) {
		byte[] bytes = new byte[count];
		for (int i = 0; i < count; ++i) {
			bytes[i] = orig[origPos++];
		}
		return bytes;
	}

	void writeBytes(byte[] bytes) {
		for (byte b : bytes) {
			gen[genPos++] = b;
		}
	}

	int copyConstantPool(int constantPoolCount) throws UnsupportedEncodingException, IOException {
		int newSdeIndex = -1;
		// copy const pool index zero not in class file
		for (int i = 1; i < constantPoolCount; ++i) {
			int tag = readU1();
			writeU1(tag);
			switch (tag) {
			case 7: // Class
			case 8: // String
				copy(2);
				break;
			case 16: // MethodType
				copy(2);
				break;
			case 15: // MethodHandle
				copy(3);
				break;
			case 9: // Field
			case 10: // Method
			case 11: // InterfaceMethod
			case 3: // Integer
			case 4: // Float
			case 12: // NameAndType
				copy(4);
				break;
			case 5: // Long
			case 6: // Double
				copy(8);
				i++;
				break;
			case 1: // Utf8
				int len = readU2();
				writeU2(len);
				byte[] utf8 = readBytes(len);
				String str = new String(utf8, "UTF-8"); //$NON-NLS-1$
				if (str.equals(SDEInstaller.nameSDE)) {
					newSdeIndex = i;
				}
				writeBytes(utf8);
				break;
			case 18: // InvokeDynamic
				copy(4);
				break;
			default:
				throw new IOException("unexpected tag: " + tag); //$NON-NLS-1$
			}
		}
		return newSdeIndex;
	}

	void writeUtf8ForSDE() {
		int len = SDEInstaller.nameSDE.length();
		writeU1(1); // Utf8 tag
		writeU2(len);
		for (int i = 0; i < len; ++i) {
			writeU1(SDEInstaller.nameSDE.charAt(i));
		}
	}
}