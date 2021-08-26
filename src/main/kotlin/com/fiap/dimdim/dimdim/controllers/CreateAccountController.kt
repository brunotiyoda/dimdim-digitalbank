package com.fiap.dimdim.dimdim.controllers

import com.fiap.dimdim.dimdim.controllers.request.CreateAccountRequest
import com.fiap.dimdim.dimdim.controllers.response.CreatedAccountResponse
import com.fiap.dimdim.dimdim.services.CreateAccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("create-accounts")
class CreateAccountController(
    private val createAccountService: CreateAccountService
) {

    @PostMapping
    fun createAccount(
        @RequestBody dataCostumer: CreateAccountRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CreatedAccountResponse> {
        val createdAccount = createAccountService.createBankAccount(dataCostumer)

        val uri = uriBuilder
            .path("/costumers/{document}/my-data")
            .buildAndExpand(createdAccount.owner.document)
            .toUri()

        return ResponseEntity.created(uri).body(
            CreatedAccountResponse(
                name = createdAccount.owner.name,
                accountNumber = createdAccount.account,
                accountType = createdAccount.accountTypeEnum.name,
                serviceType = createdAccount.servicesProvidedEnum.name
            )
        )
    }
}