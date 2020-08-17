package com.mega.project_bimbingan.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.mega.project_bimbingan.R;
import com.mega.project_bimbingan.fragment.AddDosenFragment;

public class dosen_jadwal_temu_mhs extends AppCompatActivity {

    Button btn_ok;
    Button btn_cencel;
    ImageView btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_jadwal_temu_mhs);

        btn_ok = (Button) findViewById(R.id.btnOkDosen);
        btn_cencel = (Button) findViewById(R.id.btnCencel);
        btnback = (ImageView) findViewById(R.id.back);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        btn_cencel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create new fragment and transaction
                Fragment newFragment = new AddDosenFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content, newFragment);
                transaction.addToBackStack(null);//add the transaction to the back stack so the user can navigate back
// Commit the transaction
                transaction.commit();
            }
        });
    }




}
