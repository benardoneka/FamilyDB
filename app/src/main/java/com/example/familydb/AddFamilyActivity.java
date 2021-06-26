package com.example.familydb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddFamilyActivity extends AppCompatActivity {
    private static final String TAG = "AddFamilyActivity";

    EditText fName, mName, cName, cAge, pNumber, rCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_family);

        fName = findViewById(R.id.fName);
        mName = findViewById(R.id.mName);
        cName = findViewById(R.id.cName);
        cAge = findViewById(R.id.cAge);
        pNumber = findViewById(R.id.pNumber);
        rCase = findViewById(R.id.rCase);
    }

    public void save(View view) {
//        Intent addFamilyData = new Intent(AddFamilyActivity.this, FamilyListActivity.class);
//        startActivity(addFamilyData);
        String nFather = fName.getText().toString().trim();
        String nMother = mName.getText().toString().trim();
        String nChild = cName.getText().toString().trim();
        String childAge = cAge.getText().toString().trim();
        String mobile = pNumber.getText().toString().trim();
        String caseR = rCase.getText().toString().trim();

        DatabaseHelper dBHelper = new DatabaseHelper(AddFamilyActivity.this);
        Child child = new Child(nFather, nMother, nChild, childAge, mobile, caseR);


        long result = dBHelper.addChildData(child);
         if (result > 0) {
             Toast.makeText(this, "Saved " + result, Toast.LENGTH_SHORT).show();
             fName.getText().clear();
             mName.getText().clear();
             cName.getText().clear();
             cAge.getText().clear();
             pNumber.getText().clear();
             rCase.getText().clear();

         }else {
             Toast.makeText(this, "Failed " + result, Toast.LENGTH_SHORT).show();
         }

    }

    public void showAll(View view) {
        Intent viewFamilyData = new Intent(AddFamilyActivity.this, FamilyListActivity.class);
        startActivity(viewFamilyData);
    }
}