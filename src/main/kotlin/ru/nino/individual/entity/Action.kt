package ru.nino.individual.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Action(
    @Id
    @GeneratedValue val id: Long?,
    val name: String = "",
    val description: String = "",
    val price: Double = Double.MIN_VALUE
) {
    constructor() : this(null) {

    }

}
