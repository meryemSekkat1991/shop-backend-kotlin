package com.meryem.shoppingkotlin.dao


import com.meryem.shoppingkotlin.entity.Product
import org.springframework.data.domain.Page

import org.springframework.data.domain.Pageable

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

import org.springframework.web.bind.annotation.CrossOrigin

import org.springframework.web.bind.annotation.RequestParam


@CrossOrigin("http://localhost:3000")
interface ProductRepository : JpaRepository<Product?, Long?> {
    fun findByCategoryId(@RequestParam("id") id: Long?, pageable: Pageable?): Page<Product?>?
    fun findByNameContaining(@RequestParam("name") name: String?, pageable: Pageable?): Page<Product?>?

    fun findByNameContaining(courseName : String) : List<Product>
    @Query(value = "SELECT * FROM COURSES where name like %?1%", nativeQuery = true)
    fun findProductsByName(courseName : String) : List<Product>
}
