package edu.itvo.kmp1.aspect.product.domain.model

data class Product(
    val code: String = "",
    val description: String = "",
    val category: String = "",
    val price: Double = 0.0,
    val stock: Int = 0,
    val taxable: Boolean = false
)