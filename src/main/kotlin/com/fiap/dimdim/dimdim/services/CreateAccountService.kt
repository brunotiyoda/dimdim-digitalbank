package com.fiap.dimdim.dimdim.services

import com.fiap.dimdim.dimdim.controllers.request.CreateAccountRequest
import com.fiap.dimdim.dimdim.repositories.BankAccountRepository
import com.fiap.dimdim.dimdim.repositories.entities.BankAccountEntity
import com.fiap.dimdim.dimdim.repositories.entities.CostumerEntity
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class CreateAccountService(
    private val bankAccountRepository: BankAccountRepository
) {

    fun createBankAccount(dataCostumer: CreateAccountRequest): BankAccountEntity {
        val newAccount = BankAccountEntity(
            account = Random.nextInt(10000000, 99999999).toString(),
            owner = CostumerEntity(
                name = dataCostumer.name,
                document = dataCostumer.document
            )
        )

        return bankAccountRepository.save(newAccount)
    }
}