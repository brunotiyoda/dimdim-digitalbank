package com.fiap.dimdim.dimdim.repositories

import com.fiap.dimdim.dimdim.repositories.entities.BankAccountEntity
import com.fiap.dimdim.dimdim.repositories.entities.BankStatementEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BankStatementRepository : JpaRepository<BankStatementEntity, Int> {

    fun findByBankAccountEntity(bankAccountEntity: BankAccountEntity): List<BankStatementEntity>
}