package com.example.ducdv.uiteducation.base.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DucDV on 02/01/2018.
 */

public class MainRepoImpl implements MainRepo {


    @Override
    public void getSubject(OnGetSubjectListener listener) {
        // fake data
        List<String> listSubject = new ArrayList<>();
        listSubject.add("Data Structure and Algorithm");
        listener.onSuccess(listSubject);

    }
}
