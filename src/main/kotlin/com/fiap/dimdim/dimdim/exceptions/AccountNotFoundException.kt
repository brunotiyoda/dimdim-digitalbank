package com.fiap.dimdim.dimdim.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class AccountNotFoundException(message: String? = "") : RuntimeException(message) {
}
