package com.example.mod6room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListMusicVM(private val dao : MusicDao): ViewModel() {
    private val _musics = MutableStateFlow<List<Music>>(emptyList())
    val musics = _musics.asStateFlow()

    init {
        viewModelScope.launch {
            insertMusic(
                Music(0L, "9h", "R", 1)
            )
        }
        viewModelScope.launch {
            insertMusic(
                Music(0L, "Feel Good", "Polo & Pan", 240)
            )
        }
        viewModelScope.launch {
            loadMusics()
        }

    }

    fun loadMusics() {
        viewModelScope.launch(Dispatchers.IO) {
            dao.findAll().collect{list->
                _musics.value =list
            }
        }
    }

    suspend fun insertMusic(music: Music) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(music)
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = object :
            ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return ListMusicVM(
                    AppDatabase.getInstance(application.applicationContext)
                        .musicDao(),
                ) as T
            }
        }
    }
}
