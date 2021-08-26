package com.fiap.dimdim.dimdim.services

import com.fiap.dimdim.dimdim.controllers.response.PrintBankStatementResponse
import com.fiap.dimdim.dimdim.exceptions.CostumerNotFoundException
import com.fiap.dimdim.dimdim.repositories.BankAccountRepository
import com.fiap.dimdim.dimdim.repositories.BankStatementRepository
import com.fiap.dimdim.dimdim.repositories.CostumerRepository
import org.springframework.stereotype.Service

@Service
class BankStatementService(
    private val bankAccountRepository: BankAccountRepository,
    private val bankStatementRepository: BankStatementRepository,
    private val costumerRepository: CostumerRepository,
    private val dataCostumerService: DataCostumerService
) {

    fun print(document: String): List<PrintBankStatementResponse> {
        val costumer = costumerRepository.findByDocument(document)
            .orElseThrow { throw CostumerNotFoundException() }

        val bankAccount = dataCostumerService.findByCostumerId(costumer)

        return bankStatementRepository.findByBankAccountEntity(bankAccount)
            .map {
               PrintBankStatementResponse(
                   at = it.createAt,
                   balance = it.balance,
                   operation = it.operationTypeEnum.name
               )
            }
    }
}