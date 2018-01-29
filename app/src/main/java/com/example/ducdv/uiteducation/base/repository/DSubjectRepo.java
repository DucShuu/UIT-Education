package com.example.ducdv.uiteducation.base.repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by DucDV on 01/28/2018.
 */

public interface DSubjectRepo {

    interface OnGetDataListener{
        void onSuccess(List<String> listDataHeader, HashMap<String, List<String>> listDataChild);
        void onFailure(String error);
    }

    void getData(OnGetDataListener listener);

}
