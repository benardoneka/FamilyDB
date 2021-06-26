package com.example.familydb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class FamilyListActivity extends AppCompatActivity {

    TextView tvTotalChildren;
    RecyclerView recyclerView;
    ChildAdapter childAdapter;
    ArrayList<Child> children;
    DatabaseHelper dBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_list);

        recyclerView = findViewById(R.id.recyclerView);
        tvTotalChildren = findViewById(R.id.tvTotalChildren);

        dBHelper = new DatabaseHelper(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

        children = dBHelper.getAllChildren();

        tvTotalChildren.setText("Total Children: " + children.size());

//        for (Child c : children ){
//            System.out.println(c.getnFather());
//        }
        childAdapter = new ChildAdapter(children, this);
        recyclerView.setAdapter(childAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llm);
    }
}