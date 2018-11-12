package com.bequite.rathind.marvel;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScrollingActivity extends AppCompatActivity {
private List mCallListUserResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getData();

    }

    public void getData()
    {


        final Call<ResulList> resultList = MarvelApi.getResultService().getResultList();
        resultList.enqueue(new Callback<ResulList>() {

            @Override
            public void onResponse(Call<ResulList> call, Response<ResulList> response) {
                ResulList resulList = response.body();


//Description
                String description = resulList.getData().getResults().get(0).getDescription();
                TextView summary = findViewById(R.id.description);
                summary.setText(description);
//Comic Image
                String image_url = resulList.getData().getResults().get(0).getThumbnail().getPath();
                ImageView collapsableToolbar = findViewById(R.id.collapsebarimg);

                Glide.with(ScrollingActivity.this)
                        .load(image_url + "/standard_fantastic.jpg")
                        .into(collapsableToolbar);
// Price
                String price = resulList.getData().getResults().get(0).getPrices().get(0).getPrice().toString();
                Button comicprice = findViewById(R.id.price);
                comicprice.setText("$ "+price);
//Creators
                String penciler  = resulList.getData().getResults().get(0).getCreators().getItems().get(3).getName();
                TextView comicPenciler = findViewById(R.id.penciler);
                comicPenciler.setText(penciler);

                String colorist =resulList.getData().getResults().get(0).getCreators().getItems().get(2).getName();
                TextView comicColorist = findViewById(R.id.colorist);
                comicColorist.setText(colorist);

                String writter = resulList.getData().getResults().get(0).getCreators().getItems().get(5).getName();
                TextView comicWritter = findViewById(R.id.writter);
                comicWritter.setText(writter);


//Title
                String seriesName = resulList.getData().getResults().get(0).getTitle();
                TextView comicName = findViewById(R.id.comictitle);
                comicName.setText(seriesName);

            }

            @Override
            public void onFailure(Call<ResulList> call, Throwable t) {
                Toast.makeText(ScrollingActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
