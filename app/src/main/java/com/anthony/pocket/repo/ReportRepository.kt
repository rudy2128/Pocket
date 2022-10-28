//package com.anthony.pocket.repo
//
//import android.annotation.SuppressLint
//import android.app.Application
//import androidx.annotation.WorkerThread
//import androidx.lifecycle.LiveData
//import com.anthony.pocket.dao.ReportDao
//import com.anthony.pocket.data.ReportRoomDatabase
//import com.anthony.pocket.entity.Report
//import java.util.concurrent.ExecutorService
//import java.util.concurrent.Executors
//
//
//class ReportRepository {
//    var mReportDao: ReportDao;
//    private var executorService: ExecutorService? = null
//
//    fun LocalRepository(application: Application?) {
//        executorService = Executors.newSingleThreadExecutor()
//        val db: ReportRoomDatabase = ReportRoomDatabase.getDatabase(application)
//        mReportDao = db.reportDao()
//    }
//
//
//    @SuppressLint("NotConstructor")
//    fun init(application: Application){
//        executorService = Executors.newSingleThreadExecutor()
//        val db:ReportRoomDatabase = ReportRoomDatabase.getDatabase(application.applicationContext)
//        mReportDao = db.reportDao()
//    }
//
//
//    val getAll: LiveData<List<Report>> = mReportDao.findAll()
//
//    fun findById(id:Int): LiveData<String> =
//        mReportDao.findById(id)
//
//    fun deleteById(id:Int){
//        mReportDao.delete(id)
//    }
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    fun insert(report: Report) {
//        executorService.execute {
//            mReportDao.insert(report)
//        }
//    }
//
//}