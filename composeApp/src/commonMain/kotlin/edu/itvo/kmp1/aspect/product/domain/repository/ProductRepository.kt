package edu.itvo.kmp1.aspect.product.domain.repository

import edu.itvo.kmp1.aspect.customer.core.repository.BaseRepository
import edu.itvo.kmp1.aspect.product.domain.model.Product

interface ProductRepository : BaseRepository<Product, String>