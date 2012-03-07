package dsl

class HelloDelegate {
	String mes = "Hello,"
	Message message
	HelloDelegate(Message message){
		this.message = message
		this.message.hello = mes
	}
	void message(Closure cl) {
		cl.delegate = new MessageDelegate(message)
		cl.resolveStrategy = Closure.DELEGATE_FIRST
		cl()
	}

	void say() {
		println mes
	}
}
