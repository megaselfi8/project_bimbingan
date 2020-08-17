package com.mega.project_bimbingan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mega.project_bimbingan.adapter.TabPagerAdapter;

public class listDosen extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    private Toolbar toolbar;
    private TabPagerAdapter adapter;

    Spinner dataUrutan;
    TextView PilihUrutan;
    String urutan[] = {"Urutkan Berdasarkan", "A-Z", "Z-A"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dosen);

        toolbar = (Toolbar) findViewById(R.id.toolbar_search);

        if(getSupportActionBar() == null) {
            setSupportActionBar(toolbar);
        }else toolbar.setVisibility(View.GONE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        dataUrutan = (Spinner)findViewById(R.id.spinner1);

        ArrayAdapter<String> arrayProdi = new ArrayAdapter<String>(this,
                R.layout.activity_list_urutan, R.id.textUrutan,urutan);
        dataUrutan.setAdapter(arrayProdi);

        dataUrutan.setOnItemSelectedListener(this);
        
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id){
        //if(++check > 1){
//        PilihProdi = (TextView) findViewById(R.id.pilihProgramStudi);
//        String pilih = (String) parent.getItemAtPosition(i);
//        PilihProdi.setText(pilih);
//        // }
    }

    public void onNothingSelected(AdapterView<?> arg0){
        String prodi = dataUrutan.getSelectedItem().toString();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    
}
