package mai.dep810.noslq.rep

import mai.dep810.noslq.model.Documents
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Repository

interface RoomReadRepository {

}
@Repository("BookReadRepo")
class BookReadRepo(val mongoOperations: MongoOperations) : RoomReadRepository  {

    fun findById(id: Int): Documents.Books? =mongoOperations.findById(id,Documents.Books::class.java)
}