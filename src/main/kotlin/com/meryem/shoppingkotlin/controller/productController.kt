package com.meryem.shoppingkotlin.controller

import com.meryem.shoppingkotlin.entity.Product
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import service.ProductService
import javax.validation.Valid
import java.util.List
import java.util.Set

@RestController
@RequestMapping("/products")
@Controller
class productController {
    var productService: ProductService? = null
    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long?): ResponseEntity<Product> {
        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    fun saveProduct(@Valid @RequestBody product: Product?): ResponseEntity<Product> {
        return ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long?): ResponseEntity<HttpStatus> {
        productService.deleteProduct(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @get:GetMapping("/all")
    val products: ResponseEntity<List<Product>>
        get() = ResponseEntity(productService.getProducts(), HttpStatus.OK)

    @PutMapping("/{productId}/productCategory/{productCategoryId}")
    fun enrollStudentToProduct(
        @PathVariable productId: Long?,
        @PathVariable productCategoryId: Long?
    ): ResponseEntity<Product> {
        return ResponseEntity(productService.addProductToProduct(productCategoryId, productId), HttpStatus.OK)
    }

    @GetMapping("/products/{id}/category")
    fun getEnrolledStudents(@PathVariable id: Long?): ResponseEntity<Set<Product>> {
        return ResponseEntity(HttpStatus.OK)
    }
}
