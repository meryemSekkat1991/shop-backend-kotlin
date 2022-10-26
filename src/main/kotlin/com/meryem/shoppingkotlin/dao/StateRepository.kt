package com.meryem.shoppingkotlin.dao

import com.meryem.shoppingkotlin.entity.State
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin
import java.util.List

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
interface StateRepository : JpaRepository<State?, Integer?> {
    fun findByCountryCode(@Param("code") code: String?): List<State?>?
}
