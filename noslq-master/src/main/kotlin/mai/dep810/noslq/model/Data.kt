package mai.dep810.noslq.model

import java.io.InputStream

class Data {
    data class Client(
        var client_id: String,
        var name: String
    )

    data class Room(
        var room_id: String,
        var type: String,
        var price: String,
        var maximum_nights:String,
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
        fun readCsv(inputStream: InputStream): List<Data.Client> {
            val reader = inputStream.bufferedReader()
            val header = reader.readLine()
            return reader.lineSequence()
                .filter { it.isNotBlank() }
                .map {
                    val (client_id, client_name) = it.split(';', ignoreCase = false, limit = 2)
                    Data.Client(client_id, client_name)
                }.toList()
        }
        fun readC(inputStream: InputStream): List<Data.Book>{
            val read=inputStream.bufferedReader()
            val head=read.readLine()
            return read.lineSequence()
                .filter { it.isNotBlank() }
                .map {
                    val (book_id, room_id, client_id, book_date, book_status) = it.split(';', ignoreCase = false, limit = 5)
                    Data.Book(book_id, room_id, client_id, book_date, book_status)
                }.toList()

        }
        fun readCs(inputStream: InputStream): List<Data.Room> {
            val read = inputStream.bufferedReader()
            val head = read.readLine()
            return read.lineSequence()
                .filter { it.isNotBlank() }
                .map {
                    val (room_id, type, price, maximum_nights, country) = it.split(';', ignoreCase = false, limit = 5)
                    Data.Room(room_id, type, price, maximum_nights, country)
                }.toList()
        }

        }

    }


