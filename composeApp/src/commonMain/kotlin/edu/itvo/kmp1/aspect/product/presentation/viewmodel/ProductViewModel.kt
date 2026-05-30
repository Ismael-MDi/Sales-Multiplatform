package edu.itvo.kmp1.aspect.product.presentation.viewmodel

import edu.itvo.kmp1.aspect.product.domain.model.Product
import edu.itvo.kmp1.aspect.product.domain.usecase.DeleteProductUseCase
import edu.itvo.kmp1.aspect.product.domain.usecase.ObserveProductsUseCase
import edu.itvo.kmp1.aspect.product.domain.usecase.SaveProductUseCase
import edu.itvo.kmp1.aspect.product.presentation.event.ProductEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Inject

class ProductViewModel @Inject constructor(
    private val observeProductsUseCase: ObserveProductsUseCase,
    private val saveProductUseCase: SaveProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase
){

    private val scope = CoroutineScope(Dispatchers.Main)

    private val _products =
        MutableStateFlow<List<Product>>(emptyList())

    val products: StateFlow<List<Product>> = _products

    init {
        observeProducts()
    }

    private fun observeProducts() {
        scope.launch {
            observeProductsUseCase()
                .collect { list ->
                    _products.value = list
                }
        }
    }

    fun onEvent(event: ProductEvent) {
        when (event) {

            is ProductEvent.SaveProduct -> {
                scope.launch {
                    saveProductUseCase(event.product)
                }
            }

            is ProductEvent.DeleteProduct -> {
                scope.launch {
                    deleteProductUseCase(event.id)
                }
            }
        }
    }
}