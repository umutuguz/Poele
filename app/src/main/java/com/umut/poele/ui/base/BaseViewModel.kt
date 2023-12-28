package com.umut.poele.ui.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.umut.poele.util.Event
import com.umut.poele.util.NavigationCommand
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    val navigation: LiveData<Event<NavigationCommand>> get() = _navigation
    private val _navigation = MutableLiveData<Event<NavigationCommand>>()

    fun navigate(navDirections: NavDirections, isBottomSheet: Boolean = false) {
        _navigation.value = Event(NavigationCommand.ToDirection(navDirections, isBottomSheet))
    }

    fun navigateBack() {
        _navigation.value = Event(NavigationCommand.Back)
    }

    fun launchCatching(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                Log.d("ERROR_TAG", throwable.message.orEmpty())
            },
            block = block
        )
}
