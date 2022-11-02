package com.meryem.shoppingkotlin.repository


import com.meryem.shoppingkotlin.entity.ProductCategory

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCategoryRepository : JpaRepository<ProductCategory, Long?> {}
