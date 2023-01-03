package mai.dep810.noslq.model

import mai.dep810.noslq.rep.RoomReadRepository
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Persistent
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

class Documents {

   data class RoomToUpdate(
       val id: String?,
       val room_type: String?,
       val country: String?,
       val price: String?,
       val room_name: String?
   )
    data class Room(
        val id: String,
        val room_type: String,
        val country: String,
        val price: String,
        val room_name: String
    )

    fun Rooms.toRoom(): Room=Room(
        this.room_id!!,
        this.room_type!!,
        this.country!!,
        this.price!!,
        this.room_name!!
    )

    data class Book(
        val book_id: String,
        val book_date: String,
        val price: String,
        val minimum_nights: String,
        val maximum_nights: String,
        val client_id: String
    )

    fun Books.toBook(): Books =Books(
        this.book_id!!,
        this.book_date!!,
        this.client_id!!,
        this.book_status!!,
        this.room_id!!

    )
    @Document("rooms")
    data class Rooms(
        @Id val room_id: String? = null,
        @Field var room_name: String,
        @Field var room_type: String,
        @Field var country: String,
        @Field var price: String
    )

    @Document("users")
    data class Users(
        @Id
        var client_id: String? = null,
        var name: String
    )

    @Document("books")
    data class Books(
        @Id
        var book_id: String? = null,
        var book_date: String,
        var client_id: String,
        var book_status: String,
        var room_id: String

    )
}
