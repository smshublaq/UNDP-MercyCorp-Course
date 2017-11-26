package com.app.shareapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGo = findViewById(R.id.btn);
        img = findViewById(R.id.imageView);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TITLE,"ahmed");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Share App"));
                */


                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,200);

                /*
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW);
                goToGoogle.setData(Uri.parse("https://www.google.ps"));
                startActivity(goToGoogle);
                */
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 200 && resultCode == RESULT_OK){

            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap)bundle.get("data");

            img.setImageBitmap(bitmap);
        }


    }
}
