package com.umut.poele.ui.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.umut.poele.util.Event
import com.umut.poele.util.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    val navigation: LiveData<Event<NavigationCommand>> get() = _navigation
    private val _navigation = MutableLiveData<Event<NavigationCommand>>()

    fun navigate(navDirections: NavDirections, isBottomSheet: Boolean = false) {
        _navigation.value = Event(NavigationCommand.ToDirection(navDirections, isBottomSheet))
    }

    fun navigateBack() {
        _navigation.value = Event(NavigationCommand.Back)
    }
}
