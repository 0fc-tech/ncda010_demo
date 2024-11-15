package com.example.mod6room

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MusicDbTest {
    lateinit var db : AppDatabase

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
    }
    @Test
    fun testInsertMusic(){
        val rose=Music(0L,"APT.","Bruno Mars",200)
        val id = db.musicDao().insert(rose)
        assert(db.musicDao().findById(id)?.title == rose.title)
        assert(db.musicDao().findById(id)?.author == rose.author)
    }
}