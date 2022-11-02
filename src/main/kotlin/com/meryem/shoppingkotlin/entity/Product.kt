package com.meryem.shoppingkotlin.entity
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    val sku: String? = "",
    val description: String = "",
    val price: Int = 0,
    val unit_price: Int = 0,
    val image_url: String = ""
)



