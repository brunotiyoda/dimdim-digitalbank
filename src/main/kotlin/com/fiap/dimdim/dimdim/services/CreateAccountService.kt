package com.fiap.dimdim.dimdim.services

import com.fiap.dimdim.dimdim.controllers.request.CreateAccountRequest
import com.fiap.dimdim.dimdim.exceptions.ThereIsCostumerException
import com.fiap.dimdim.dimdim.repositories.BankAccountRepository
import com.fiap.dimdim.dimdim.repositories.entities.BankAccountEntity
import com.fiap.dimdim.dimdim.repositories.entities.CostumerEntity
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class CreateAccountService(
    private val bankAccountRepository: BankAccountRepository,
    private val costumerService: CostumerService
) {

    fun createBankAccount(dataCostumer: CreateAccountRequest): BankAccountEntity {

        val thereIsCostumer = costumerService.findCostumerByDocument(dataCostumer.document)

        if (thereIsCostumer.isPresent) {
            throw ThereIsCostumerException("Exist Costumer registered: ${dataCostumer.name}")
        }

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