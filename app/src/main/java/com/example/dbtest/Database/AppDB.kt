package com.example.dbtest.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Student::class ), version = 2,  exportSchema = true)
//arrayOf(Student::class, Programming :: class)    "if got more than one table, then add in "


abstract  class AppDB: RoomDatabase() {

    //todo :: add abstract method for studentDAO
    abstract fun studentDAO():StudentDAO

    companion object {

        @Volatile
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,  AppDB::class.java,"TARUC_DB")
                        .allowMainThreadQueries().fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}