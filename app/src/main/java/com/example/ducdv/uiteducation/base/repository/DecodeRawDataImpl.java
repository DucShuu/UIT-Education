package com.example.ducdv.uiteducation.base.repository;

import android.content.res.Resources;
import android.util.Log;


import com.example.ducdv.uiteducation.base.model.AlgorithmModel;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by DucDV on 01/29/2018.
 */

public class DecodeRawDataImpl implements DecodeRawData {

    private static final String DECODE_RAW_DATA_TAG = "errorTag";

    private String readFileFromRawDirectory(int resourceId, Resources resources) throws Exception{
        InputStream iStream = resources.openRawResource(resourceId);
        ByteArrayOutputStream byteStream = null;

        byte[] buffer = new byte[iStream.available()];
        iStream.read(buffer);
        byteStream = new ByteArrayOutputStream();
        byteStream.write(buffer);
        byteStream.close();
        iStream.close();

        return byteStream.toString();
    }


    @Override
    public void fetchData(OnFetchDataListener listener, int codeId, int descId, String videoId, Resources resources) {

        AlgorithmModel data = new AlgorithmModel();

        try {
            String code = readFileFromRawDirectory(codeId, resources);
            String desc = readFileFromRawDirectory(descId, resources);

            data.setCodeDemo(code);
            data.setDescription(desc);
            data.setYoutubeVideoId(videoId);
        } catch (Exception e) {
            Log.e(DECODE_RAW_DATA_TAG, e.toString());
            listener.onFailure(e.toString());
        }

        listener.onSuccess(data);

    }
}
