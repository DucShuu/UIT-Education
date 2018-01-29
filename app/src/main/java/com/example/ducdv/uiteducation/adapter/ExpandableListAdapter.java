package com.example.ducdv.uiteducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ducdv.uiteducation.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by DucDV on 01/28/2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter{

    private Context context;
    private List<String> listDataContent;
    private HashMap<String, List<String>> listDataContentChild;

    public ExpandableListAdapter(Context context, List<String> listDataContent, HashMap<String, List<String>> listDataContentChild) {
        this.context = context;
        this.listDataContent = listDataContent;
        this.listDataContentChild = listDataContentChild;
    }

    @Override
    public int getGroupCount() {
        return listDataContent.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listDataContentChild.get(listDataContent.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataContent.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataContentChild.get(this.listDataContent.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeaderTitle = convertView.findViewById(R.id.lbl_list_group);
        lblListHeaderTitle.setText(headerTitle);

        ImageView img = convertView.findViewById(R.id.img_expand);

        img.setSelected(isExpanded);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView lblChildText = convertView.findViewById(R.id.lbl_list_item);
        lblChildText.setText(childText);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
