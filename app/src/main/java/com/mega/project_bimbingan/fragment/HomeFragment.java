package com.mega.project_bimbingan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.mega.project_bimbingan.R;
import com.mega.project_bimbingan.ui.notification;


public class HomeFragment extends Fragment {

    View view;
    ImageView image_notif;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        image_notif = (ImageView) view.findViewById(R.id.notification);

        image_notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), notification.class);
                startActivity(intent);
            }
        });

        return view;
    }



//    public void notif3(View view) {
//        Intent intent = new Intent(getActivity(), notification.class);
//        startActivity(intent);
//    }

}
