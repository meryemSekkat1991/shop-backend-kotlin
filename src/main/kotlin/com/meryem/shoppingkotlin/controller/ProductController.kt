package com.meryem.shoppingkotlin.controller

import com.meryem.shoppingkotlin.dto.ProductDTO
import com.meryem.shoppingkotlin.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus

class ProductController(val productService: ProductService) {
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody productDTO: ProductDTO) {
       productService.addProduct(productDTO)
    }

}
