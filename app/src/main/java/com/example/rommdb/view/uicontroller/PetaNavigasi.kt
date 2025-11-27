package com.example.rommdb.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rommdb.view.EntrySiswaScreen
import com.example.rommdb.view.HomeScreen
import com.example.rommdb.view.route.DestinasiEntry
import com.example.rommdb.view.route.DestinasiHome

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(...markerClass = ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController, startDestination = DestinasiHome.route, modifier = Modifier){
        composable(route = DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = { navController.navigate(route = DestinasiEntry.route) }
            )
        }
        composable(route = DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }
    }
}