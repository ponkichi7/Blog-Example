package spock

import spock.lang.*

class SampleSpec extends Specification {
	
	def '名前を含めた挨拶をするかどうか 書き方その１'(){
		expect:
		new Sample().sayHello(name) == result
		where:
		name   | result
		'hoge' | 'Hello,hoge'
		'hage' | 'Hello,hage'
	}
	def '名前を含めた挨拶をするかどうか 書き方その２'(){
                expect:
                new Sample().sayHello(name) == result
                where:
                name   << ['hoge'      ,'hage'      ]
		result << ['Hello,hoge','Hello,hage']
        }
        def '名前を含めた挨拶をするかどうか 書き方その３'(){
                when:
                def result = new Sample().sayHello(name)
		then:
		result == 'Hello,hoge'
                where:
                name   << ['hoge']
        }
        def '名前を含めた挨拶をするかどうか 書き方その４'(){
                when:
                def result = new Sample().sayHello(name)
                then:
                def e = thrown(Exception)
		e.message == '名前が無い'
                where:
                name   << ['']
        }

}
