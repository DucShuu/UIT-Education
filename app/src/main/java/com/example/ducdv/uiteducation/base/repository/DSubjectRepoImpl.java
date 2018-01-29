package com.example.ducdv.uiteducation.base.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DucDV on 01/28/2018.
 */

public class DSubjectRepoImpl implements DSubjectRepo {


    @Override
    public void getData(OnGetDataListener listener){

        // fake data

        List<String> listHeader = new ArrayList<>();
        listHeader.add("Search Algorithm");
        listHeader.add("Sort Algorithm");

        List<String> lisrSearchAlgo = new ArrayList<>();
        lisrSearchAlgo.add("Linear Search");
        lisrSearchAlgo.add("Binary Search");

        List<String> listSortAlgo = new ArrayList<>();
        listSortAlgo.add("Selection Sort");
        listSortAlgo.add("Bubble Sort");
        listSortAlgo.add("Shell Sort");
        listSortAlgo.add("Shaker Sort");
        listSortAlgo.add("Insert Sort");
        listSortAlgo.add("Interchange Sort");
        listSortAlgo.add("Heap Sort");
        listSortAlgo.add("Merge Sort");
        listSortAlgo.add("Quick Sort");
        listSortAlgo.add("Radix Sort");

        HashMap<String, List<String>> listChild = new HashMap<>();
        listChild.put(listHeader.get(0), lisrSearchAlgo);
        listChild.put(listHeader.get(1), listSortAlgo);

        listener.onSuccess(listHeader, listChild);


    }
}
