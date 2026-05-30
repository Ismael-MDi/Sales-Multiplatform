package edu.itvo.kmp1.aspect.product.data.datasource.remote

import edu.itvo.kmp1.aspect.product.data.dto.ProductDto
import edu.itvo.kmp1.aspect.product.data.remote.ProductApi

class ProductRemoteDataSource(
    private val api: ProductApi
) {

    suspend fun getProducts(): List<ProductDto> {
        return api.getProducts().data
    }

    suspend fun saveProduct(
        product: ProductDto
    ) {
        api.saveProduct(product)
    }

    suspend fun deleteProduct(
        id: String
    ) {
        api.deleteProduct(id)
    }
}