package com.fiap.dimdim.dimdim.controllers.response

data class CreatedAccountResponse(
    val name: String,
    val accountNumber: String,
    val accountType: String,
    val serviceType: String
) {
}