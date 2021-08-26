package com.fiap.dimdim.dimdim.repositories.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class CostumerEntity(
    val name: String,

    val document: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
}