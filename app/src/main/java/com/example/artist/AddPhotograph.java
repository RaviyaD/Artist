package com.example.artist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddPhotograph extends AppCompatActivity {

    EditText name;
    EditText artistName;
    ImageView imageview;
    Button addPhoto;
    Button addPhotograph;
    PhotoModel photo;
    DBHandler dbHandler;
    private static final int RESULT_LOAD_IMG= 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photograph);
        name= findViewById(R.id.name);
        artistName=findViewById(R.id.artistName);
        imageview = findViewById(R.id.imageView);
        addPhoto = findViewById(R.id.addphoto);
        addPhotograph = findViewById(R.id.button2);
        photo = new PhotoModel();
        dbHandler = new DBHandler(this);


        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
            }
        });

        addPhotograph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photo.setName(name.getText().toString());
                photo.setArtistName(artistName.getText().toString());


                Bitmap bitmap = ((BitmapDrawable) imageview.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] imageInByte = baos.toByteArray();

                photo.setImage(imageInByte);

                dbHandler.addphoto(photo);

                Intent intent = new Intent(AddPhotograph.this,Main.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageview.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(AddPhotograph.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(AddPhotograph.this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }
}
