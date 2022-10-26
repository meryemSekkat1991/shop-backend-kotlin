package com.meryem.shoppingkotlin.entity

import lombok.Data
import javax.persistence.*

@Entity
@Table(name = "state")
@Data
class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private val id = 0

    @Column(name = "name")
    private val name: String? = null

    @ManyToOne
    @JoinColumn(name = "country_id")
    private val country: Country? = null
}
