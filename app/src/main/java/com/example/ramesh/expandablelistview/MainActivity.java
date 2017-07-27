package com.example.ramesh.expandablelistview;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
//    List<GroupData> groupData;
    int drawable_width;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Drawable drawable_groupIndicator =
                getResources().getDrawable(android.R.drawable.arrow_down_float);
         drawable_width = drawable_groupIndicator.getMinimumWidth();
        setContentView(R.layout.activity_main);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
//        expListView.setGroupIndicator(getResources().getDrawable(R.drawable.dropbox));
//        expListView.setChildIndicator(getResources().getDrawable(R.drawable.envato));
//        expListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                expListView.se
//            }
//        });


        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if(groupPosition != previousGroup)
                    expListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
//        groupData = new ArrayList<>();
        listDataChild = new HashMap<>();
//
//        int imagesofGroup[]   ={
//                R.drawable.pizza,
//                R.drawable.burger,
//                R.drawable.doughnut,
//                R.drawable.strawberry,
//                R.drawable.soup,
//                R.drawable.chicken,
//                R.drawable.chocolate,
//                R.drawable.cannedfood,
//                R.drawable.cake1
//        };
//        String[] headnames  =   {
//                "Pizza",
//        "Burger",
//        "Desert",
//        "Fruit",
//        "Soup",
//        "Chicken Items",
//        "Chocolate",
//        "Beverages",
//        "Cake",
//        };

        // Adding child data
        listDataHeader.add("Pizza");
        listDataHeader.add("Burger");
        listDataHeader.add("Desert");
        listDataHeader.add("Fruit");
        listDataHeader.add("Soup");
        listDataHeader.add("Chicken Items");
        listDataHeader.add("Chocolate");
        listDataHeader.add("Beverages");
        listDataHeader.add("Cake");



        // Adding child data
        List<String> pizza_items = new ArrayList<>();
        pizza_items.add("margherita");
        pizza_items.add("double-cheese-margherita");
        pizza_items.add("country-special");
        pizza_items.add("farm-house");
        pizza_items.add("peppy-paneer");
        pizza_items.add("mexican-green-wave");
        pizza_items.add("deluxe-veggie");



        List<String> nowShowing = new ArrayList<>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");


        List<String> comingSoon = new ArrayList<>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");


        listDataChild.put(listDataHeader.get(0), pizza_items); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), comingSoon);
        listDataChild.put(listDataHeader.get(4), comingSoon);
        listDataChild.put(listDataHeader.get(5), comingSoon);
        listDataChild.put(listDataHeader.get(6), comingSoon);
        listDataChild.put(listDataHeader.get(7), comingSoon);
        listDataChild.put(listDataHeader.get(8), comingSoon);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        expListView.setIndicatorBounds(expListView.getRight()-100,expListView.getWidth());
    }
}

