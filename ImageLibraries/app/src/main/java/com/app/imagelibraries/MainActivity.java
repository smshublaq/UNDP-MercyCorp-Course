package com.app.imagelibraries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.toolbox.NetworkImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkImageView networkImageView = findViewById(R.id.img);


        networkImageView.setImageUrl
                ("https://vignette.wikia.nocookie.net/pokemon/images/1/13/007Squirtle_Pokemon_Mystery_Dungeon_Explorers_of_Sky.png/revision/latest?cb=20150105230449"
                        ,MyApplication.getInstance().getImageLoader());

    }
}
