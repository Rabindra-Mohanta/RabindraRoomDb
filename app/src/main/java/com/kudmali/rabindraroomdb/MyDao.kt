package com.kudmali.rabindraroomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface MyDao {
    @Insert
    suspend fun insetData(myModel: MyModel);
    @Update
    suspend fun update(myModel: MyModel);
    @Delete
    suspend fun delete(myModel: MyModel);

    @Query("SELECT * FROM MyModel order by id asc")
    fun getAllData():LiveData<List<MyModel>>;
}