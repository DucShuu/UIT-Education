package com.example.ducdv.uiteducation.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.ducdv.uiteducation.R;
import com.example.ducdv.uiteducation.adapter.GridListSubjectAdapter;
import com.example.ducdv.uiteducation.base.repository.MainRepoImpl;
import com.example.ducdv.uiteducation.bussiness.MainPresenter;
import com.example.ducdv.uiteducation.bussiness.MainPresenterImpl;
import com.example.ducdv.uiteducation.ui.activity.DSubject.DSubjectActivity;
import com.example.ducdv.uiteducation.ui.contract.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private GridView listSubject;
    private GridListSubjectAdapter adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        init();

    }

    private void init() {
        presenter = new MainPresenterImpl(this, new MainRepoImpl());
    }

    private void addControls() {
        listSubject = findViewById(R.id.grid_subject);
    }

    @Override
    public void displayData(List<String> listSubject) {
        adapter = new GridListSubjectAdapter(this, listSubject, R.layout.list_subject_layout);
        this.listSubject.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadSubject();
        addEvents();

    }

    private void addEvents() {
        listSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, DSubjectActivity.class));
            }
        });
    }
}
