package com.fiap.dimdim.dimdim.controllers

import com.fiap.dimdim.dimdim.controllers.response.PrintBankStatementResponse
import com.fiap.dimdim.dimdim.services.BankStatementService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("bank-statements")
class BankStatementController(
    private val bankStatementService: BankStatementService
) {

    @GetMapping("{document}/print")
    fun printBankStatement(@PathVariable document: String): ResponseEntity<List<PrintBankStatementResponse>> {
        val print = bankStatementService.print(document)
        return ResponseEntity.ok().body(print)
    }
}