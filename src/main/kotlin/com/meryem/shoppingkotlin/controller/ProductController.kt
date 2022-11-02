package com.meryem.shoppingkotlin.controller

import com.meryem.shoppingkotlin.dto.ProductDTO
import com.meryem.shoppingkotlin.entity.Product
import com.meryem.shoppingkotlin.service.ProductService
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ProductController(private val productService: ProductService) {
    @GetMapping("/products")
    fun getAll(): List<Product> = productService.getAll()


    @PostMapping("/products")
    fun createProduct(@RequestBody product: Product): Product = productService.saveProduct(product)

}
