package com.Rakibul.quotify.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.Rakibul.quotify.QuotesAdapter;
import com.Rakibul.quotify.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RobiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robi);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Robi");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView quoteList = findViewById(R.id.quoteList);
        quoteList.setLayoutManager(new LinearLayoutManager(this));
        quoteList.setAdapter(new QuotesAdapter(getQuotes(), this));
    }

    private List<String> getQuotes() {
        List<String> quotes = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getAssets().open("quotes3.txt"), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                quotes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return quotes;
    }
}




