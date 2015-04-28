
Current status of branch:

- PROBLEM 1: if using the VM from the launcher, VM events still do not appear
	- currently I have no idea why this is happening

- to (temporarily) use a custom VM, change what gets loaded into the variable "vm" at lines 123-124
	- getVM is for the launch version, mkVM is for the custom one
	- fake directories are built in at:
		variables runtimeClasspath and thirdPartyClasspath: lines 185-186
		getBaseDir(MokaDebugTarget): line 195

- with the custom VM, events appear in the VM, they get handled at line 516
	- handleClassLoaded (line 535) gets the ReferenceType for the loaded class, it should provide line translation information...
	- breakpoints usually appear (addBreakpoint(MokaBreakpoint) at line 300) before the appropriate classes are loaded, so they are temporarily stored (method deferBreakpoint, line 426)
	- when VM breakpoints are ready to be set, placeJdiBreakpoint (line 363) is called
		- PROBLEM 2: while the ReferenceType sees the xUML-rt stratum, and it can read all sorts of data from it, it does not provide line information (see debug lines around line 370)
			- line 384 (referenceType.locationsOfLine(startLineInFile)) should be able to get the line info, but nothing gets through
			- maybe it's a problem with SDEInstaller?
