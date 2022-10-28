package com.anthony.pocket.model;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.anthony.pocket.entity.Report;
import com.anthony.pocket.repo.TrxRepository;

import java.util.List;

public class TrxViewModel extends ViewModel {
    private final TrxRepository mTrxRepository;

    public TrxViewModel(Application mApplication) {
        mTrxRepository = new TrxRepository(mApplication);
    }
    public LiveData<List<Report>> getAllTrx() {
        return mTrxRepository.getAllReport();
    }

    public void insert(Report report) {
        mTrxRepository.insert(report);
    }
//    public void update(Ktp ktp) {
//        mLocalRepository.update(ktp);
//    }
    public void deleteTrx(Integer id){mTrxRepository.delete(id);}

    public LiveData<Integer> getSum(){ return mTrxRepository.getSum();}
//    public LiveData<String> getTrxById(Integer id) {
//        return mTrxRepository.getReportById(id);
//    }
}
