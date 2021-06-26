package com.example.familydb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        familyTreeImageBtn();
        reportCasesImageBtn();
        feedback();
        betaImageBtn();
    }

    private void familyTreeImageBtn(){
        ImageButton familyBtn = (ImageButton) findViewById(R.id.family_tree);
        familyBtn.setOnClickListener(v -> {
            Intent addingData = new Intent(MainActivity.this, AddFamilyActivity.class);
            startActivity(addingData);

        });
    }

    private void reportCasesImageBtn(){
        ImageButton reportCaseBtn = (ImageButton) findViewById(R.id.reporting);
        reportCaseBtn.setOnClickListener(v -> {
            Intent reportYourCase = new Intent(MainActivity.this, ReportYourCaseActivity.class);
            startActivity(reportYourCase);


        });
    }

    private void feedback(){
        ImageButton feedbackImageBtn = (ImageButton) findViewById(R.id.feedback);
        feedbackImageBtn.setOnClickListener(v -> {
            Intent talkToUs = new Intent(MainActivity.this, TalkToUsActivity.class);
            startActivity(talkToUs);

        });
    }

    private void betaImageBtn(){
        ImageButton betaBtn = (ImageButton) findViewById(R.id.beta);
        betaBtn.setOnClickListener(v -> {
            Intent learnFromCases = new Intent(MainActivity.this, LearnFromCasesActivity.class);
            startActivity(learnFromCases);

        });
    }
}