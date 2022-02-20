package com.example.tarea.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tarea.model.Carro


@Database(entities=[Carro:: class],version=1,exportSchema = false)
abstract class CarroDatabase: RoomDatabase() {
    abstract fun carroDao() : CarroDao


    companion object{
        @Volatile
        private var INSTANCE: CarroDatabase? = null
        fun getDatabase(context: android.content.Context) : CarroDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){

                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarroDatabase::class.java,
                    "carro_database"
                ).build()

                INSTANCE= instance
                return instance
            }
        }

    }
}