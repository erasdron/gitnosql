package mai.dep810.noslq.service

import org.jetbrains.annotations.NotNull


class RoomRequest (
    @get:NotNull val room_id : String?,
    @get:NotNull val room_name: String?,
    @get:NotNull val country: String?,
    @get:NotNull val room_type: String?,
    @get:NotNull val price: String?
)