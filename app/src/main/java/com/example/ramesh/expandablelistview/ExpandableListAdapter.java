package com.example.ramesh.expandablelistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by J.yugandhar on 17-07-2017.
 */

class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listDataChild;
    }
    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView==null){
            LayoutInflater infalInflater    = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView     =   infalInflater.inflate(R.layout.list_item,null);

        }
       TextView txtListChild   =    convertView.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        int subDrawables[]={R.drawable.pizza1,R.drawable.sub_juice,R.drawable.sub_breakfast,R.drawable.sub_pizza,R.drawable.sub_pint,R.drawable.sub_chicken_leg,R.drawable.sub_pint};
        ImageView imageView =   convertView.findViewById(R.id.lbListItemIcon);

        imageView.setImageResource(subDrawables[childPosition]);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return this._listDataHeader.get(groupPosition);

//        this._MenuHeader.get(groupPosition);

    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition);
//        int menu = (Integer) getGroup(groupPosition);

        if (convertView==null){
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }


        int imagesofGroup[]   ={
                R.drawable.pizza,
                R.drawable.burger,
                R.drawable.doughnut,
                R.drawable.strawberry,
                R.drawable.soup,
                R.drawable.chicken,
                R.drawable.chocolate,
                R.drawable.cannedfood,
                R.drawable.cake1
        };
//        String[] headnames  =   {
//                "Pizza",
//                "Burger",
//                "Desert",
//                "Fruit",
//                "Soup",
//                "Chicken Items",
//                "Chocolate",
//                "Beverages",
//                "Cake",
//        };
        ImageView imageView =   convertView.findViewById(R.id.lbListIcon);
//        imageView.setImageResource(menu);

        TextView lblListHeader = convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        imageView.setImageResource(imagesofGroup[groupPosition]);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
