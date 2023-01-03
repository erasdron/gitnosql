package mai.dep810.noslq.api
import mai.dep810.noslq.model.Data.Book
import mai.dep810.noslq.model.Documents
import mai.dep810.noslq.rep.BookRepository
import mai.dep810.noslq.service.BookServ
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController(val bookrepository: BookServ) {
    @GetMapping
    fun find(): List<Documents.Books> =bookrepository.findAll();

    @GetMapping("/{id}")
    fun findBookingsId (@PathVariable id:String): Documents.Books =bookrepository.findById(id);

//    @PostMapping
//    fun addBookings(@RequestBody book: Book) = bookrepository.addBook(book);

    @DeleteMapping("api/book/delete/{id}")
    fun deleteBookings(@PathVariable id: String)=bookrepository.deleteById(id);

}