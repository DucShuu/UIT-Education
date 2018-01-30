package com.example.ducdv.uiteducation.ui.contract;

import com.example.ducdv.uiteducation.base.model.AlgorithmModel;

/**
 * Created by DucDV on 01/29/2018.
 */

public interface DSubjectDetailView {

    void sendDataToFragment(AlgorithmModel data);

    void showError(String error);

}
