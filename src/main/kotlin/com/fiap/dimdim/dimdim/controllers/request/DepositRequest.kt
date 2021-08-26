package com.fiap.dimdim.dimdim.controllers.request

class DepositRequest(
    val value: Double,
    override val accountNumber: String
) : BankingMovement {
}