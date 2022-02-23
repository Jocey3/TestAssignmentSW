package com.dev.jocey.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [EntityDB::class], version = 1)
@TypeConverters(DbTypeConventer::class)
abstract class DeviceDataBase : RoomDatabase() {
    abstract fun baseDao(): BaseDao
}