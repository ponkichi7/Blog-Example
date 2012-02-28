package file

class FileSample1 {
	File file
	def fileText() {
		println '--fileText()--'
		println file.text
	}
	def fileEachLine(){
		println '--fileEachLine()--'
		file.eachLine { println it }
	}
	def fileFilterLine(){
		println '--fileFilterLine()--'
		file.filterLine { it =~ /^\d+$/}.each { println it}
	}
		
	def static void main(String[] args){
		def fs = new FileSample1(file: new File("build/resources/main/sample1.txt"))
		fs.fileText()
		fs.fileEachLine()
		fs.fileFilterLine()
	}
}
