package com.fiap.dimdim.dimdim.services

import com.fiap.dimdim.dimdim.controllers.request.BankingMovement
import com.fiap.dimdim.dimdim.controllers.request.DepositRequest
import com.fiap.dimdim.dimdim.controllers.request.WithdrawRequest
import com.fiap.dimdim.dimdim.controllers.response.DepositResponse
import com.fiap.dimdim.dimdim.controllers.response.WithdrawResponse
import com.fiap.dimdim.dimdim.exceptions.AccountNotFoundException
import com.fiap.dimdim.dimdim.exceptions.InsufficientBalanceException
import com.fiap.dimdim.dimdim.repositories.BankAccountRepository
import com.fiap.dimdim.dimdim.repositories.BankStatementRepository
import com.fiap.dimdim.dimdim.repositories.entities.BankAccountEntity
import com.fiap.dimdim.dimdim.repositories.entities.BankStatementEntity
import com.fiap.dimdim.dimdim.repositories.entities.OperationTypeEnum
import org.springframework.stereotype.Service

@Service
class BankAccountService(
    private val bankAccountRepository: BankAccountRepository,
    private val bankStatementRepository: BankStatementRepository
) {

    fun deposit(request: DepositRequest): DepositResponse {
        val existAccount = checkIfExistAccount(request)
        val newBalance = existAccount.balance.plus(request.value)

        existAccount.previousBalance = existAccount.balance
        existAccount.balance = newBalance

        val bankStatementEntity = BankStatementEntity(
            balance = newBalance,
            operationTypeEnum = OperationTypeEnum.DEPOSIT,
            bankAccountEntity = existAccount
        )
        val save = bankStatementRepository.save(bankStatementEntity)

        return DepositResponse(
            depositRequested = request.value,
            newBalance = save.balance,
            at = save.createAt
        )
    }

    fun withdraw(request: WithdrawRequest): WithdrawResponse {
        val existAccount = checkIfExistAccount(request)
        val newBalance = existAccount.balance.minus(request.value)

        checkSufficientBalance(existAccount)

        existAccount.previousBalance = existAccount.balance
        existAccount.balance = newBalance

        val bankStatementEntity = BankStatementEntity(
            balance = newBalance,
            operationTypeEnum = OperationTypeEnum.WITHDRAW,
            bankAccountEntity = existAccount
        )
        val save = bankStatementRepository.save(bankStatementEntity)

        return WithdrawResponse(
            withdrawRequested = request.value,
            newBalance = save.balance,
            at = save.createAt
        )
    }

    private fun checkSufficientBalance(existAccount: BankAccountEntity) {
        if (existAccount.balance <= 0.0) throw InsufficientBalanceException()
    }

    private fun checkIfExistAccount(request: BankingMovement): BankAccountEntity {
        return bankAccountRepository.findByAccount(request.accountNumber)
            .orElseThrow { throw AccountNotFoundException(request.accountNumber) }
    }
}