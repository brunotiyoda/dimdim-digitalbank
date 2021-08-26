package com.fiap.dimdim.dimdim.repositories.entities

import java.time.Instant
import javax.persistence.CascadeType.MERGE
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class BankStatementEntity(
    val balance: Double = 0.0,

    @Enumerated(EnumType.STRING)
    val operationTypeEnum: OperationTypeEnum = OperationTypeEnum.NOTHING,

    val createAt: Instant = Instant.now(),

    @ManyToOne(cascade = [MERGE])
    @JoinColumn(name = "bank_account_id")
    val bankAccountEntity: BankAccountEntity? = null
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
}