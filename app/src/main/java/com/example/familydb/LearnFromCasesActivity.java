package com.example.familydb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

public class LearnFromCasesActivity extends AppCompatActivity {

    private WebView webView;
    private SearchView searchView;
    Button btnSearch;

    TextView caseOne, caseTwo, caseThree, caseFour, caseFive, caseSix, caseSeven, caseEight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_from_cases);

        caseOne = findViewById(R.id.linkOne);
        caseOne.setMovementMethod(LinkMovementMethod.getInstance());

        caseTwo = findViewById(R.id.linkTwo);
        caseTwo.setMovementMethod(LinkMovementMethod.getInstance());

        caseThree = findViewById(R.id.linkThree);
        caseThree.setMovementMethod(LinkMovementMethod.getInstance());

        caseFour = findViewById(R.id.linkFour);
        caseFour.setMovementMethod(LinkMovementMethod.getInstance());

        caseFive = findViewById(R.id.linkFive);
        caseFive.setMovementMethod(LinkMovementMethod.getInstance());

        caseSix = findViewById(R.id.linkSix);
        caseSix.setMovementMethod(LinkMovementMethod.getInstance());

        caseSeven = findViewById(R.id.linkSeven);
        caseSeven.setMovementMethod(LinkMovementMethod.getInstance());

        caseEight = findViewById(R.id.linkEight);
        caseEight.setMovementMethod(LinkMovementMethod.getInstance());

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

//        btnSearch = findViewById(R.id.btnSearch);
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });

        searchView = findViewById(R.id.searchCase);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                webView.loadUrl("http://google.com/search?q=" + searchView.getQuery());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
    }
}