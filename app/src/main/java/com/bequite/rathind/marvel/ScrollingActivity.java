package com.bequite.rathind.marvel;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getData();
        RecyclerView recyclerView = findViewById(R.id.previewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    private void getData()

    {
        Call<ResulList> resultList = MarvelApi.getResultService().getResultList();
        resultList.enqueue(new Callback<ResulList>() {
            @Override
            public void onResponse(Call<ResulList> call, Response<ResulList> response) {
                ResulList resulList = response.body();
                String description = resulList.getData().getResults().get(0).getDescription();

                TextView summary = findViewById(R.id.description);
                summary.setText(description);


            }

            @Override
            public void onFailure(Call<ResulList> call, Throwable t) {
                Toast.makeText(ScrollingActivity.this,"Error",Toast.LENGTH_SHORT).show();


            }
        });

    }


}
