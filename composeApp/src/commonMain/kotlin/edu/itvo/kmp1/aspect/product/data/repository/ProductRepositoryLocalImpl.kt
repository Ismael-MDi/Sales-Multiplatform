package edu.itvo.kmp1.aspect.product.data.repository

import edu.itvo.kmp1.aspect.customer.core.repository.BaseInMemoryRepository
import edu.itvo.kmp1.aspect.product.domain.model.Product
import edu.itvo.kmp1.aspect.product.domain.repository.ProductRepository
import me.tatarka.inject.annotations.Inject

class ProductRepositoryLocalImpl @Inject constructor():
    BaseInMemoryRepository<Product, String>(),
    ProductRepository {

    override fun getId(item: Product): String {
        return item.code // Retornamos code como el ID principal
    }
}