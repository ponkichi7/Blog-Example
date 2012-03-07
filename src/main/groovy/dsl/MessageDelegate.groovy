package dsl

class MessageDelegate {
	Message message
	MessageDelegate(Message message){
		this.message = message
	}
	void value(String val) {
		message.mes = val
	}
}
