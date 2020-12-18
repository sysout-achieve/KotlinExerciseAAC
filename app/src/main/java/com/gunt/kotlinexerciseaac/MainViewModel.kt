package com.gunt.kotlinexerciseaac

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "todo-db"
    ).build()
    var todos: LiveData<List<Todo>>
    var todoString: String? = null

    init {
        todos = getAll()
    }

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDAO().getAll()
    }

    fun insert(todo: String) {
        viewModelScope.launch(Dispatchers.IO) {
            db.todoDAO().insert(Todo(todo))
            Log.d("Thread name1: ", Thread.currentThread().name)
        }
        Log.d("Thread name2: ", Thread.currentThread().name)
    }

}