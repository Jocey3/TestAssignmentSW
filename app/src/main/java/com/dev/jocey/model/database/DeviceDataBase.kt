package com.dev.jocey.model.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EntityDB::class], version = 1)
abstract class DeviceDataBase : RoomDatabase() {
    abstract fun baseDao(): BaseDao
}