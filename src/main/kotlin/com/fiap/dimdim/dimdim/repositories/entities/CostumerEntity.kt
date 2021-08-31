package com.fiap.dimdim.dimdim.repositories.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class CostumerEntity(
    val name: String,

    @Column(unique = true)
    val document: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
}