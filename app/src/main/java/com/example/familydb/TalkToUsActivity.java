package com.example.familydb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TalkToUsActivity extends AppCompatActivity {
    private static final String TAG = "TalkToUsActivity";

    String area, doctor, date, appointmentData;
    int mobileN;

    EditText searchArea, searchDoctor, selectDate, mobile;
    Button btnSubmit, viewAppoint;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk_to_us);

        searchArea = findViewById(R.id.selectArea);
        searchDoctor = findViewById(R.id.search);
        selectDate = findViewById(R.id.selectDate);
        mobile = findViewById(R.id.selectContact);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TalkToUsActivity.this, AppointmentBookingActivity.class);

                area = searchArea.getText().toString().trim();
                doctor = searchDoctor.getText().toString().trim();
                date = selectDate.getText().toString().trim();
                mobileN = Integer.parseInt(mobile.getText().toString().trim());

                appointmentData = "Area: " + area.toUpperCase() +
                        "\n" + doctor.toUpperCase() + " will be attending to you" +
                        "\n" + " On " + date +
                        "\n" + " Contact " + mobileN;
                intent.putExtra("booking", appointmentData);

                Log.d(TAG, "TalkToUsActivity: About to create an intent with " + appointmentData);
                startActivity(intent);
                searchArea.getText().clear();
                searchDoctor.getText().clear();
                selectDate.getText().clear();
                mobile.getText().clear();

            }
        });
        viewAppoint = findViewById(R.id.btnViewAppoint);
        output = findViewById(R.id.viewAppoint);

        viewAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("myAppointment", Context.MODE_PRIVATE);
                String savedDataInfo = sharedPreferences.getString("myAppointment", "");
                output.setText(savedDataInfo);
            }
        });
    }

}