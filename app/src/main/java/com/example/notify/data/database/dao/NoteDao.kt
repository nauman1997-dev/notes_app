package com.example.notify.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notify.data.database.entities.Note

@Dao
interface NoteDao {

    /***
        Method for adding and updating data in table
        OnConflictStrategy.REPLACE adds data if it is not
        present or it will replace if the row already exists
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(note: Note)

    /***
     *  Method for deleting row from the table
     */
    @Delete
    suspend fun delete(note: Note)

    /***
     *  Method for
     */
    @Query("SELECT * FROM notes_table ORDER BY id")
    fun getAllNotes(): LiveData<List<Note>>
}