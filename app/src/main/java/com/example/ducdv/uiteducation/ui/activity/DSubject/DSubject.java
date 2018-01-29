package com.example.ducdv.uiteducation.ui.activity.DSubject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.ducdv.uiteducation.R;
import com.example.ducdv.uiteducation.adapter.ExpandableListAdapter;
import com.example.ducdv.uiteducation.base.repository.DSubjectRepoImpl;
import com.example.ducdv.uiteducation.bussiness.DSubjectPresenter;
import com.example.ducdv.uiteducation.bussiness.DSubjectPresenterImpl;
import com.example.ducdv.uiteducation.ui.contract.DSubjectView;

import java.util.HashMap;
import java.util.List;

public class DSubject extends AppCompatActivity implements DSubjectView {

    private ExpandableListView listContent;
    private ExpandableListAdapter adapter;
    private DSubjectPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsubject);

        addControls();
        init();

    }

    private void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void init(){
        presenter = new DSubjectPresenterImpl(this, new DSubjectRepoImpl());
    }

    private void addControls(){
        listContent = findViewById(R.id.list_content_dsubject);

    }

    @Override
    public void displayView(List<String> header, HashMap<String, List<String>> listChildContent) {
        adapter = new ExpandableListAdapter(this, header, listChildContent);
        listContent.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        showToastMessage(message);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadDataToAdapter();
    }


}
