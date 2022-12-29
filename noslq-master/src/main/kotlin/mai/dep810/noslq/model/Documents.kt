package mai.dep810.noslq.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

class Documents {

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
        var price: String,
        var minimum_nights: String,
        var maximum_nights: String,
        var client_id: String
    )
}