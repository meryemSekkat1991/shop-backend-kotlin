package com.meryem.shoppingkotlin.service

import com.meryem.shoppingkotlin.entity.ProductCategory
import com.meryem.shoppingkotlin.repository.ProductCategoryRepository
import org.springframework.stereotype.Service

@Service
class ProductCategoryService(val productCategoryRepository: ProductCategoryRepository) {
    fun getAll() =  productCategoryRepository.findAll()

    fun saveProduct(productCategory: ProductCategory) = productCategoryRepository.save(productCategory)
}
