package com.dev.jocey.di.hilt

import android.app.Application
import androidx.room.Room
import com.dev.jocey.model.database.DeviceDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(app: Application): DeviceDataBase =
        Room.databaseBuilder(app, DeviceDataBase::class.java, "StarWars.db")
//            .fallbackToDestructiveMigration()
            .build()
}