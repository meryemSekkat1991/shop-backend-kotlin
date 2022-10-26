package com.meryem.shoppingkotlin.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "address")
@Getter
@Setter
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private val id: Long? = null

    @Column(name = "street")
    private val street: String? = null

    @Column(name = "city")
    private val city: String? = null

    @Column(name = "state")
    private val state: String? = null

    @Column(name = "country")
    private val country: String? = null

    @Column(name = "zip_code")
    private val zipCode: String? = null
}
