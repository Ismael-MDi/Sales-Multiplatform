package edu.itvo.kmp1.aspect.product.domain.usecase

import edu.itvo.kmp1.aspect.product.domain.repository.ProductRepository
import me.tatarka.inject.annotations.Inject

class ObserveProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    operator fun invoke() =
        repository.observeAll()
}