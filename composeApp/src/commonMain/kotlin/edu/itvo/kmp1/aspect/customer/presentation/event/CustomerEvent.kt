package edu.itvo.kmp1.aspect.customer.presentation.event
import edu.itvo.kmp1.aspect.customer.domain.model.Customer
sealed interface CustomerEvent {
    data class SaveCustomer(
        val customer: Customer
    ) : CustomerEvent
    data class DeleteCustomer(
        val id: String
    ) : CustomerEvent
}