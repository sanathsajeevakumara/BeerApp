package com.sanathcoding.beerapp.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface BeerDao {

    @Upsert
    suspend fun upsert(beers: List<BeerEntity>)

    @Query("SELECT * FROM beerentity")
    fun pageSource(): PagingSource<Int, BeerEntity>

    @Query("DELETE FROM beerentity")
    suspend fun clearAll()
}