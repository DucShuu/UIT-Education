package com.example.ducdv.uiteducation.ui.activity.DSubject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.example.ducdv.uiteducation.R;
import com.example.ducdv.uiteducation.adapter.DetailPagerAdapter;
import com.example.ducdv.uiteducation.base.model.AlgorithmModel;
import com.example.ducdv.uiteducation.base.repository.DecodeRawDataImpl;
import com.example.ducdv.uiteducation.bussiness.DSubjectDetailPresenter;
import com.example.ducdv.uiteducation.bussiness.DSubjectDetailPresenterImpl;
import com.example.ducdv.uiteducation.ui.contract.DSubjectDetailView;

public class DSubjectDetailActivity extends AppCompatActivity implements DSubjectDetailView{

    private final String TAG = DSubjectDetailActivity.class.getName();

    private ViewPager pager;
    private TabLayout tab;
    private String dataReceived;

    private DetailPagerAdapter adapter;

    private DSubjectDetailPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_dsubject_detail);

        getDataFromPreviousActivity();
        setTitle(dataReceived);
        addControls();
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    private void init() {
        presenter = new DSubjectDetailPresenterImpl(this, new DecodeRawDataImpl());
    }

    private void getDataFromPreviousActivity() {
        dataReceived = getIntent().getExtras().getString(DSubjectActivity.FORWARD_KEY, "");
    }


    private void addControls() {
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab_layout);
    }


    @Override
    public void sendDataToFragment(AlgorithmModel data) {
       adapter = new DetailPagerAdapter(getSupportFragmentManager(), data);
       pager.setAdapter(adapter);

       tab.setupWithViewPager(pager, true);

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
