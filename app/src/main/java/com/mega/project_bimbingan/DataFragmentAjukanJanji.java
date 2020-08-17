package com.mega.project_bimbingan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataFragmentAjukanJanji extends Fragment {

    private Context context;
    private ExpandableListView list_view_janji;
    List<String> listDataParent;
    HashMap<String, List<String>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.context = this.getActivity();
        return inflater.inflate(R.layout.fragment_data_list_janji, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list_view_janji = (ExpandableListView) view.findViewById(R.id.list_view11);
        createListData();

        // Listview Group click listener
        list_view_janji.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // TODO GroupClickListener work
                return false;
            }
        });

        // Listview Group expanded listener
        list_view_janji.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                // TODO GroupExpandListener work
            }
        });

        // Listview Group collasped listener
        list_view_janji.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                // TODO GroupCollapseListener work
            }
        });

        // Listview on child click listener
        list_view_janji.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText( context,
                        "wow, this is - "+listDataChild.get(listDataParent.get(groupPosition)).get(childPosition),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void createListData() {
        listDataParent = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataParent.add("Colors");
        listDataParent.add("Fruits");
        listDataParent.add("Animals");


        // Adding child data List one
        List<String> colors = new ArrayList<String>();
        colors.add("Red");


        // Adding child data List two
        List<String> fruits  = new ArrayList<String>();
        fruits.add("Apples");


        // Adding child data List three
        List<String> animals = new ArrayList<String>();
        animals.add("Dog");


        listDataChild.put(listDataParent.get(0), colors); // Header, Child data
        listDataChild.put(listDataParent.get(1), fruits); // Header, Child data
        listDataChild.put(listDataParent.get(2), animals); // Header, Child data

        ExpandableListAdapterAjukanJanji listAdapter = new ExpandableListAdapterAjukanJanji(context, listDataParent, listDataChild);
        list_view_janji.setAdapter(listAdapter);
    }

}
