package com.umut.poele.util

import androidx.navigation.NavDirections

sealed class NavigationCommand {
    data class ToDirection(val directions: NavDirections, val isBottomSheet: Boolean = false) :
        NavigationCommand()

    object Back : NavigationCommand()
}
