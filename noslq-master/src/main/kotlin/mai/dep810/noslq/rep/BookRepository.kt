package mai.dep810.noslq.rep
import mai.dep810.noslq.model.Data.Book
import mai.dep810.noslq.model.Documents.Books
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping

@Repository("bookrepository")

public interface BookRepository : MongoRepository<Books, String> {

    companion object{
    fun findById(id: String): Books {
        return findById(id)
    }
    }
}
