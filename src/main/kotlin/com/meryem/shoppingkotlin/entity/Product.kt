package com.meryem.shoppingkotlin.entity
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    val sku: String? = "",
    val description: String = "",
    val price: BigDecimal,
    @Transient
    val price_total: BigDecimal,
    val unit_price: String,
    val image_url: String = ""
)



