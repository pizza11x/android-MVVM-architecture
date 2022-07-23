package com.pizza11x.androidmvvmarchitecture.data.local.db

import androidx.room.*
import androidx.room.OnConflictStrategy.*
import com.pizza11x.androidmvvmarchitecture.data.models.OBaseDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IBaseDbDao {

    /* QUERY FUN */
    suspend fun getById(id: String) : Flow<OBaseDbEntity>

    suspend fun getAll() : Flow<List<OBaseDbEntity>>

    /* INSERT FUN */
    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: OBaseDbEntity): Long

    @Insert(onConflict = REPLACE)
    suspend fun insert(entities: List<OBaseDbEntity>)

    /* UPDATE FUN */
    @Update
    suspend fun update(entity: OBaseDbEntity)

    @Update
    suspend fun update(entities: List<OBaseDbEntity>)

    /* DELETE FUN */
    @Delete
    fun delete(entity: OBaseDbEntity)

    @Delete
    fun delete(entities: List<OBaseDbEntity>)

    @Delete
    fun deleteById(id: String)

}