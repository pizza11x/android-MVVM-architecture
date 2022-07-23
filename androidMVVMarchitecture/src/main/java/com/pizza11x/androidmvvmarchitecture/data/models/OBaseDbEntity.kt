package com.pizza11x.androidmvvmarchitecture.data.models

import androidx.room.PrimaryKey

open class OBaseDbEntity{
    @PrimaryKey(autoGenerate = true) val id: Int = 0
}
