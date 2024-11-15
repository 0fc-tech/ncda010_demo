package com.example.mod6room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MusicDao {
    @Insert
    suspend fun insertAll(musics: List<Music>) : List<Long>

    @Insert
    fun insert(music: Music) : Long

    @Query("SELECT * FROM Music WHERE id=:id")
    fun findById(id:Long) : Music?

    @Query("SELECT * FROM Music")
    fun findAll() : Flow<List<Music>>


}