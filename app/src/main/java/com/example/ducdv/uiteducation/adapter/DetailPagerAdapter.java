package com.example.ducdv.uiteducation.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ducdv.uiteducation.base.model.AlgorithmModel;
import com.example.ducdv.uiteducation.ui.fragment.CodeFragment;
import com.example.ducdv.uiteducation.ui.fragment.DescFragment;
import com.example.ducdv.uiteducation.ui.fragment.VisualFragment;

/**
 * Created by DucDV on 01/29/2018.
 */

public class DetailPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 3;

    private AlgorithmModel data;

    public DetailPagerAdapter(FragmentManager fm, AlgorithmModel data) {
        super(fm);
        this.data = data;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position){
            // desc fragment
            case 0:
                return DescFragment.newInstance(data);

            // code fragment
            case 1:
                return CodeFragment.newInstance(data);

            // visualization fragment
            case 2:
                return VisualFragment.newInstance(data);
        }

        return CodeFragment.newInstance(data);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }


}
