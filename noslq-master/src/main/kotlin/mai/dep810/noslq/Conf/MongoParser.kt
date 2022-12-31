package mai.dep810.noslq.Conf

import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import com.mongodb.client.model.InsertOneModel
import mai.dep810.noslq.model.Data
import org.bson.Document

const val databaseName = "booking"
const val usersFile = "database/users.csv"

fun inp(mongoClient: MongoClient) {
    val usersStream = {}.javaClass.classLoader.getResourceAsStream(usersFile)
    val clients = Data.readCsv(usersStream)
    val migrations = mongoClient
        .getDatabase(databaseName)
        .getCollection("migrations")

    val usersMigrations = migrations.find(Filters.eq("file", usersFile))

    if(!usersMigrations.any()){
        mongoClient
            .getDatabase(databaseName)
            .getCollection("users")
            .bulkWrite(clients
                .map {
                    val documentMap = mapOf(
                        "client_id" to it.client_id,
                        "name" to it.name
                    )
                    InsertOneModel(Document(documentMap))
                })

        migrations.insertOne(
            Document(mapOf(
            "file" to usersFile
        ))
        )
    }
    /*	val inputStr = FileInputStream(File("D:\\download\\data\\books.csv"))
            val books= Data.readC((inputStr))
            books.forEach {
                println(it)
            }*/

}
