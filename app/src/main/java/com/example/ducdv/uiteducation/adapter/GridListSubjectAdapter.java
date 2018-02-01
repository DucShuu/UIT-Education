package com.example.ducdv.uiteducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ducdv.uiteducation.R;

import java.util.List;

/**
 * Created by DucDV on 02/01/2018.
 */

public class GridListSubjectAdapter extends BaseAdapter {

    private Context context;
    private List<String> listSubject;
    private int layoutId;

    public GridListSubjectAdapter(Context context, List<String> listSubject, int layoutId) {
        this.context = context;
        this.listSubject = listSubject;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return listSubject.size();
    }

    @Override
    public Object getItem(int position) {
        return listSubject.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.list_subject_layout, parent, false);
        TextView lblSubjectName = view.findViewById(R.id.lbl_subject_name);
        lblSubjectName.setText(listSubject.get(position));

        return view;
    }
}
