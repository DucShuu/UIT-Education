package com.example.ducdv.uiteducation.bussiness;

import android.content.res.Resources;

import com.example.ducdv.uiteducation.R;
import com.example.ducdv.uiteducation.base.model.AlgorithmModel;
import com.example.ducdv.uiteducation.base.repository.DecodeRawData;
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
                descId = R.raw.selectionsortedesc;
                videoId = resources.getString(R.string.selection_sort_id);
                break;

            case "Bubble Sort":
                codeId = R.raw.bubblesort;
                descId = R.raw.bubblesortedesc;
                videoId = resources.getString(R.string.bubble_sort_id);
                break;

            case "Shell Sort":
                codeId = R.raw.shellsort;
                descId = R.raw.shellsortedesc;
                videoId = resources.getString(R.string.shell_sort_id);
                break;

            case "Shaker Sort":
                codeId = R.raw.cocktailsort;
                descId = R.raw.linearsearchedesc;
                videoId = resources.getString(R.string.shaker_sort_id);
                break;

            case "Insert Sort":
                codeId = R.raw.insertsort;
                descId = R.raw.insertsortedesc;
                videoId = resources.getString(R.string.insert_sort_id);
                break;

            case "Interchange Sort":
                codeId = R.raw.interchangesort;
                descId = R.raw.interchangesort;
                videoId = resources.getString(R.string.interchange_sort_id);
                break;

            case "Heap Sort":
                codeId = R.raw.heapsort;
                descId = R.raw.heapsortedesc;
                videoId = resources.getString(R.string.heap_sort_id);
                break;

            case "Merge Sort":
                codeId = R.raw.mergesort;
                descId = R.raw.mergesort;
                videoId = resources.getString(R.string.merge_sort_id);
                break;

            case "Quick Sort":
                codeId = R.raw.quicksort;
                descId = R.raw.quicksortedesc;
                videoId = resources.getString(R.string.quick_sort_id);
                break;

            case "Radix Sort":
                codeId = R.raw.radixsort;
                descId = R.raw.radixsort;
                videoId = resources.getString(R.string.radix_sort_id);
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
        view.sendDataToFragment(data);
    }

    @Override
    public void onFailure(String msg) {
        view.showError(msg);
    }
}
