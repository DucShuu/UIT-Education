package com.example.ducdv.uiteducation.ui.activity.DSubject;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ducdv.uiteducation.R;
import com.example.ducdv.uiteducation.adapter.DetailPagerAdapter;
import com.example.ducdv.uiteducation.base.model.AlgorithmModel;
import com.example.ducdv.uiteducation.base.repository.DecodeRawDataImpl;
import com.example.ducdv.uiteducation.bussiness.DSubjectDetailPresenter;
import com.example.ducdv.uiteducation.bussiness.DSubjectDetailPresenterImpl;
import com.example.ducdv.uiteducation.ui.contract.DSubjectDetailView;
import com.example.ducdv.uiteducation.ui.fragment.CodeFragment;
import com.example.ducdv.uiteducation.ui.fragment.DescFragment;
import com.example.ducdv.uiteducation.ui.fragment.VisualFragment;

public class DSubjectDetail extends AppCompatActivity implements DSubjectDetailView, DescFragment.OnFragmentInteractionListener, CodeFragment.OnFragmentInteractionListener, VisualFragment.OnFragmentInteractionListener {

    private final String TAG = "tag";

    private ViewPager pager;
    private TabLayout tab;
    private String dataReceived;

    private DetailPagerAdapter adapter;

    private DSubjectDetailPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsubject_detail);

        getDataFromPreviousActivity();

        setTitle(dataReceived);

        addControls();

        init();

    }

    private void init() {
        presenter = new DSubjectDetailPresenterImpl(this, new DecodeRawDataImpl());
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

    @Override
    public void sendDataToFragment(AlgorithmModel data) {
       adapter = new DetailPagerAdapter(getSupportFragmentManager(), data);
       pager.setAdapter(adapter);

       tab.setupWithViewPager(pager);

    }

    @Override
    public void showError(String error) {
        showToastMessage(error);
        Log.e(TAG, error);
    }

    private void showToastMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.fetchData(dataReceived, getResources());
    }
}
