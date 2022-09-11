package ru.nino.individual.entity

import ru.nino.individual.controller.ImageController
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Company(
    @Id
    @GeneratedValue
    var id: Long?,
    var name: String = "",
    var description: String = "",
    @OneToMany(cascade = [CascadeType.ALL])
    var actions: MutableList<Action> = mutableListOf(),
    @OneToMany
    var imageEntity: MutableList<ImageEntity> = mutableListOf()

) {
    constructor() : this(null) {}

    companion object {
        val EMPTY = Company(0)
    }
}
