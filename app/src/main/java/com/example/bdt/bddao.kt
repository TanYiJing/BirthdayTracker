package com.example.bdt

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface bddao {
    @Insert
     suspend fun insertDB(db: DB)

    @Update
    suspend fun updateDB(db:DB)

    @Delete
    suspend fun deleteDB(db:DB)

    @Query("SELECT * FROM birthday")
     fun  getAllBD(): LiveData<List<DB>>

    @Query( "SELECT * FROM birthday WHERE id = ID")
     fun  getABD(ID:Int):DB

}