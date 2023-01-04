package mai.dep810.noslq.service

import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.HazelcastJsonValue
import mai.dep810.noslq.model.Documents
import mai.dep810.noslq.model.Documents.Books
import mai.dep810.noslq.rep.BookRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.ws.rs.NotFoundException


interface  IBookService{
    fun findAll(): List<Books>
    fun findBookById(book_id:String): String?
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

    override fun findBookById(book_id: String): String? {
        val booksCache=hazelcastInstance.getMap<String, String>("books")
        if(booksCache.containsKey(book_id)){
         booksCache[book_id]
         return booksCache[book_id]
        }
        val book = roomRepository.findById(book_id)

        if(book.isEmpty)
            return null

        booksCache.put(book_id,book.get().client_id)
        return book.get().client_id
    }



    override fun deleteById(book_id: String) {
        val roomtodelete = findBookById(book_id) ?: throw NotFoundException(book_id)
        roomRepository.deleteById(roomtodelete)
    }
}
