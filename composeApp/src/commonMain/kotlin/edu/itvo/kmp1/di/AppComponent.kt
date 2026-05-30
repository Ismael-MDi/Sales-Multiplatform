package edu.itvo.kmp1.di

import edu.itvo.kmp1.core.network.createHttpClient
import edu.itvo.kmp1.aspect.customer.data.datasource.remote.CustomerRemoteDataSource
import edu.itvo.kmp1.aspect.customer.data.remote.CustomerApi
import edu.itvo.kmp1.aspect.customer.data.repository.CustomerRepositoryImpl
import edu.itvo.kmp1.aspect.customer.domain.usecase.DeleteCustomerUseCase
import edu.itvo.kmp1.aspect.customer.domain.usecase.ObserveCustomersUseCase
import edu.itvo.kmp1.aspect.customer.domain.usecase.SaveCustomerUseCase
import edu.itvo.kmp1.aspect.customer.presentation.viewmodel.CustomerViewModel
import edu.itvo.kmp1.aspect.product.data.datasource.remote.ProductRemoteDataSource
import edu.itvo.kmp1.aspect.product.data.remote.ProductApi
import edu.itvo.kmp1.aspect.product.data.repository.ProductRepositoryImpl
import edu.itvo.kmp1.aspect.product.domain.usecase.DeleteProductUseCase
import edu.itvo.kmp1.aspect.product.domain.usecase.ObserveProductsUseCase
import edu.itvo.kmp1.aspect.product.domain.usecase.SaveProductUseCase
import edu.itvo.kmp1.aspect.product.presentation.viewmodel.ProductViewModel
class AppComponent {
    private val httpClient = createHttpClient()
    private val baseUrl = "http:// 192.168.1.206:3000"
    private val customerApi = CustomerApi(client = httpClient, baseUrl = baseUrl)
    private val customerRemote = CustomerRemoteDataSource(customerApi)
    private val customerRepository = CustomerRepositoryImpl(customerRemote)
    val customerViewModel = CustomerViewModel(
        ObserveCustomersUseCase(customerRepository),
        SaveCustomerUseCase(customerRepository),
        DeleteCustomerUseCase(customerRepository)
    )
    private val productApi = ProductApi(client = httpClient, baseUrl = baseUrl)
    private val productRemote = ProductRemoteDataSource(productApi)
    private val productRepository = ProductRepositoryImpl(productRemote)
    val productViewModel = ProductViewModel(
        ObserveProductsUseCase(productRepository),
        SaveProductUseCase(productRepository),
        DeleteProductUseCase(productRepository)
    )
}