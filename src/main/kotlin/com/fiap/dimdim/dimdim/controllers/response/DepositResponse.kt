package com.fiap.dimdim.dimdim.controllers.response

import java.time.Instant

class DepositResponse(
    val depositRequested: Double,
    val newBalance: Double?,
    val at: Instant
) {
}