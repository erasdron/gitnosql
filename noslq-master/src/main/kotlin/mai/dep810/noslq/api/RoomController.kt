package mai.dep810.noslq.api
import mai.dep810.noslq.model.Data.Room
import mai.dep810.noslq.rep.Roomrepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RoomController(val roomrepository: Roomrepository) {
    @GetMapping("/api/room/find")
    fun findClients(): List<Room> =roomrepository.findAll();

    @GetMapping("api/room/{id}")
    fun findClientsid(@PathVariable id:String): Room?=roomrepository.findById(id);

    @PostMapping("api/room/add")
    fun addRoom(@RequestBody room: Room) = roomrepository.addRoom(room);

    @DeleteMapping("api/room/delete/{id}")
    fun deleteRoom(@PathVariable id: String)=roomrepository.deleteRoom(id);

    /*
    @RequestMapping("/api/rooms")

    class RoomController {
        @Autowired private lateinit var roomService: RoomService

        @GetMapping("api/room/all")
       fun findAll(): List<Rooms> = roomService.findAll()

       @GetMapping("/{id}")
        fun findById(@PathVariable("id") id: String):
                Room {
            return roomService.findById(id)
        }


       @PostMapping
        fun createRoom(@Valid @RequestBody request: RoomRequest) =roomService.create(request)


        @DeleteMapping("/{id}")
        fun deleteRoom(@PathVariable id: String)=roomService.deleteById(id);

    */


}