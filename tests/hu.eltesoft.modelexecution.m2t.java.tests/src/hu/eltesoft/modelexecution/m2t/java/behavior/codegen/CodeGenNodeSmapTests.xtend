package hu.eltesoft.modelexecution.m2t.java.behavior.codegen

import hu.eltesoft.modelexecution.m2t.smap.xtend.DataWithLocation
import hu.eltesoft.modelexecution.m2t.smap.xtend.Location
import org.junit.Test

import static org.junit.Assert.assertEquals

class CodeGenNodeSmapTests {

	static extension CodeGenNode = CodeGenNode.extension

	@Test
	def testBlockWithMappedObjects() {
		val a = new DataWithLocation("a", new Location("a.txt", 10, 20))
		val b = new DataWithLocation("b", new Location("b.txt", 20, 30))
		val text = block(a, b).toSourceMappedText
		assertEquals('''
			{
			a;
			b;
			}
		'''.toString, text.toString)
		assertEquals('''
			SMAP
			
			rALF
			*S rALF
			*F
			+ 0 a.txt
			a.txt
			+ 1 b.txt
			b.txt
			*L
			10,11:2
			20#1,11:3
			*E
		'''.toString, text.smap.toString)
	}
}
