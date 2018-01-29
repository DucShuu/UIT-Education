package com.example.ducdv.uiteducation.bussiness;

import com.example.ducdv.uiteducation.base.repository.DSubjectRepo;
import com.example.ducdv.uiteducation.ui.contract.DSubjectView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by DucDV on 01/28/2018.
 */

public class DSubjectPresenterImpl implements DSubjectPresenter, DSubjectRepo.OnGetDataListener {

    private DSubjectView view;
    private DSubjectRepo repo;

    public DSubjectPresenterImpl(DSubjectView view, DSubjectRepo repo) {
        this.view = view;
        this.repo = repo;
    }

    @Override
    public void loadDataToAdapter() {
        repo.getData(this);
    }

    @Override
    public void onSuccess(List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        view.displayView(listDataHeader, listDataChild);
    }

    @Override
    public void onFailure(String error) {
        view.showError(error);
    }
}
