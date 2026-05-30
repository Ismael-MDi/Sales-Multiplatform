package edu.itvo.kmp1.aspect.product.data.remote

import edu.itvo.kmp1.aspect.customer.data.remote.ApiResponse
import edu.itvo.kmp1.aspect.product.data.dto.ProductDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.http.*

class ProductApi(
    private val client: HttpClient,
    private val baseUrl: String
) {

    suspend fun getProducts(): ApiResponse<ProductDto>{

        return client.get(
            "$baseUrl/products"
        ).body()
    }

    suspend fun saveProduct(
        product: ProductDto
    ) {

        client.post(
            "$baseUrl/products"
        ) {

            contentType(ContentType.Application.Json)

            setBody(product)
        }
    }

    suspend fun deleteProduct(
        id: String
    ) {

        client.delete(
            "$baseUrl/products/$id"
        )
    }
}