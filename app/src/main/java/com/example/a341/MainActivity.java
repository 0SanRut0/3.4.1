package com.example.a341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncRequest().execute();
    }
    class AsyncRequest extends AsyncTask<Void,Void,Void>{
        ImageView imgView;
        String url;
        InputStream is;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL u = new URL(url);
                is = (InputStream) u.getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bmp = BitmapFactory.decodeStream(is);
            return null;
        }

        @Override
        protected void onPreExecute() {
            imgView = findViewById(R.id.imageView);
            url = "https://www.1zoom.ru/big2/7/327430-Sepik.jpg";
            is = null;
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            imgView.setImageBitmap(bmp);
            super.onPostExecute(aVoid);
        }
    }
}