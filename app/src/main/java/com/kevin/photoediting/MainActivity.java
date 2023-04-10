package com.kevin.photoediting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgstart, imgmore;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgstart = findViewById(R.id.imgstart);
        imgmore = findViewById(R.id.imgmore);

        imgstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == 1) {
                Uri uri = data.getData();
                imgstart.setImageURI(uri);
            }
        }
    }
}