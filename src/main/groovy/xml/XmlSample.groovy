package xml

import groovy.xml.MarkupBuilder

def writer = new StringWriter()
def xml = new MarkupBuilder(writer)

xml.example() {
	person(name: 'hoge', type: 'hage'){
		city('Tokyo')
		remarks('特に無し')
	}
	person(name: 'moge', type: 'debu', foo: 'bar'){
		city('Saitama')
		remarks('だ埼玉って言わないで')
	}
}

println writer

