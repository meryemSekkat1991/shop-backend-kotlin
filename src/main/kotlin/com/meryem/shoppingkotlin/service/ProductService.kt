package com.meryem.shoppingkotlin.service

import com.meryem.shoppingkotlin.dto.ProductDTO
import com.meryem.shoppingkotlin.entity.Product
import com.meryem.shoppingkotlin.repository.ProductRepository
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.ssl.SSLContextBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils
import org.springframework.web.client.RestTemplate
import javax.net.ssl.SSLContext


@Service
class ProductService( val productRepository: ProductRepository) {
    fun getAll(): List<Product>  {
        val password = "sergey"

        val sslContext: SSLContext = SSLContextBuilder
            .create()
            .loadTrustMaterial(ResourceUtils.getFile("classpath:AppsDeveloperBlog.p12"), password.toCharArray())
            .build()

        val client: CloseableHttpClient = HttpClients.custom()
            .setSSLContext(sslContext)
            .build()

        val requestFactory = HttpComponentsClientHttpRequestFactory()
        requestFactory.httpClient = client

        val restTemplate = RestTemplate(requestFactory)

        val url = "https://data.fixer.io/api/latest" // Web Service endpoint that requires SSL


        val response = restTemplate.exchange(
            url, HttpMethod.GET, HttpEntity.EMPTY,
            String::class.java
        )

        println("Result = " + response.body)
        return productRepository.findAll() }

    fun saveProduct(product: Product) = productRepository.save(product)

    fun findById(productId: Long) = productRepository.findById(productId)

    fun Product.toProductDTO() = ProductDTO(id= id, name = name, sku = sku, description = description, price = price, image_url = image_url  )

}
