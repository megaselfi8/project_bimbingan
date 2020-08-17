package com.mega.project_bimbingan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mega.project_bimbingan.R;
import com.mega.project_bimbingan.adapter.TabPagerAdapter;


public class SearchFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    View view;
    ImageView image_favorite;
    private Toolbar toolbar;
    private TabPagerAdapter adapter;

    Spinner dataUrutan;
    TextView PilihUrutan;
    String urutan[] = {"Urutkan Berdasarkan", "A-Z", "Z-A"};


    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);


        toolbar = (Toolbar) view.findViewById(R.id.toolbar_search);
//        image_favorite = (ImageView) view.findViewById(R.id.favorite);

        if(((AppCompatActivity)getActivity()).getSupportActionBar() == null) {
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        }else toolbar.setVisibility(View.GONE);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        adapter = new TabPagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Spinner urutan berdasarkan
        dataUrutan = (Spinner)view.findViewById(R.id.spinner1);

        ArrayAdapter<String> arrayProdi = new ArrayAdapter<String>(getActivity(), R.layout.activity_list_urutan, R.id.textUrutan,urutan);
        dataUrutan.setAdapter(arrayProdi);

        dataUrutan.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


//        image_favorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create new fragment and transaction
//                Fragment newFragment = new FavoriteFragment();
//                // consider using Java coding conventions (upper first char class names!!!)
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//                // Replace whatever is in the fragment_container view with this fragment,
//                // and add the transaction to the back stack
//                transaction.replace(R.id.fragment_container, newFragment);
//                transaction.addToBackStack(null);
//
//                // Commit the transaction
//                transaction.commit();
//            }
//        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
