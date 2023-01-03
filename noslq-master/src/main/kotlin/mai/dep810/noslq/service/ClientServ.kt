package mai.dep810.noslq.service

import mai.dep810.noslq.model.Documents
import mai.dep810.noslq.model.Documents.Users
import mai.dep810.noslq.rep.BookRepository
import mai.dep810.noslq.rep.Clientrepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.ws.rs.NotFoundException

interface  IntClientService{
    fun findAll(): List<Users>
    fun findById(user_id:String): Users
    /*    fun update(room_id: Rooms, request: RoomRequest)*/
    fun deleteById(user_id: String)

}
@Service
class ClientServ(private val roomRepository: Clientrepository) : IntClientService {


        override fun findAll(): List<Users> {
            return roomRepository.findAll()
        }

        override fun findById(user_id: String): Users {
            return roomRepository.findByIdOrNull(user_id) ?: throw NotFoundException(user_id)
        }


        override fun deleteById(user_id: String) {
            val roomtodelete = findById(user_id) ?: throw NotFoundException(user_id)
            roomRepository.delete(roomtodelete)
        }
    }
