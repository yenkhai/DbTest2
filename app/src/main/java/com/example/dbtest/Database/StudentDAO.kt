package com.example.dbtest.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    //todo: add query to get  all student records
    @Query("SELECT * FROM student")
    fun getAll(): List<Student>

    //@Query("SELECT * FROM student where studentid = :id")
    //fun getAll(id:String): List<Student>


    @Insert
    fun insert(vararg s:Student)
}