package mai.dep810.noslq.rep

import mai.dep810.noslq.model.Data.Client
import mai.dep810.noslq.model.Documents
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping

@Repository("clientRepository")
public interface Clientrepository : MongoRepository<Documents.Users, String> {

}
