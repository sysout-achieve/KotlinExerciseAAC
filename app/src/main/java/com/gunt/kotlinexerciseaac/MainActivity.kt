package com.gunt.kotlinexerciseaac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "todo-db")
            .allowMainThreadQueries()
            .build()

        txt_list.text = db.todoDAO().getAll().toString()

        btn_input.setOnClickListener {
            db.todoDAO().insert(Todo(et_todo.text.toString()))
            txt_list.text = db.todoDAO().getAll().toString()
        }
    }
}