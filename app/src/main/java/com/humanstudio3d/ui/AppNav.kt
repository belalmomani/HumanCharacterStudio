package com.humanstudio3d.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.humanstudio3d.ui.screens.HomeScreen
import com.humanstudio3d.ui.screens.PrivacyScreen
import com.humanstudio3d.ui.screens.ProcessingScreen
import com.humanstudio3d.ui.screens.ReviewScreen

private object Routes {
    const val HOME = "home"
    const val REVIEW = "review"
    const val PROCESSING = "processing"
    const val PRIVACY = "privacy"
}

@Composable
fun AppNav(vm: CharacterViewModel) {
    val nav = rememberNavController()

    LaunchedEffect(Unit) {
        vm.events.collect { event ->
            if (event == UiEvent.ImageReady) nav.navigate(Routes.REVIEW)
        }
    }

    NavHost(navController = nav, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(vm = vm, onOpenPrivacy = { nav.navigate(Routes.PRIVACY) })
        }
        composable(Routes.REVIEW) {
            ReviewScreen(
                vm = vm,
                onBack = { nav.popBackStack() },
                onReplaceOrCancel = {
                    vm.discardImage()
                    nav.popBackStack(Routes.HOME, inclusive = false)
                },
                onConfirm = {
                    vm.resetProcessing()
                    nav.navigate(Routes.PROCESSING)
                },
            )
        }
        composable(Routes.PROCESSING) {
            ProcessingScreen(
                vm = vm,
                onBack = {
                    vm.cancelProcessing()
                    nav.popBackStack()
                },
                onPickAnother = {
                    vm.discardImage()
                    nav.popBackStack(Routes.HOME, inclusive = false)
                },
            )
        }
        composable(Routes.PRIVACY) {
            PrivacyScreen(onBack = { nav.popBackStack() })
        }
    }
}
