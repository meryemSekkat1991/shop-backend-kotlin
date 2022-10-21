package com.meryem.shoppingkotlin.config

import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.http.HttpMethod
import com.meryem.shoppingkotlin.entity.Product
import org.springframework.data.rest.core.mapping.ExposureConfigurer.AggregateResourceHttpMethodsFilter
import org.springframework.data.rest.core.mapping.ResourceMetadata
import org.springframework.data.rest.core.mapping.ConfigurableHttpMethods
import com.meryem.shoppingkotlin.entity.ProductCategory
import org.springframework.context.annotation.Configuration

@Configuration
class MyDataRestConfig : RepositoryRestConfigurer {
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration, cors: CorsRegistry) {
        val theUnsupportedActions = arrayOf(HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH)

        // disable HTTP methods for Product: PUT, POST, DELETE and PATCH
        config.exposureConfiguration
            .forDomainType(Product::class.java)
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

        // disable HTTP methods for ProductCategory: PUT, POST, DELETE and PATCH
        config.exposureConfiguration
            .forDomainType(ProductCategory::class.java)
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
}
