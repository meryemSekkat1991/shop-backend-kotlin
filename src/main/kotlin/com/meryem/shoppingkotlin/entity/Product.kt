package com.meryem.shoppingkotlin.entity

import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "product")
@Data
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private val id: Long? = null

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private val category: ProductCategory? = null

    @Column(name = "sku")
    private val sku: String? = null

    @Column(name = "name")
    private val name: String? = null

    @Column(name = "description")
    private val description: String? = null

    @Column(name = "unit_price")
    private val unitPrice: BigDecimal? = null

    @Column(name = "image_url")
    private val imageUrl: String? = null

    @Column(name = "active")
    private val active = false

    @Column(name = "units_in_stock")
    private val unitsInStock = 0

    @Column(name = "date_created")
    @CreationTimestamp
    private val dateCreated: Date? = null

    @Column(name = "last_updated")
    @UpdateTimestamp
    private val lastUpdated: Date? = null
}
