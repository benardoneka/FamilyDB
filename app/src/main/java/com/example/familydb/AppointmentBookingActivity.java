package com.example.familydb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AppointmentBookingActivity extends AppCompatActivity {
    TextView output;
    Button saveAppoint;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_booking);

        Bundle appointmentData = getIntent().getExtras();

        if (appointmentData == null) {
            return;
        }
        String appointment = appointmentData.getString("booking");

        //Creating a debug log message for the message being received from ScriptureIntent, can be viewed in Logcat
        Log.d("TalkToUsActivity", "Received intent with " + appointment);

        //Setting the received message to be viewed on a text view field created
        TextView output = (TextView) findViewById(R.id.textView);
        output.setText(appointment);

        saveAppoint = findViewById(R.id.btnSave);
        sharedPreferences = getSharedPreferences("myAppointment", Context.MODE_PRIVATE);

        saveAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("myAppointment", appointment);
                editor.commit();
                Toast.makeText(AppointmentBookingActivity.this, "Saved Successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}