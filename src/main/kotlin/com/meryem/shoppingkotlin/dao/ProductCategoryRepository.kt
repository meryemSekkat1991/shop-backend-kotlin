package com.meryem.shoppingkotlin.dao

import com.meryem.shoppingkotlin.entity.ProductCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
interface ProductCategoryRepository : JpaRepository<ProductCategory?, Long?>
