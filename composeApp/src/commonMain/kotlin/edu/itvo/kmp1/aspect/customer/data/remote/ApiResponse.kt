package edu.itvo.kmp1.aspect.customer.data.remote
import kotlinx.serialization.Serializable
@Serializable
data class ApiResponse<T>(
    val success: Boolean,
    val data: List<T>
)
