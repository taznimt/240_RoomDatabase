package com.example.rommdb.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.internal.synchronized

@Database(entities=[Siswa::class],version=1, exportSchema= false)
abstract class DatabaseSiswa : RoomDatabase{
    abstract fun siswaDao(): siswaDao

    companion object{

        private var Instance: DatabaseSiswa? = null
        fun GetDatabase(context: Context): DatabaseSiswa {
            return(Instance?: synchronized(lock = this){
                Room.databaseBuilder(
                    context, klass= DatabaseSiswa::class,java,
                    name = "siswa_database")
                    .build().also { Instance=it}
            })
        }
    }
}