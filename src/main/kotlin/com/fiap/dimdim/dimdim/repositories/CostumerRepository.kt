package com.fiap.dimdim.dimdim.repositories

import com.fiap.dimdim.dimdim.repositories.entities.CostumerEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CostumerRepository : JpaRepository<CostumerEntity, Int> {
    fun findByDocument(document: String): Optional<CostumerEntity>
}