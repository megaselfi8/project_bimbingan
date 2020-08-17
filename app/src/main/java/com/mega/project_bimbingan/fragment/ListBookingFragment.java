package com.mega.project_bimbingan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mega.project_bimbingan.R;
import com.mega.project_bimbingan.adapter.TabPagerAdapterBooking;


public class ListBookingFragment extends Fragment {

    View view;
    private Toolbar toolbar;
    private TabPagerAdapterBooking adapter;

    public ListBookingFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_booking, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager22);
        adapter = new TabPagerAdapterBooking(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs22);
        tabLayout.setupWithViewPager(viewPager);

        return  view;
    }

////    @Override
    public void onBackPressed() {
        getActivity().onBackPressed();
    }

}
