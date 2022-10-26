package com.meryem.shoppingkotlin.dao

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.data.jpa.repository.JpaRepository
import com.meryem.shoppingkotlin.entity.Product

@CrossOrigin("http://localhost:3000")
interface ProductRepository : JpaRepository<Product?, Long?>
