package mock

import spock.lang.*

class BLSpec extends Specification {

	def bl
	SampleDao dao

	def setup(){
		bl = new BL()
		dao = Mock()
		BL.metaClass.setAttribute(bl,"dao",dao)
	}

	def "アイテム登録処理　正常系"(){
		when:
		def item = bl.createItem("foo","bar")
		then:
		dao.addItem(_) >> new Item(name:"foo",val:"bar")
		item.name == "foo"
	}

	def "アイテム登録処理　nameがnullの場合"(){
		when:
		def item = bl.createItem(null,"bar")
		then:
		Exception e = thrown()
		e.message == 'Invalid name'
	}

        def "アイテム登録処理　nameが空文字の場合"(){
                when:
                def item = bl.createItem("","bar")
                then:
                Exception e = thrown()
                e.message == 'Invalid name'
        }

        def "アイテム登録処理　valがnullの場合"(){
                when:
                def item = bl.createItem("foo",null)
                then:
                Exception e = thrown()
                e.message == 'Invalid val'
        }

        def "アイテム登録処理　valが空文字の場合"(){
                when:
                def item = bl.createItem("foo","")
                then:
                Exception e = thrown()
                e.message == 'Invalid val'
        }
        def "アイテム登録処理　nameとvalが不正の場合"(){
                when:
                def item = bl.createItem(null,"")
                then:
                Exception e = thrown()
                e.message == 'Invalid name'
        }
		
}
