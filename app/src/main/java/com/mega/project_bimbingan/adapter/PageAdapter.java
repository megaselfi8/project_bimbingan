package com.mega.project_bimbingan.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mega.project_bimbingan.fragment.ListBookingFragment;
import com.mega.project_bimbingan.fragment.NoteFragment;

public class PageAdapter extends FragmentPagerAdapter {

    private  int numOfTabs;

    public PageAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0 :
                return  new NoteFragment();
            case 1 :
                return  new ListBookingFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
