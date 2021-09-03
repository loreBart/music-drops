package com.crazy.musicdrops.model

import com.crazy.musicdrops.model.serialization.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class MusicDrop(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID? = null,
    @Serializable(with = UUIDSerializer::class)
    val userId: UUID,
    val name: String,
    val author: String,
    val genre: Genre = Genre.UNKNOWN,
    val blob: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MusicDrop

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()

}
