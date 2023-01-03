package mai.dep810.noslq.service

import mai.dep810.noslq.model.Documents.Books
import mai.dep810.noslq.rep.BookRepository
import mai.dep810.noslq.rep.Roomrepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.ws.rs.NotFoundException


interface  IBookService{
    fun findAll(): List<Books>
    fun findById(book_id:String): Books
   /* fun createRoom(request: RoomRequest)*/
    /*    fun update(room_id: Rooms, request: RoomRequest)*/
    fun deleteById(book_id: String)

}
@Service
class BookServ(private val roomRepository: BookRepository) : IBookService {


    override fun findAll(): List<Books> {
        return roomRepository.findAll()
    }

    override fun findById(book_id: String): Books {
        return roomRepository.findByIdOrNull(book_id) ?: throw NotFoundException(book_id)
    }


    override fun deleteById(book_id: String) {
        val roomtodelete = findById(book_id) ?: throw NotFoundException(book_id)
        roomRepository.delete(roomtodelete)
    }
}
