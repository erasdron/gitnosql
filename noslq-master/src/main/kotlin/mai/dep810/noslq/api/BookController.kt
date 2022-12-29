package mai.dep810.noslq.api
import mai.dep810.noslq.model.Data.Book
import mai.dep810.noslq.rep.BookRepository
import org.springframework.web.bind.annotation.*

@RestController

class BookController(val bookrepository: BookRepository) {
    @GetMapping("/api/book/find")
    fun find(): List<Book> =bookrepository.findAll();

    @GetMapping("api/book/{id}")
    fun findBookingsId (@PathVariable id:String): Book?=bookrepository.findBookById(id);

    @PostMapping("api/book/add")
    fun addBookings(@RequestBody book: Book) = bookrepository.addBook(book);

    @DeleteMapping("api/book/delete/{id}")
    fun deleteBookings(@PathVariable id: String)=bookrepository.deleteBook(id);

}