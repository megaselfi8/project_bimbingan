package com.mega.project_bimbingan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.mega.project_bimbingan.adapter.ExpandableListAdapter;
import com.mega.project_bimbingan.R;
import com.mega.project_bimbingan.ui.jadwal_ketemu_dosen;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DataFragment extends Fragment {

    private Context context;
    private ExpandableListView list_view;
    List<String> listDataParent;
    HashMap<String, List<String>> listDataChild;
    Intent intent ;


    public DataFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.context = this.getActivity();
        return inflater.inflate(R.layout.fragment_data_list, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list_view = (ExpandableListView) view.findViewById(R.id.list_view);
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
                        "Note - "+listDataChild.get(listDataParent.get(groupPosition)).get(childPosition),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String getName = listDataParent.get(position);

                Intent intent = new Intent(getActivity(), jadwal_ketemu_dosen.class);
                intent.putExtra("Detail", getName);
                startActivity(intent);

            }
        });

    }

    private void createListData() {
        listDataParent = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataParent.add("Bayu Rahayudi, S.T, M.T");
        listDataParent.add("Dian Eka, S.T, M.T");
        listDataParent.add("Ratna Ningsih, S.T, M.T");

        // Adding child data List one
        List<String> colors = new ArrayList<String>();
        colors.add("Saya Available dari jam 12.00-15.00. diluar jam itu saya sedang ada agenda, minta tolong segera diagendakan dan dijadwalkan sesuai awaktu saya. Terimakasih");

        // Adding child data List two
        List<String> fruits  = new ArrayList<String>();
        fruits.add("Saya Available dari jam 12.00-15.00. diluar jam itu saya sedang ada agenda, minta tolong segera diagendakan dan dijadwalkan sesuai awaktu saya. Terimakasih");

        // Adding child data List three
        List<String> animals = new ArrayList<String>();
        animals.add("Saya Available dari jam 12.00-15.00. diluar jam itu saya sedang ada agenda, minta tolong segera diagendakan dan dijadwalkan sesuai awaktu saya. Terimakasih");

        listDataChild.put(listDataParent.get(0), colors); // Header, Child data
        listDataChild.put(listDataParent.get(1), fruits); // Header, Child data
        listDataChild.put(listDataParent.get(2), animals); // Header, Child data

        ExpandableListAdapter listAdapter = new ExpandableListAdapter(context, listDataParent, listDataChild);
        list_view.setAdapter(listAdapter);

    }

}
