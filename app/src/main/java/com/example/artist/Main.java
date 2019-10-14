package com.example.artist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {
    Button addArtist;
    Button addPhoto;
    Button Delete;
    Button View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addArtist = findViewById(R.id.addartist);
        addPhoto = findViewById(R.id.addphoto);
        Delete = findViewById(R.id.deleteartistPhoto);
        View = findViewById(R.id.viewPhoto);

        addArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(Main.this,AddArtist.class);
                startActivity(intent);

            }
        });

        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(Main.this,AddPhotograph.class);
                startActivity(intent);
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

            }
        });

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(Main.this,ViewPhotos.class);
                startActivity(intent);
            }
        });

    }
}
