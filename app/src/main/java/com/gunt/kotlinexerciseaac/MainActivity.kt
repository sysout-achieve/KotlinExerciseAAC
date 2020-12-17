package com.gunt.kotlinexerciseaac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "todo-db"
        ).build()

        db.todoDAO().getAll().observe(this, Observer {
            txt_list.text = it.toString()
        })

        btn_input.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                db.todoDAO().insert(Todo(et_todo.text.toString()))
            }
        }
    }
}