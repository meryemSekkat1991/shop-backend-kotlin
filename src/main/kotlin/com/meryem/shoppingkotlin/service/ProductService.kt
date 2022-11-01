package com.meryem.shoppingkotlin.service

import com.meryem.shoppingkotlin.dao.ProductRepository
import com.meryem.shoppingkotlin.dto.ProductDTO
import org.springframework.stereotype.Service

@Service
class ProductService( val productRepository: ProductRepository) {
    fun addProduct(productDTO: ProductDTO){

    }

}
