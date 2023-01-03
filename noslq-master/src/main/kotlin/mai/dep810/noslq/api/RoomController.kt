package mai.dep810.noslq.api
import mai.dep810.noslq.model.Documents.Rooms
import mai.dep810.noslq.rep.Roomrepository
import mai.dep810.noslq.service.RoomService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("rooms")
class RoomController(val roomrepository: RoomService) {

    @GetMapping
    fun findClients(): List<Rooms> =roomrepository.findAll();

    @GetMapping("/{id}")
    fun findClientsid(@PathVariable id:String): Rooms =roomrepository.findById(id);
//
//    @PostMapping
//    fun addRoom(@RequestBody room_id: Rooms) = roomrepository.update(room_id);

    @DeleteMapping("/{id}")
    fun deleteRoom(@PathVariable id: String)=roomrepository.deleteById(id);
}