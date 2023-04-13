package com.sanathcoding.beerapp.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.sanathcoding.beerapp.data.local.BeerDatabase
import com.sanathcoding.beerapp.data.local.BeerEntity
import com.sanathcoding.beerapp.data.remote.BeerApi
import com.sanathcoding.beerapp.data.remote.BeerRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object BeerModule {

    @Provides
    @Singleton
    fun provideBeerDatabase(@ApplicationContext context: Context): BeerDatabase {
        return Room.databaseBuilder(
            context,
            BeerDatabase::class.java,
            "beers.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideBeerApi(): BeerApi {
        return Retrofit.Builder()
            .baseUrl(BeerApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideBeerPager(db: BeerDatabase, api: BeerApi): Pager<Int, BeerEntity> {
        return Pager(
            config = PagingConfig(20),
            remoteMediator = BeerRemoteMediator(
                beerDb = db,
                beerApi = api
            ),
            pagingSourceFactory = {
                db.dao.pageSource()
            }
        )
    }
}