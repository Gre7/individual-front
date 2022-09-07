package ru.nino.individual.entity

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
    var actions: MutableList<Action> = mutableListOf()


) {
    constructor() : this(null) {}
}
