package edu.itvo.kmp1
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color // Importación necesaria para los colores
import edu.itvo.kmp1.di.AppComponent
import edu.itvo.kmp1.navigation.AppNavHost

@Composable
fun App() {

    val component = remember {
        AppComponent()
    }
    val cleanColorScheme = lightColorScheme(
        background = Color.White,
        surface = Color.White,
        surfaceVariant = Color.White,
        primary = Color(0xFF1976D2)
    )

    MaterialTheme(
        colorScheme = cleanColorScheme
    ) {
        AppNavHost(
            customerViewModel = component.customerViewModel,
            productViewModel = component.productViewModel
        )
    }
}