package com.example.rommdb.view.uicontroller

import android.R.attr.type
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rommdb.view.DetailSiswaScreen
import com.example.rommdb.view.route.DestinasiHome
import com.example.rommdb.view.route.DestinasiEntry
import com.example.rommdb.view.EntrySiswaScreen
import com.example.rommdb.view.HomeScreen
import com.example.rommdb.view.route.DestinasiDetailSiswa
import com.example.rommdb.view.route.DestinasiDetailSiswa.itemIdArg

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier ) {
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(route = DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(route = DestinasiEntry.route) },
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/${it}")
                }
            )
        }
        composable(route = DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }
        composable(route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                navigateToEditItem = {navController.navigate("${DestinasiEditSiswa.route}/${it}")},
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg) {
                type = NavType.IntType})
        ) {
            EditSiswaScreen(
                navigateBack = {navController.popBackStack()},
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}