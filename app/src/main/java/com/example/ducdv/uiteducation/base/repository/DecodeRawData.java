package com.example.ducdv.uiteducation.base.repository;

import android.content.res.Resources;

import com.example.ducdv.uiteducation.base.model.AlgorithmModel;

/**
 * Created by DucDV on 01/29/2018.
 */

public interface DecodeRawData {

    public interface OnFetchDataListener{
        void onSuccess(AlgorithmModel data);
        void onFailure(String msg);
    }

    void fetchData(OnFetchDataListener listener, int codeId, int descId, String videoId, Resources resources);
}
