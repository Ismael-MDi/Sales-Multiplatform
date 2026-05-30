package edu.itvo.kmp1.aspect.product.domain.usecase

import edu.itvo.kmp1.aspect.product.domain.model.Product
import edu.itvo.kmp1.aspect.product.domain.repository.ProductRepository
import me.tatarka.inject.annotations.Inject

class SaveProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(
        product: Product
    ) {
        repository.save(product)
    }
}