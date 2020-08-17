package com.mega.project_bimbingan.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.mega.project_bimbingan.R;

public class notification extends AppCompatActivity {

    ImageView btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btnback = (ImageView) findViewById(R.id.back5);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    public void daftar_dosen(View view) {
    }

    public void activity(View view) {

    }
}
