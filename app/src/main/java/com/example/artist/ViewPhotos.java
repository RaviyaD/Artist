package com.example.artist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewPhotos extends AppCompatActivity {
    GridView gridview;
    DBHandler dbHandler;
    public static List<Bitmap> imagelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photos);

        gridview = findViewById(R.id.grid);
        dbHandler = new DBHandler(this);

        List<PhotoModel> list = new ArrayList<>();
        imagelist = new ArrayList<>();



        list = dbHandler.readAllPhoto();


        for(PhotoModel m:list){
            imagelist.add(BitmapFactory.decodeByteArray(m.image, 0, m.image.length));
            System.out.println("===="+m.image.length);
        }

    gridview.setAdapter(new ImageAdapter(this));


    }
}
