package com.kudmali.rabindraroomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [MyModel::class], version = 2)
@TypeConverters(MyDateTypeConveter::class)
abstract class MyDatabase:RoomDatabase(){
    abstract fun getDao():MyDao;
    companion object
    {

        var migration1_2 =object : Migration(1,2)
        {
            override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE MyModel ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

        @Volatile
        private var INSTANCE:MyDatabase?=null;
        fun getDatabase(context:Context):MyDatabase
        {
            if(INSTANCE==null)
            {
                synchronized(this)
                {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,MyDatabase::class.java,"contactDb").addMigrations(
                        migration1_2).build();

                }

            }
            return INSTANCE!!;
        }
    }



}