package com.anthony.pocket.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.anthony.pocket.dao.ReportDao;
import com.anthony.pocket.data.TrxDatabase;
import com.anthony.pocket.entity.Report;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TrxRepository {
    private final ReportDao mReportDao;
    private final ExecutorService executorService;


    public TrxRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();
        TrxDatabase db = TrxDatabase.getDatabase(application);
        mReportDao = db.reportDao();

    }
    public void insert(final Report report) {
        executorService.execute(() -> mReportDao.insert(report));
    }
    public void delete(Integer id) {
        executorService.execute(() -> mReportDao.delete(id));
    }


    public LiveData<Integer> getSum(){
        return mReportDao.getSum();}
//    public void update(final Report report) {
//        executorService.execute(() -> mReportDao.update(ktp));
//
//    }

    public LiveData<List<Report>> getAllReport() {
        return mReportDao.findAll();
    }



//    public LiveData<String>getReportById(Integer id){
//        return mReportDao.findById(id);
//    }
}
