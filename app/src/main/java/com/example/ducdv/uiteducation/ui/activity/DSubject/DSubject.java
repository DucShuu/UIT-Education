package com.example.ducdv.uiteducation.ui.activity.DSubject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

    public static final String FORWARD_KEY = "Algorithm's Name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsubject);

        addControls();
        init();
        setEvents();

    }

    private void setEvents() {
       listContent.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
           @Override
           public boolean onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id) {

               final String algorithmName = (String) adapter.getChild(groupPosition, childPosition);

               goToDetailActivity(algorithmName);

               return false;
           }
       });
    }

    private void goToDetailActivity(String algorithmName) {

        Intent goToDetail = new Intent(this, DSubjectDetail.class);
        goToDetail.putExtra(FORWARD_KEY , algorithmName);

        startActivity(goToDetail);

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
