package com.fiap.dimdim.dimdim.controllers.request

class WithdrawRequest(
    val value: Double,
    override val accountNumber: String
) : BankingMovement {

}
