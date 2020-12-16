package com.gunt.kotlinexerciseaac

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    var title: String
) {
    @PrimaryKey(autoGenerate = true) var id = 0
}

