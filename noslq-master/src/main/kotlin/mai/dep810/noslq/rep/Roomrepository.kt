package mai.dep810.noslq.rep
import mai.dep810.noslq.model.Data
import mai.dep810.noslq.model.Data.Room
import mai.dep810.noslq.model.Documents
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository





@Repository("roomrepository")
public interface Roomrepository : MongoRepository<Documents.Rooms, String> {

}





