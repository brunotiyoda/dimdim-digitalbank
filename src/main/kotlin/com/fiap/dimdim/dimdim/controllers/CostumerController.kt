package com.fiap.dimdim.dimdim.controllers

import com.fiap.dimdim.dimdim.controllers.response.CostumerDataResponse
import com.fiap.dimdim.dimdim.services.CostumerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/costumers")
class CostumerController(
    private val costumerService: CostumerService
) {

    @GetMapping("{document}/my-data")
    fun myData(@PathVariable document: String): ResponseEntity<CostumerDataResponse> {
        return ResponseEntity.ok().body(costumerService.getDataCostumer(document))
    }

}