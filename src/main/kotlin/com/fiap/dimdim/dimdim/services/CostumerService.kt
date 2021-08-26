package com.fiap.dimdim.dimdim.services

import com.fiap.dimdim.dimdim.controllers.response.CostumerDataResponse
import com.fiap.dimdim.dimdim.exceptions.CostumerNotFoundException
import com.fiap.dimdim.dimdim.repositories.CostumerRepository
import org.springframework.stereotype.Service

@Service
class CostumerService(
    private val costumerRepository: CostumerRepository,
    private val dataCostumerService: DataCostumerService
) {

    fun getDataCostumer(document: String): CostumerDataResponse {
        val costumer = costumerRepository.findByDocument(document)
            .orElseThrow { throw CostumerNotFoundException() }

        val bankAccountCostumer = dataCostumerService.findByCostumerId(costumer)

        return CostumerDataResponse(
            name = costumer.name,
            agency = bankAccountCostumer.agency,
            account = bankAccountCostumer.account,
            accountType = bankAccountCostumer.accountTypeEnum.name,
            serviceProvided = bankAccountCostumer.servicesProvidedEnum.name
        )
    }

}