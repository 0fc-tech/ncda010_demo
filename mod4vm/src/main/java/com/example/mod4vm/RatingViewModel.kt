package com.example.mod4vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RatingViewModel : ViewModel() {
    private val _rating = MutableStateFlow(0f)
    val rating = _rating.asStateFlow()
    //private val _infoUser = MutableStateFlow("")
    //val infoUser = _infoUser.asStateFlow()
    private val _requireFeedback = MutableStateFlow(true)
    val requireFeedback = _requireFeedback.asStateFlow()

    fun incrementRating() {
        if (_rating.value < 10){
            _rating.value += 1
            //_infoUser.value = ""
            _requireFeedback.value=(_rating.value <8)
        }
        //else{
        //    _infoUser.value ="Impossible"
        //}
    }
    fun decrementRating(){
        if(_rating.value > 0){
            _rating.value -=1
            //_infoUser.value = ""
            _requireFeedback.value=(_rating.value <8)

        }
        //else{
        //    _infoUser.value ="Impossible"
        //}
    }
}