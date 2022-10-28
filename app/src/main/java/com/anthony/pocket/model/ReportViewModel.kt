//package com.anthony.pocket.model
//
//import android.app.Application
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//import com.anthony.pocket.entity.Report
//import com.anthony.pocket.repo.ReportRepository
//
//class ReportViewModel(mApplication: Application) : ViewModel() {
//    private var mReportRepository:ReportRepository = ReportRepository(mApplication)
//
//    fun init(mApplication: Application){
//        mReportRepository = ReportRepository(mApplication);
//
//    }
//
//
//    val findAll: LiveData<List<Report>> =
//        mReportRepository.getAll
//
//
//    fun insert(report: Report) {
//    return mReportRepository.insert(report)
//    }
//
//    fun getById(id:Int):LiveData<String> {
//        return mReportRepository.findById(id)
//    }
//
//    fun deleteById(id:Int){
//        return mReportRepository.deleteById(id)
//    }
//
//}