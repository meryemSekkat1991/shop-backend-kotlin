package com.meryem.shoppingkotlin.entity
import javax.persistence.*

@Entity
data class ProductCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
)



