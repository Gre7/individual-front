package ru.nino.individual.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class ImageEntity(
    @Id
    @GeneratedValue
    var id: Long?,
    var bytes: ByteArray = byteArrayOf()
) {
    constructor() : this(null)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImageEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }


    companion object NONE {
        val EMPTY_IMAGE = ImageEntity(0, byteArrayOf())

    }

}
