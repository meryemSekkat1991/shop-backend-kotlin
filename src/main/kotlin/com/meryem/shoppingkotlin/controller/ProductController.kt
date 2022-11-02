package com.meryem.shoppingkotlin.controller

import com.meryem.shoppingkotlin.dto.ProductDTO
import com.meryem.shoppingkotlin.entity.Product
import com.meryem.shoppingkotlin.repository.ProductRepository
import com.meryem.shoppingkotlin.service.ProductService
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
class ProductController(private val productService: ProductService, private val productRepository: ProductRepository) {
    @GetMapping("/products")
    fun getAll(): List<Product> = productService.getAll()


    @PostMapping("/products")
    fun createProduct(@RequestBody product: Product): Product = productService.saveProduct(product)

    @GetMapping("/products/{id}")
    fun getArticleById(@PathVariable(value = "id") productId: Long): Optional<Product> = productService.findById(productId)
}
