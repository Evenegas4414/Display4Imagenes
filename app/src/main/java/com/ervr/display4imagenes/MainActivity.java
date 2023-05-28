package com.ervr.display4imagenes;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView selectedImage;
    private int[] imageIds = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedImage = null;
    }

    public void selectImage(View view) {
        if (selectedImage != null) {
            selectedImage.setBackgroundColor(0);
        }

        selectedImage = (ImageView) view;
        selectedImage.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_700));

    }

    public void sendImage(View view) {
        if (selectedImage != null) {
            int selectedImageId = selectedImage.getId();

            int imageIndex = -1;
            for (int i = 0; i < imageIds.length; i++) {
                if (selectedImageId == getResources().getIdentifier("image" + (i + 1), "id", getPackageName())) {
                    imageIndex = i;
                    break;
                }
            }

            if (imageIndex != -1) {
                Intent intent = new Intent(this, DisplayActivity.class);
                intent.putExtra("imageId", imageIds[imageIndex]);
                startActivity(intent);
            }
        }
    }
}
