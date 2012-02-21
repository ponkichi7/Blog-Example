package mock

class BL {

	SampleDao dao

	def createItem(String name, String val) {
		if (name == null || name.size() == 0) {
			throw new Exception("Invalid name")
		} else if (val == null || val.size() == 0) {
			throw new Exception("Invalid val")
		}
		def item = new Item(name: name, val: val)
		dao.addItem(item)
	}
}
