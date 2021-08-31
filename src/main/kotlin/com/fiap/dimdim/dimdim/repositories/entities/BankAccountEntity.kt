package com.fiap.dimdim.dimdim.repositories.entities

import javax.persistence.CascadeType.ALL
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
data class BankAccountEntity(
    val agency: String = "0001",

    @Column(unique = true)
    val account: String,

    var balance: Double = 0.0,

    var previousBalance: Double? = 0.0,

    @OneToOne(cascade = [ALL])
    @JoinColumn(name = "costumer_id", referencedColumnName = "id")
    val owner: CostumerEntity,

    @Enumerated(EnumType.STRING)
    val accountTypeEnum: AccountTypeEnum = AccountTypeEnum.CURRENT_ACCOUNT,

    @Enumerated(EnumType.STRING)
    val servicesProvidedEnum: ServicesProvidedEnum = ServicesProvidedEnum.PAY_ACCOUNT,

    @OneToMany(cascade = [ALL])
    var bankStatementEntity: List<BankStatementEntity>? = emptyList()
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
}