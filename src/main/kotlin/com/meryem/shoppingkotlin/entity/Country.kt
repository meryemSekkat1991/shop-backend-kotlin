package com.meryem.shoppingkotlin.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "country")
@Getter
@Setter
class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private val id = 0

    @Column(name = "code")
    private val code: String? = null

    @Column(name = "name")
    private val name: String? = null

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private val Listes: List<State>? = null
}
