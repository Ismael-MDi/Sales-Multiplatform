package edu.itvo.kmp1.aspect.customer.data.mapper
import edu.itvo.kmp1.aspect.customer.data.dto.CustomerDto
import edu.itvo.kmp1.aspect.customer.domain.model.Customer

fun CustomerDto.toDomain(): Customer {

    return Customer(
        id = id,
        name = name,
        email = email
    )
}
fun Customer.toDto(): CustomerDto {

    return CustomerDto(
        id = id,
        name = name,
        email = email
    )
}