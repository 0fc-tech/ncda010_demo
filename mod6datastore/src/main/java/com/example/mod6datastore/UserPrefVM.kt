package com.example.mod6datastore

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserPrefVM(val repo: UserPrefRepo) : ViewModel() {
    val colors = listOf(
        Color.Red,Color.Cyan,Color.Green,Color.Yellow,
        Color.Blue,Color.DarkGray,Color.Gray,Color.Black
    )
    private val _colorSelected = MutableStateFlow(Color.White)
    val colorSelected = _colorSelected.asStateFlow()
    fun getColorSelected(){
        viewModelScope.launch {
            repo.getBgColor().collect{
                _colorSelected.value=it
            }
        }
    }

    fun setColorSelected(color: Color){
        viewModelScope.launch {
            repo.setBgColor(color)
        }
    }


    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory
        {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return UserPrefVM(
                    UserPrefRepo(application.applicationContext),
                ) as T
            }
        }
    }
}
