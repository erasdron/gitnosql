package mai.dep810.noslq.service
import mai.dep810.noslq.model.Documents.Rooms
import mai.dep810.noslq.rep.Roomrepository
import javax.ws.rs.NotFoundException
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


interface  IntRoomService{
    fun findAll(): List<Rooms>
    fun findById(room_id:String): Rooms
    fun createRoom(request: RoomRequest)
    fun deleteById(room_id: String)

}
@Service
class RoomService(private val roomRepository: Roomrepository) : IntRoomService {

    override fun createRoom(request: RoomRequest) {
        roomRepository.save(
            Rooms(
                room_id = request.room_id!!,
                room_name = request.room_name!!,
                room_type = request.room_type!!,
                country = request.country!!,
                price = request.price!!
            )
        )
    }
    override fun findAll(): List<Rooms> {
        return roomRepository.findAll()
           }

    override fun findById(room_id: String): Rooms {
        return roomRepository.findByIdOrNull(room_id)?: throw NotFoundException(room_id)
    }


       override fun deleteById(room_id: String) {
        val roomtodelete = findById(room_id) ?:
            throw NotFoundException(room_id)
        roomRepository.delete(roomtodelete)
    }

}

