package com.meryem.shoppingkotlin.dto

import java.math.BigDecimal


data class ProductDTO (
    val id : Long,
    val name : String,
    val sku: String?,
    val description: String,
    val price: BigDecimal,
    val image_url: String
)
