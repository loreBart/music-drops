package com.crazy.musicdrops.model

import com.crazy.musicdrops.model.serialization.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class User(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID? = null,
    val user: String,
    val password: String
) {
    override fun toString(): String = "($id) $user password: $password"
}
