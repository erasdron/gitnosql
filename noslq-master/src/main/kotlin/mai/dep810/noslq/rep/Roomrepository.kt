package mai.dep810.noslq.rep

import mai.dep810.noslq.model.Documents
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository: MongoRepository<Documents.Rooms, String>
