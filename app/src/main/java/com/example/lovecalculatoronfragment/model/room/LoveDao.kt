package com.example.lovecalculatoronfragment.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculatoronfragment.model.LoveModel


@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_table ORDER BY id DESC")
    fun getAll(): List<LoveModel>

    @Delete
    fun delete(liveModel: LoveModel)
}