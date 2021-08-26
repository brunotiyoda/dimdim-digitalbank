package com.fiap.dimdim.dimdim.repositories

import com.fiap.dimdim.dimdim.repositories.entities.BankAccountEntity
import com.fiap.dimdim.dimdim.repositories.entities.CostumerEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BankAccountRepository : JpaRepository<BankAccountEntity, Int> {
    fun findByAccount(account: String): Optional<BankAccountEntity>
    fun findByOwner(id: CostumerEntity): Optional<BankAccountEntity>
}