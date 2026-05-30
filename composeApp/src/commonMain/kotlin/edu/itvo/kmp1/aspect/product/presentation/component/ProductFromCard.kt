package edu.itvo.kmp1.aspect.product.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun ProductFormCard(
    code: String,
    description: String,
    category: String,
    price: String,
    stock: String,
    taxable: Boolean,
    onCodeChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onCategoryChange: (String) -> Unit,
    onPriceChange: (String) -> Unit,
    onStockChange: (String) -> Unit,
    onTaxableChange: (Boolean) -> Unit,
    onSaveClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Registro de Producto", style = MaterialTheme.typography.titleLarge)

            OutlinedTextField(value = code, onValueChange = onCodeChange, modifier = Modifier.fillMaxWidth(), label = { Text("Código") }, singleLine = true)
            OutlinedTextField(value = description, onValueChange = onDescriptionChange, modifier = Modifier.fillMaxWidth(), label = { Text("Descripción") })
            OutlinedTextField(value = category, onValueChange = onCategoryChange, modifier = Modifier.fillMaxWidth(), label = { Text("Categoría") }, singleLine = true)
            OutlinedTextField(value = price, onValueChange = onPriceChange, modifier = Modifier.fillMaxWidth(), label = { Text("Precio") }, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal))
            OutlinedTextField(value = stock, onValueChange = onStockChange, modifier = Modifier.fillMaxWidth(), label = { Text("Stock") }, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = taxable,
                    onCheckedChange = onTaxableChange
                )
                Text("Aplica Impuesto")
            }

            Spacer(modifier = Modifier.height(4.dp))
            Button(
                onClick = onSaveClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar Producto")
            }
        }
    }
}