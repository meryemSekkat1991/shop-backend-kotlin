package com.meryem.shoppingkotlin.controller

import com.meryem.shoppingkotlin.entity.ProductCategory
import com.meryem.shoppingkotlin.service.ProductCategoryService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
class ProductCategoryController(private val ProductCategoryService: ProductCategoryService) {
    @GetMapping("/productCategories")
    fun getAll(): List<ProductCategory> = ProductCategoryService.getAll()


    @PostMapping("/productCategories")
    fun createProductCategory(@RequestBody productCategory: ProductCategory): ProductCategory = ProductCategoryService.saveProduct(productCategory)

}
