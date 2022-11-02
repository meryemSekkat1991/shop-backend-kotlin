package com.meryem.shoppingkotlin.service

import com.meryem.shoppingkotlin.repository.ProductRepository
import com.meryem.shoppingkotlin.entity.Product
import org.springframework.stereotype.Service

@Service
class ProductService( val productRepository: ProductRepository) {
    fun getAll() =  productRepository.findAll()

    fun saveProduct(product: Product) = productRepository.save(product)

    fun findById(productId: Long) = productRepository.findById(productId)
}
