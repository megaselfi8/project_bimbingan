package com.mega.project_bimbingan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mega.project_bimbingan.adapter.ExpandableListAdapterBooking;
import com.mega.project_bimbingan.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataFragmentBooking extends Fragment {

    private Context context;
    private ExpandableListView list_view;
    List<String> listDataParent;
    HashMap<String, List<String>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.context = this.getActivity();
        return inflater.inflate(R.layout.fragment_data_list_booking, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list_view = (ExpandableListView) view.findViewById(R.id.list_view22);
        createListData();

        // Listview Group click listener
        list_view.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // TODO GroupClickListener work
                return false;
            }
        });

        // Listview Group expanded listener
        list_view.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                // TODO GroupExpandListener work
            }
        });

        // Listview Group collasped listener
        list_view.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                // TODO GroupCollapseListener work
            }
        });

        // Listview on child click listener
        list_view.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

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
        listDataParent.add("Nama Mahasiswa");
        listDataParent.add("Nama Mahasiswa");
        listDataParent.add("Nama Mahasiswa");

        // Adding child data List one
        List<String> nama_mahasiswa = new ArrayList<String>();
        nama_mahasiswa.add("nama");

        // Adding child data List two
        List<String> nama_mahasiswa1  = new ArrayList<String>();
        nama_mahasiswa1.add("nama");


        // Adding child data List three
        List<String> nama_mahasiswa2 = new ArrayList<String>();
        nama_mahasiswa2.add("nama");


        listDataChild.put(listDataParent.get(0), nama_mahasiswa); // Header, Child data
        listDataChild.put(listDataParent.get(1), nama_mahasiswa1); // Header, Child data
        listDataChild.put(listDataParent.get(2), nama_mahasiswa2); // Header, Child data

        ExpandableListAdapterBooking listAdapter = new ExpandableListAdapterBooking(context, listDataParent, listDataChild);
        list_view.setAdapter(listAdapter);
    }

}
