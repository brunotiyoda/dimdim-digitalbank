package com.fiap.dimdim.dimdim.controllers

import com.fiap.dimdim.dimdim.controllers.request.DepositRequest
import com.fiap.dimdim.dimdim.controllers.request.WithdrawRequest
import com.fiap.dimdim.dimdim.controllers.response.DepositResponse
import com.fiap.dimdim.dimdim.controllers.response.WithdrawResponse
import com.fiap.dimdim.dimdim.services.BankAccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bank-accounts")
class BankAccountController(
    private val bankAccountService: BankAccountService
) {

    @PostMapping("/deposit")
    fun depositFounds(@RequestBody depositRequest: DepositRequest): ResponseEntity<DepositResponse> {
        val deposit = bankAccountService.deposit(depositRequest)
        return ResponseEntity.ok().body(deposit)
    }

    @PostMapping("/withdraw")
    fun withdrawFounds(@RequestBody withdrawRequest: WithdrawRequest): ResponseEntity<WithdrawResponse> {
        val withdraw = bankAccountService.withdraw(withdrawRequest)
        return ResponseEntity.ok().body(withdraw)
    }
}