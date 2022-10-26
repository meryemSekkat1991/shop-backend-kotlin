package com.meryem.shoppingkotlin.config

import com.meryem.shoppingkotlin.entity.Country
import com.meryem.shoppingkotlin.entity.Product
import com.meryem.shoppingkotlin.entity.ProductCategory
import com.meryem.shoppingkotlin.entity.State
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.core.mapping.ConfigurableHttpMethods
import org.springframework.data.rest.core.mapping.ResourceMetadata
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.http.HttpMethod
import javax.persistence.EntityManager

@Configuration
class MyDataRestConfig @Autowired constructor(private val entityManager: EntityManager) : RepositoryRestConfigurer {
    fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
        val theUnsupportedActions = arrayOf(HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE)

        // disable HTTP methods for ProductCategory: PUT, POST and DELETE
        disableHttpMethods(Product::class.java, config, theUnsupportedActions)
        disableHttpMethods(ProductCategory::class.java, config, theUnsupportedActions)
        disableHttpMethods(Country::class.java, config, theUnsupportedActions)
        disableHttpMethods(State::class.java, config, theUnsupportedActions)

        // call an internal helper method
        exposeIds(config)
    }

    private fun disableHttpMethods(
        theClass: Class<*>,
        config: RepositoryRestConfiguration,
        theUnsupportedActions: Array<HttpMethod>
    ) {
        config.exposureConfiguration
            .forDomainType(theClass)
            .withItemExposure { metdata: ResourceMetadata?, httpMethods: ConfigurableHttpMethods ->
                httpMethods.disable(
                    *theUnsupportedActions
                )
            }
            .withCollectionExposure { metdata: ResourceMetadata?, httpMethods: ConfigurableHttpMethods ->
                httpMethods.disable(
                    *theUnsupportedActions
                )
            }
    }

    private fun exposeIds(config: RepositoryRestConfiguration) {

        // expose entity ids
        //

        // - get a list of all entity classes from the entity manager
        val entities = entityManager.metamodel.entities

        // - create an array of the entity types
        val entityClasses: MutableList<Class<*>> = ArrayList()

        // - get the entity types for the entities
        for (tempEntityType in entities) {
            entityClasses.add(tempEntityType.javaType)
        }

        // - expose the entity ids for the array of entity/domain types
        val domainTypes = entityClasses.toTypedArray()
        config.exposeIdsFor(*domainTypes)
    }
}
