package com.mega.project_bimbingan.fragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.Fragment;

import com.mega.project_bimbingan.R;
import com.mega.project_bimbingan.ui.jadwal_ketemu_dosen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AddFragment extends Fragment {

    View view;
    TextView tvTimer1, tvTimer2;
    int t1Hour, t1Minute, t2Hour, t2Minute;

    Button bAtur;
    TextView tPilih;
//    RadioButton rAvailable, rNotAvailable;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add, container, false);

        bAtur = (Button) view.findViewById(R.id.btnAtur);
//        tPilih = (TextView) findViewById(R.id.textPilih);
//        rAvailable = (RadioButton) findViewById(R.id.radioA);
//        rNotAvailable =(RadioButton) findViewById(R.id.radioNA);


        tvTimer1 = view.findViewById(R.id.tv_timer);
        tvTimer2 = view.findViewById(R.id.tv_timer2);

        tvTimer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour   = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0, 0, 0, t1Hour, t1Minute);

                                tvTimer1.setText(DateFormat.format("hh:mm aa",calendar));
                            }
                        }, 12, 0, false
                );

                timePickerDialog.updateTime(t1Hour, t1Minute);

                timePickerDialog.show();
            }
        });


        tvTimer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getActivity(),
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                t2Hour = hourOfDay;
                                t2Minute = minute;

                                String time = t2Hour + ":" + t2Minute;

                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);

                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    tvTimer2.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 12, 0, false
                );

                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

                timePickerDialog.updateTime(t2Hour, t2Minute);

                timePickerDialog.show();
            }
        });

        bAtur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), jadwal_ketemu_dosen.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
