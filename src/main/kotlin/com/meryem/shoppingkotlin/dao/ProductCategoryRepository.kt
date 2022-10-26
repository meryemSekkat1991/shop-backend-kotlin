package com.meryem.shoppingkotlin.dao

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.jpa.repository.JpaRepository
import com.meryem.shoppingkotlin.entity.ProductCategory

@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
interface ProductCategoryRepository : JpaRepository<ProductCategory?, Long?>
