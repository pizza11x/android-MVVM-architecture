package com.pizza11x.androidmvvmarchitecture.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.*
import androidx.room.Update
import com.pizza11x.androidmvvmarchitecture.data.models.OBaseDbEntity

@Dao
interface IBaseDbDao {
    /* INSERT FUN */
    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: OBaseDbEntity): Long

    /* UPDATE FUN */
    @Update()
    suspend fun update(entity: OBaseDbEntity): Int

}