package com.example.mod4injectiondep

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ListeLieuxVM @Inject constructor(
    val repo: RepositoryLieux) :ViewModel(){

    private val _stateLieux = MutableStateFlow(emptyList<String>())
    val stateLieux : StateFlow<List<String>> = _stateLieux

    init {
        _stateLieux.value = repo.getLieux()
    }
}