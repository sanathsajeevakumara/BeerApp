package com.sanathcoding.beerapp.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.sanathcoding.beerapp.data.local.BeerDatabase
import com.sanathcoding.beerapp.data.local.BeerEntity
import com.sanathcoding.beerapp.data.local.toBeerEntity
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class BeerRemoteMediator(
    private val beerDb: BeerDatabase,
    private val beerApi: BeerApi
): RemoteMediator<Int, BeerEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BeerEntity>
    ): MediatorResult {
        return try {

            // Current page key(number)
            val loadKey =
                when (loadType) {
                    LoadType.REFRESH -> 1
                    LoadType.PREPEND -> return MediatorResult.Success(true)
                    LoadType.APPEND -> {
                        val lastItem = state.lastItemOrNull()
                        if (lastItem == null) 1
                        else (lastItem.id / state.config.pageSize) + 1
                    }
                }

            // call beer api
            delay(2000L)
            val beers = beerApi.getBeers(
                page = loadKey,
                pageCount = state.config.pageSize
            )

            // insert remote data into beerdb - SST
            beerDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    beerDb.dao.clearAll()
                }
                val beerEntity = beers.map { it.toBeerEntity() }
                beerDb.dao.upsert(beerEntity)
            }

            MediatorResult.Success(endOfPaginationReached = beers.isEmpty())

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}