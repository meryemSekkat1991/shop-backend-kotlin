package com.meryem.shoppingkotlin.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "product_category") // @Data -- known bug
@Getter
@Setter
class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private val id: Long? = null

    @Column(name = "category_name")
    private val categoryName: String? = null

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "category")
    private val products: Set<Product>? = null
}
