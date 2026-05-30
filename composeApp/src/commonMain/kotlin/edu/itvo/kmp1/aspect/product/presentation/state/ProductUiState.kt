package edu.itvo.kmp1.aspect.product.presentation.state

sealed class ProductUiState {

    data object List : ProductUiState()

    data object Form : ProductUiState()
}