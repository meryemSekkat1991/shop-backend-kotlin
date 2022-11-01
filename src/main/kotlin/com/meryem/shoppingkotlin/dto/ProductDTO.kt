package com.meryem.shoppingkotlin.dto

import com.meryem.shoppingkotlin.entity.ProductCategory
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.util.*

data class ProductDTO(
    val id : Int?,
    val name : String,
    val category: ProductCategory? = null,
    val sku: String? = null,
    val description: String? = null,
    val unitPrice: BigDecimal? = null,
    val imageUrl: String? = null,
    val active: Boolean,
    val unitsInStock: Int,
    val dateCreated: Date? = null,
    val lastUpdated: Date? = null,
)
