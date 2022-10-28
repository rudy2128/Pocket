//package com.anthony.pocket.data
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.anthony.pocket.dao.ReportDao
//import com.anthony.pocket.entity.Report
//
//@Database(entities = [Report::class], version = 2, exportSchema = false)
//public abstract class ReportRoomDatabase: RoomDatabase() {
//
//    abstract fun reportDao() : ReportDao
//
//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: ReportRoomDatabase? = null
//
//        fun getDatabase(context: Context): ReportRoomDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    ReportRoomDatabase::class.java,
//                    "report_database"
//                ).build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }
//}