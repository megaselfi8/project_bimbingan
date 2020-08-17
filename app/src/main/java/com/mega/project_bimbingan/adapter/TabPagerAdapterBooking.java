package com.mega.project_bimbingan.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mega.project_bimbingan.fragment.DataFragmentBooking;

public class TabPagerAdapterBooking extends FragmentPagerAdapter {

    public TabPagerAdapterBooking(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new DataFragmentBooking();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "List";
        }
        return title;
    }

}
