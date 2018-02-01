package com.example.ducdv.uiteducation.bussiness;

import android.util.Log;

import com.example.ducdv.uiteducation.base.repository.MainRepo;
import com.example.ducdv.uiteducation.ui.contract.MainView;

import java.util.List;

/**
 * Created by DucDV on 02/01/2018.
 */

public class MainPresenterImpl implements MainPresenter, MainRepo.OnGetSubjectListener {

    private MainView view;
    private MainRepo repo;

    public MainPresenterImpl(MainView view, MainRepo repo) {
        this.view = view;
        this.repo = repo;
    }

    @Override
    public void loadSubject() {
        repo.getSubject(this);
    }

    @Override
    public void onSuccess(List<String> listSubject) {
        view.displayData(listSubject);
    }

    @Override
    public void onError(String error) {
        Log.e("Main Activity", error);
    }
}
