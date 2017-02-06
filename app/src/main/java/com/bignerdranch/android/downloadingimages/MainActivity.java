package com.bignerdranch.android.downloadingimages;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView downloadedImage;

    public void downloadImage(View view){

        //https://en.wikipedia.org/wiki/File:Bart_Simpson_200px.png

        ImageDownloader task = new ImageDownloader();

        Bitmap myImage;
        try {
            myImage = task.execute("https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png").get();

            downloadedImage.setImageBitmap(myImage);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadedImage = (ImageView)findViewById(R.id.imageView);
    }
}
