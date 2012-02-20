package spock

class Sample {

	def sayHello(String name){
		if (name == null || name.size() == 0) {
			throw new Exception('名前が無い')
		}
		def msg = "Hello,$name"
		println msg
		msg
	}
}
