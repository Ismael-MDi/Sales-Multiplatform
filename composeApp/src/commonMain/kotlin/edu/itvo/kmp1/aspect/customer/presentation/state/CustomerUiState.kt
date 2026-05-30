package edu.itvo.kmp1.aspect.customer.presentation.state

sealed class CustomerUiState {

    data object List : CustomerUiState()

    data object Form : CustomerUiState()
}