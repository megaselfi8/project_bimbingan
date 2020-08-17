package com.mega.project_bimbingan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.mega.project_bimbingan.R;


public class UserFragment extends Fragment {

    View view;
    ListView listView;
    String[] pengaturan = new String[] {"Profile", "Keamanan", "Panduan",
            "Syarat dan Ketentuan", "Kebijakan Privasi", "Pusat Bantuan"};
    int[] image = new int[] {R.drawable.rectangle, R.drawable.rectangle, R.drawable.rectangle,
            R.drawable.rectangle, R.drawable.rectangle, R.drawable.rectangle};

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user, container, false);

        listView = view.findViewById(R.id.profileList);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);


        return view;
    }

    public void btnback(View view) {
    }



    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return image.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.rowlayout,null);

            ImageView imageView = (ImageView) view.findViewById(R.id.rectangle);
            TextView textView = (TextView) view.findViewById(R.id.textView);

            imageView.setImageResource(image[i]);
            textView.setText(pengaturan[i]);

            return view;
        }
    }
}
