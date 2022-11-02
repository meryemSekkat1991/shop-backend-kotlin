package com.meryem.shoppingkotlin.repository


import com.meryem.shoppingkotlin.entity.Product

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long?> {}
