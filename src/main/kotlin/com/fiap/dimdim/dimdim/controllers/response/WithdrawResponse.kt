package com.fiap.dimdim.dimdim.controllers.response

import java.time.Instant

class WithdrawResponse(
    val withdrawRequested: Double,
    val newBalance: Double?,
    val at: Instant
)