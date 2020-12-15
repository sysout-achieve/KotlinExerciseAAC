package com.gunt.kotlinexerciseaac

import androidx.room.*

@Dao
interface TodoDAO {
    @get:Query("SELECT * FROM Todo")
    val all: List<Todo?>?

    @Insert
    fun insertAll(vararg todos: Todo?)

    @Insert
    fun insert(todo: Todo?)

    @Update
    fun update(todo: Todo?)

    @Delete
    fun delete(todo: Todo?)
}