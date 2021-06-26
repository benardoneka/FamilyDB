package com.example.familydb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateFamilyActivity extends AppCompatActivity {

    EditText fName, mName, cName, cAge, pNumber, rCase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_family);

        Child c = (Child) getIntent().getExtras().getSerializable("CHILD");

        id = c.getId();
        fName = findViewById(R.id.fName);
        mName = findViewById(R.id.mName);
        cName = findViewById(R.id.cName);
        cAge = findViewById(R.id.cAge);
        pNumber = findViewById(R.id.pNumber);
        rCase = findViewById(R.id.rCase);

        fName.setText(c.getnFather());
        mName.setText(c.getnMother());
        cName.setText(c.getnChild());
        cAge.setText(c.getChildAge());
        pNumber.setText(c.getMobile());
        rCase.setText(c.getCaseR());
    }

    public void update(View view) {

        String nFather = fName.getText().toString().trim();
        String nMother = mName.getText().toString().trim();
        String nChild = cName.getText().toString().trim();
        String childAge = cAge.getText().toString().trim();
        String mobile = pNumber.getText().toString().trim();
        String caseR = rCase.getText().toString().trim();

        Child c = new Child(id, nFather, nMother, nChild, childAge, mobile, caseR);

        DatabaseHelper dBHelper = new DatabaseHelper(this);
        int result = dBHelper.UpdateChild(c);

        if (result > 0) {
            Toast.makeText(this, "Updated " + result, Toast.LENGTH_SHORT).show();
            finish();
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
}