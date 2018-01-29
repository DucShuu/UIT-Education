package com.example.ducdv.uiteducation.bussiness;

import android.content.res.Resources;

import com.example.ducdv.uiteducation.R;
import com.example.ducdv.uiteducation.base.model.AlgorithmModel;
import com.example.ducdv.uiteducation.base.repository.DecodeRawData;
import com.example.ducdv.uiteducation.ui.activity.DSubject.DSubjectDetail;
import com.example.ducdv.uiteducation.ui.contract.DSubjectDetailView;

/**
 * Created by DucDV on 01/29/2018.
 */

public class DSubjectDetailPresenterImpl implements DSubjectDetailPresenter, DecodeRawData.OnFetchDataListener {

    private DSubjectDetailView view;
    private DecodeRawData repo;

    public DSubjectDetailPresenterImpl(DSubjectDetailView view, DecodeRawData repo) {
        this.view = view;
        this.repo = repo;
    }

    @Override
    public void fetchData(String algorithmName, Resources resources) {

        int codeId = 0;
        int descId = 0;
        String videoId = "";

        switch (algorithmName){
            case "Selection Sort":
                codeId = R.raw.selectionsort;

                break;

            case "Bubble Sort":
                break;

            case "Shell Sort":
                break;

            case "Shaker Sort":
                break;

            case "Insert Sort":
                break;

            case "Interchange Sort":
                break;

            case "Heap Sort":
                break;

            case "Merge Sort":
                break;

            case "Quick Sort":
                break;

            case "Radix Sort":
                break;

            case "Linear Search":
                codeId = R.raw.linearsearch;
                descId = R.raw.linearsearchedesc;
                videoId = resources.getString(R.string.linear_search_id);
                break;

            case "Binary Search":
                codeId = R.raw.binarysearch;
                descId = R.raw.binarysearchedesc;
                videoId = resources.getString(R.string.binary_search_id);
                break;
        }

        repo.fetchData(this, codeId, descId, videoId, resources);
    }


    @Override
    public void onSuccess(AlgorithmModel data) {

    }

    @Override
    public void onFailure(String msg) {

    }
}
