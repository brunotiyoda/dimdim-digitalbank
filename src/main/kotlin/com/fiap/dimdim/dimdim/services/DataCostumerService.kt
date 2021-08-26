package com.fiap.dimdim.dimdim.services

import com.fiap.dimdim.dimdim.exceptions.AccountNotFoundException
import com.fiap.dimdim.dimdim.repositories.BankAccountRepository
import com.fiap.dimdim.dimdim.repositories.entities.BankAccountEntity
import com.fiap.dimdim.dimdim.repositories.entities.CostumerEntity
import org.springframework.stereotype.Service

@Service
class DataCostumerService(
    private val bankAccountRepository: BankAccountRepository
) {

    fun findByCostumerId(costumer: CostumerEntity): BankAccountEntity = bankAccountRepository.findByOwner(costumer)
        .orElseThrow { throw AccountNotFoundException() }
}