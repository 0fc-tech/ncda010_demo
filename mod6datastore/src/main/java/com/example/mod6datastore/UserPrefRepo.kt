package com.example.mod6datastore

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPrefRepo(val context: Context) {
    val Context.dataStore by preferencesDataStore("prefs")

    val KEY_BG_COLOR = intPreferencesKey("KEY_BG_COLOR")

    //Getter
    fun getBgColor(): Flow<Color> = context.dataStore.data.map {
        Color(it[KEY_BG_COLOR] ?: Color.White.toArgb())
    }
    //Setter
    suspend fun setBgColor(color:Color) = context.dataStore.edit {
        it[KEY_BG_COLOR] = color.toArgb()
    }
}