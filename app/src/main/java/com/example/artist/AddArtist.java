package com.example.artist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddArtist extends AppCompatActivity {
    Button add;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_artist);

        add = findViewById(R.id.adding);
        name = findViewById(R.id.artist);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String artist = name.getText().toString();



                name.setText("");
            }
        });
    }
}
