package com.kudmali.rabindraroomdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "MyModel")
data class MyModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var name:String,
    val createdDate: Date,
    val isActive:Int

)
