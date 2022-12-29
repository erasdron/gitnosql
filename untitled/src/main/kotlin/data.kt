import java.io.InputStream

class Data {
    data class Client(
        var client_id: String,
        var name: String
    )

    data class Room(
        var room_id: String,
        var name: String,
        var neighbourhood: String,
        var type: String,
        var price: String,
        var city: String,
        var country: String
    )

    data class Book(
        var book_id: String,
        var room_id: String,
        var client_id: String,
        var book_date: String,
        var book_status: String
    )
    companion object {
        fun readCsv(inputStream: InputStream): List<Client> {
            val reader = inputStream.bufferedReader()
            val header = reader.readLine()
            return reader.lineSequence()
                .filter { it.isNotBlank() }
                .map {
                    val (client_id, client_name) = it.split(';', ignoreCase = false, limit = 2)
                    Client(client_id, client_name)
                }.toList()
        }

           }
}
