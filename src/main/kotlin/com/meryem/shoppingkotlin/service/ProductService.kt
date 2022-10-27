package service

import com.meryem.shoppingkotlin.entity.Product
import com.meryem.shoppingkotlin.entity.ProductCategory
import org.springframework.stereotype.Service
import java.util.List
import java.util.Set

/**
 * @author MeryemSEKKAT
 */
@Service
interface ProductService {
    fun getProduct(id: Long?): Product?
    fun saveProduct(product: Product?): Product?
    fun deleteProduct(id: Long?)
    fun addCategoryToProduct(studentId: Long?, produtCategoryId: Long?): Product?
    val products: List<Any?>?
    fun getEnrolledProductCategory(id: Long?): Set<ProductCategory?>?
}
