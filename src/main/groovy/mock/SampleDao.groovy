package mock

interface SampleDao {
	def Item addItem(Item item)
	def Item getItem(String name)
	def Item deleteItem(String name)
	def Item updateItem(Item item)
}
