package mai.dep810.noslq.api
import mai.dep810.noslq.model.Documents
import mai.dep810.noslq.rep.RoomRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class RoomController(val roomRepository: RoomRepository) {
    @GetMapping("/api/room/find")
    fun findClients(): MutableList<Documents.Rooms> = roomRepository.findAll()

    @GetMapping("api/room/{id}")
    fun findClientsid(@PathVariable id:String): Optional<Documents.Rooms> = roomRepository.findById(id)

    @PostMapping("api/room")
    fun addRoom(@RequestBody room: Documents.Rooms) = roomRepository.insert(room)

    @DeleteMapping("api/room/{id}")
    fun deleteRoom(@PathVariable id: String) = roomRepository.deleteById(id)
}