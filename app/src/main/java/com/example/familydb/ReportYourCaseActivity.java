package com.example.familydb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ReportYourCaseActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private EditText phone;
    private ImageButton call;

    EditText emailTo, emailSubject, emailMessage;
    Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_your_case);

        //Phone area, collecting user inputs
        phone = findViewById(R.id.phone);
        call = findViewById(R.id.dialPhone);

        //Email area collecting user inputs
        emailTo = findViewById(R.id.email_to);
        emailSubject = findViewById(R.id.email_subject);
        emailMessage = findViewById(R.id.emailMessage);

        btnEmail = findViewById(R.id.btnEmail);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etTo = emailTo.getText().toString();
                String etSubject = emailSubject.getText().toString();
                String etMessage = emailMessage.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + etTo));
                intent.putExtra(Intent.EXTRA_SUBJECT, etSubject);
                intent.putExtra(Intent.EXTRA_TEXT, etMessage);
                startActivity(intent);

                emailTo.getText().clear();
                emailSubject.getText().clear();
                emailMessage.getText().clear();

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });

    }
    private void makePhoneCall() {
        String number = phone.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(ReportYourCaseActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(ReportYourCaseActivity.this,
                        new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            }else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }else {
            Toast.makeText(ReportYourCaseActivity.this,
                    "Enter Phone Number", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show();
            }
        }
    }
}