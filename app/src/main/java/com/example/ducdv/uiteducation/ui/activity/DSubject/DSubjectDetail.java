package com.example.ducdv.uiteducation.ui.activity.DSubject;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ducdv.uiteducation.R;
import com.example.ducdv.uiteducation.adapter.DetailPagerAdapter;
import com.example.ducdv.uiteducation.ui.fragment.CodeFragment;
import com.example.ducdv.uiteducation.ui.fragment.DescFragment;
import com.example.ducdv.uiteducation.ui.fragment.VisualFragment;

public class DSubjectDetail extends AppCompatActivity implements DescFragment.OnFragmentInteractionListener, CodeFragment.OnFragmentInteractionListener, VisualFragment.OnFragmentInteractionListener {


    private ViewPager pager;
    private TabLayout tab;
    private String dataReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsubject_detail);

        getDataFromPreviousActivity();

        addControls();

    }

    private void getDataFromPreviousActivity() {
        dataReceived = getIntent().getExtras().getString(DSubject.FORWARD_KEY, "");
    }


    private void addControls() {
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab_layout);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
