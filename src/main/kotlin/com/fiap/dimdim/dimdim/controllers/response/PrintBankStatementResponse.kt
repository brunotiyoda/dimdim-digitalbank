package com.fiap.dimdim.dimdim.controllers.response

import java.time.Instant

class PrintBankStatementResponse(
    val at: Instant,
    val balance: Double,
    val operation: String
) {
}