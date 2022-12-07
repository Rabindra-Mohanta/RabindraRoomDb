package com.kudmali.rabindraroomdb

import androidx.room.TypeConverter
import java.util.*

class MyDateTypeConveter {


    @TypeConverter
    fun setDate(date: Date):Long
    {
        return date.time;
    }
    @TypeConverter
    fun getDate(long:Long):Date
    {
        return Date(long);
    }
}