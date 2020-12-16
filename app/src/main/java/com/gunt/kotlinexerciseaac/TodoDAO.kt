package com.gunt.kotlinexerciseaac

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDAO {
    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>

    @Insert
    fun insertAll(vararg todos: Todo)

    @Insert
    fun insert(todo: Todo)


    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}