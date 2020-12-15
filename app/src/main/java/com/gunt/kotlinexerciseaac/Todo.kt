package com.gunt.kotlinexerciseaac

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey val id: Int,
    var title: String
)