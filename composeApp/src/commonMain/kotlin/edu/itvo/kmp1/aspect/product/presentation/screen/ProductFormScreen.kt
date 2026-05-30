package edu.itvo.kmp1.aspect.product.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.itvo.kmp1.aspect.product.domain.model.Product
import edu.itvo.kmp1.aspect.product.presentation.component.ProductFormCard
import edu.itvo.kmp1.aspect.product.presentation.event.ProductEvent
import edu.itvo.kmp1.aspect.product.presentation.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductFormScreen(viewModel: ProductViewModel, onBack: () -> Unit) {
    var code by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    var taxable by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Formulario de Producto") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Regresar") } }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .widthIn(max = 600.dp)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ProductFormCard(
                    code = code,
                    description = description,
                    category = category,
                    price = price,
                    stock = stock,
                    taxable = taxable,
                    onCodeChange = { code = it },
                    onDescriptionChange = { description = it },
                    onCategoryChange = { category = it },
                    onPriceChange = { price = it },
                    onStockChange = { stock = it },
                    onTaxableChange = { taxable = it },
                    onSaveClick = {
                        val priceValue = price.toDoubleOrNull() ?: 0.0
                        val stockValue = stock.toIntOrNull() ?: 0

                        viewModel.onEvent(
                            ProductEvent.SaveProduct(
                                Product(
                                    code = code,
                                    description = description,
                                    category = category,
                                    price = priceValue,
                                    stock = stockValue,
                                    taxable = taxable
                                )
                            )
                        )

                        code = ""
                        description = ""
                        category = ""
                        price = ""
                        stock = ""
                        taxable = false

                        onBack()
                    }
                )
            }
        }
    }
}