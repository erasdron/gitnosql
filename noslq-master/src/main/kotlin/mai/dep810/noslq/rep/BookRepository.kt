package mai.dep810.noslq.rep
import mai.dep810.noslq.model.Data.Book
import mai.dep810.noslq.model.Documents
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping

@Repository("bookrepository")

public interface BookRepository : MongoRepository<Documents.Books, String> {

}
