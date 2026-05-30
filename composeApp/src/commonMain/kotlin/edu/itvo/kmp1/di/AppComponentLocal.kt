package edu.itvo.kmp1.di

import edu.itvo.kmp1.aspect.customer.data.repository.CustomerRepositoryLocalImpl
import edu.itvo.kmp1.aspect.customer.domain.repository.CustomerRepository
import edu.itvo.kmp1.aspect.customer.presentation.viewmodel.CustomerViewModel
import edu.itvo.kmp1.aspect.customer.domain.usecase.ObserveCustomersUseCase
import edu.itvo.kmp1.aspect.customer.domain.usecase.SaveCustomerUseCase
import edu.itvo.kmp1.aspect.customer.domain.usecase.DeleteCustomerUseCase

import edu.itvo.kmp1.aspect.product.data.repository.ProductRepositoryLocalImpl
import edu.itvo.kmp1.aspect.product.domain.repository.ProductRepository
import edu.itvo.kmp1.aspect.product.presentation.viewmodel.ProductViewModel
import edu.itvo.kmp1.aspect.product.domain.usecase.ObserveProductsUseCase
import edu.itvo.kmp1.aspect.product.domain.usecase.SaveProductUseCase
import edu.itvo.kmp1.aspect.product.domain.usecase.DeleteProductUseCase

class AppComponentLocal {

    private val customerRepository: CustomerRepository by lazy { CustomerRepositoryLocalImpl() }

    val customerViewModel: CustomerViewModel by lazy {
        CustomerViewModel(
            ObserveCustomersUseCase(customerRepository),
            SaveCustomerUseCase(customerRepository),
            DeleteCustomerUseCase(customerRepository)
        )
    }

    private val productRepository: ProductRepository by lazy { ProductRepositoryLocalImpl() }
    val productViewModel: ProductViewModel by lazy {
        ProductViewModel(
            ObserveProductsUseCase(productRepository),
            SaveProductUseCase(productRepository),
            DeleteProductUseCase(productRepository)
        )
    }
}