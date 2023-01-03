package mai.dep810.noslq.service

import com.hazelcast.core.HazelcastInstance
import mai.dep810.noslq.model.Documents
import mai.dep810.noslq.model.Documents.Books
import mai.dep810.noslq.rep.BookRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.ws.rs.NotFoundException


interface  IBookService{
    fun findAll(): List<Books>
    fun findBookById(book_id:String): Books?
   /* fun createRoom(request: RoomRequest)*/
    /*    fun update(room_id: Rooms, request: RoomRequest)*/
    fun deleteById(book_id: String)

}
@Service
class BookServ(
    @Qualifier("hazelcastInstance") private val hazelcastInstance: HazelcastInstance,
    private val roomRepository: BookRepository) : IBookService {



    override fun findAll(): List<Books> {
        return roomRepository.findAll()
    }

    override fun findBookById(book_id: String): Books? {
        val booksCache=hazelcastInstance.getMap<String,Books>("books")
        if(booksCache.containsKey(book_id)){
         return booksCache[book_id]
        }
        val book=BookRepository.findById(book_id.toString())
        if(book!=null){
            booksCache.put(book_id,book)
        }
        return book
    }



    override fun deleteById(book_id: String) {
        val roomtodelete = findBookById(book_id) ?: throw NotFoundException(book_id)
        roomRepository.delete(roomtodelete)
    }
}
