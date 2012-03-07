package dsl

class Main {
	static  main(args){
		run( new File("src/main/resources/dsl.groovy"))
	}
	static run(File file){
		Script script = new GroovyShell().parse(file.text)
		Message mes = new Message()
		script.metaClass = createEMC(script.class,{
			ExpandoMetaClass emc ->
			emc.hello = {
				Closure cl ->
				cl.delegate = new HelloDelegate(mes)
				cl.resolveStrategy = Closure.DELEGATE_FIRST
				cl()
			}
		})
		script.run()
		printMessage(mes)
	}
	static ExpandoMetaClass createEMC(Class clazz, Closure cl){
			ExpandoMetaClass emc = new ExpandoMetaClass(clazz,false)
			cl(emc)
			emc.initialize()
			emc
	}
	static printMessage(Message message){
		println "${message.hello}${message.mes}"
	}
}


