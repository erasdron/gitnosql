package mai.dep810.noslq.rep
import mai.dep810.noslq.model.Data.Book
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping

@Repository("bookrepository")

class BookRepository {
    private val booking: MutableList<Book> = mutableListOf(
      
    )

    fun findAll(): List<Book> = booking;

    fun findBookById(book_id : String): Book?=booking.singleOrNull{it.book_id==book_id}

    fun addBook(book: Book ){
        if(!booking.contains(book)){
            booking.add(book)
        }
    }
    fun deleteBook(book_id: String)=booking.removeIf{it.book_id==book_id}

}
