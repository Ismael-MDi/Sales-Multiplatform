package edu.itvo.kmp1.aspect.product.presentation.event

import edu.itvo.kmp1.aspect.product.domain.model.Product

sealed interface ProductEvent {

    data class SaveProduct(
        val product: Product
    ) : ProductEvent

    data class DeleteProduct(
        val id: String
    ) : ProductEvent
}