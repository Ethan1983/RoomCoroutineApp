package com.sample.roomcoroutineapp.repository

import androidx.room.*

@Dao
abstract class InfoDao {

    @Insert
    abstract suspend fun insert( info : Info )

    @Query( "DELETE FROM Info" )
    abstract suspend fun deleteAll()

    @Transaction
    open suspend fun deleteAllAndInsert( info : Info ) {
        deleteAll()
        insert( info )
    }
}