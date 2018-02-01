package com.example.ducdv.uiteducation.base.repository;

import java.util.List;

/**
 * Created by DucDV on 02/01/2018.
 */

public interface MainRepo {

    public interface OnGetSubjectListener{
        void onSuccess(List<String> listSubject);
        void onError(String error);
    }

    void getSubject(OnGetSubjectListener listener);
}
