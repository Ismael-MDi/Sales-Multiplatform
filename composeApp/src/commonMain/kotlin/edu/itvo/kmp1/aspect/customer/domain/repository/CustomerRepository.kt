package edu.itvo.kmp1.aspect.customer.domain.repository
import edu.itvo.kmp1.aspect.customer.core.repository.BaseRepository
import edu.itvo.kmp1.aspect.customer.domain.model.Customer
interface CustomerRepository :
    BaseRepository<Customer, String>