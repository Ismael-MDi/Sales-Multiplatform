package edu.itvo.kmp1.navigation
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import edu.itvo.kmp1.aspect.customer.presentation.screen.CustomerFormScreen
import edu.itvo.kmp1.aspect.customer.presentation.screen.CustomerListScreen
import edu.itvo.kmp1.aspect.customer.presentation.viewmodel.CustomerViewModel
import edu.itvo.kmp1.aspect.product.presentation.screen.ProductFormScreen
import edu.itvo.kmp1.aspect.product.presentation.screen.ProductListScreen
import edu.itvo.kmp1.aspect.product.presentation.viewmodel.ProductViewModel
@Composable
fun AppNavHost(
    customerViewModel: CustomerViewModel,
    productViewModel: ProductViewModel
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                // Item 1: Clientes
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Clientes") },
                    label = { Text("Clientes") },
                    selected = currentDestination?.hierarchy?.any { it.route == CustomerRoutes.List.route } == true,
                    onClick = {
                        navController.navigate(CustomerRoutes.List.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                // Item 2: Productos
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Productos") },
                    label = { Text("Productos") },
                    selected = currentDestination?.hierarchy?.any { it.route == ProductRoutes.List.route } == true,
                    onClick = {
                        navController.navigate(ProductRoutes.List.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = CustomerRoutes.List.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(CustomerRoutes.List.route) {
                CustomerListScreen(
                    viewModel = customerViewModel,
                    onAddClick = { navController.navigate(CustomerRoutes.Form.route) }
                )
            }
            composable(CustomerRoutes.Form.route) {
                CustomerFormScreen(
                    viewModel = customerViewModel,
                    onBack = { navController.popBackStack() }
                )
            }
            // --- PRODUCT ROUTES ---
            composable(ProductRoutes.List.route) {
                ProductListScreen(
                    viewModel = productViewModel,
                    onAddClick = { navController.navigate(ProductRoutes.Form.route) }
                )
            }
            composable(ProductRoutes.Form.route) {
                ProductFormScreen(
                    viewModel = productViewModel,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}