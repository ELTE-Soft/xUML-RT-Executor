package hu.eltesoft.modelexecution.m2t.smap.xtend

@SourceMappedTemplate(stratumName="sm")
class TestTemplate {
	extension TraceExtensions e = new TraceExtensions();

	val locationA = new Location("test.sm", 17, 17)
	val locationB = new Location("test.sm", 42, 44)

	val numbers = #[0, "2", 3.14d]

	val location1 = new Location("test2.sm", 1, 1)
	val location2 = new Location("test2.sm", 2, 2)
	val location3 = new Location("test2.sm", 5, 5)

	def generate(String value) '''
		«value»
		    «trace(locationA, "a")»
		«IF true»
			«trace(locationB, "b1\n\r\nb2")»
			
			«makeLoop(numbers)»
		«ENDIF»
	'''

	def makeLoop(Object[] items) '''
		«FOR item : items BEFORE '{ ' SEPARATOR ', ' AFTER ' }'»
			item:
			    «renderItem(item)»
		«ENDFOR»
	'''

	def dispatch renderItem(Integer item) {
		val next = item + 1
		'''Integer: «trace(location1, next)»'''
	}

	def dispatch renderItem(String item) '''String: «trace(location2, item)»'''

	def dispatch renderItem(Double item) '''Double: «trace(location3, item)»'''
}
