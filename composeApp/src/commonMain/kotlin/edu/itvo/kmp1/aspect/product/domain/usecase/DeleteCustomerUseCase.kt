package edu.itvo.kmp1.aspect.product.domain.usecase

import edu.itvo.kmp1.aspect.product.domain.repository.ProductRepository
import me.tatarka.inject.annotations.Inject

class DeleteProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(id: String) {
        repository.deleteById(id)
    }
}