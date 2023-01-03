package mai.dep810.noslq.Conf

import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import com.mongodb.client.model.InsertOneModel
import mai.dep810.noslq.model.Data.Client
import mai.dep810.noslq.model.Data.Book
import mai.dep810.noslq.model.Data.Room
import mai.dep810.noslq.model.Data
import org.bson.Document

const val databaseName = "air"
const val usersFile = "database/users.csv"
const val booksFile="database/books.csv"
const val roomsFile="database/rooms.csv"

fun inp(mongoClient: MongoClient) {
    val usersStream = {}.javaClass.classLoader.getResourceAsStream(usersFile)
    val clients = Data.readCsv(usersStream)
    val migrations = mongoClient
        .getDatabase(databaseName)
        .getCollection("migrations")

    val usersMigrations = migrations.find(Filters.eq("file", usersFile))

    if (!usersMigrations.any()) {
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
            Document(
                mapOf(
                    "file" to usersFile
                )
            )
        )
    }
}
fun inpstr(mongoClient: MongoClient) {
    val booksStream = {}.javaClass.classLoader.getResourceAsStream(booksFile)
    val books = Data.readC(booksStream)
    val migrations = mongoClient
        .getDatabase(databaseName)
        .getCollection("migrations")

    val booksMigrations = migrations.find(Filters.eq("file", booksFile))

    if(!booksMigrations.any()) {
        mongoClient
            .getDatabase(databaseName)
            .getCollection("books")
            .bulkWrite(books
                .map {
                    val documentM = mapOf(
                        "book_id" to it.book_id,
                        "client_id" to it.client_id,
                        "book_status" to it.book_status,
                        "room_id" to it.room_id,
                        "book_date" to it.book_date
                    )
                    InsertOneModel(Document(documentM))
                })

        migrations.insertOne(
            Document(
                mapOf(
                    "file" to booksFile
                )
            )
        )
    }
}

fun inpstrn(mongoClient: MongoClient) {
    val roomsStream = {}.javaClass.classLoader.getResourceAsStream(roomsFile)
    val rooms = Data.readCs(roomsStream)
    val migrations = mongoClient
        .getDatabase(databaseName)
        .getCollection("migrations")

    val roomsMigrations = migrations.find(Filters.eq("file", roomsFile))

    if (!roomsMigrations.any()) {
        mongoClient
            .getDatabase(databaseName)
            .getCollection("room")
            .bulkWrite(rooms
                .map {
                    val documentMr = mapOf(
                        "room_id" to it.room_id,
                        "country" to it.type,
                        "price" to it.maximum_nights,
                        "maximum_nights" to it.price,
                        "type" to it.country
                    )
                    InsertOneModel(Document(documentMr))
                })

        migrations.insertOne(
            Document(
                mapOf(
                    "file" to roomsFile
                )
            )
        )
    }
}

