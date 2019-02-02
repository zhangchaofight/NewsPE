package site.thatman.newspe.bussiness.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import site.thatman.newspe.bussiness.bean.remoteBean.JuheNewsBean

@Database(entities = [JuheNewsBean::class], version = 1, exportSchema = true)
abstract class SCDatabase : RoomDatabase() {

    abstract fun getJuheNewsDao(): JuheNewsDao

    companion object {

        private lateinit var INSTANCE : SCDatabase

        fun getInstance(context: Context): SCDatabase {
            synchronized(SCDatabase::class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        SCDatabase::class.java, "scNews.db")
                        .build()
            }
            return INSTANCE
        }
    }
}