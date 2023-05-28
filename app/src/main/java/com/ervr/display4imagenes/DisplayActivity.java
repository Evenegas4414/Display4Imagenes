package com.ervr.display4imagenes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    private ImageView displayedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        displayedImage = findViewById(R.id.displayedImage);

        Intent intent = getIntent();
        int imageId = intent.getIntExtra("imageId", 0);
        displayedImage.setImageResource(imageId);

    }

    public void goBack(View view) {
        finish();
    }

    public void closeApp(View view) {
        finishAffinity();
    }
}
