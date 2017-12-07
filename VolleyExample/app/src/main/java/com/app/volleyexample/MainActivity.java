package com.app.volleyexample;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer{

    private ImageView img;
    private TextView tvJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         img = findViewById(R.id.img);
        tvJSON = findViewById(R.id.tvJSON);


        //volleyRequests.addObserver(this);


        new VolleyRequests().setiReceiveData(new VolleyRequests.IReceiveData() {
            @Override
            public void onDataReceived(Object posts) {
                tvJSON.setText(((List<Post>)posts).get(0).getBody());

            }


        }).getPosts();


        new VolleyRequests().setiReceiveData(new VolleyRequests.IReceiveData() {
            @Override
            public void onDataReceived(Object posts) {
                //tvJSON.setText(((List<Post>)posts).get(0).getBody());
                img.setImageBitmap((Bitmap)posts);
            }


        }).getTogobiImage();


        new VolleyRequests().setiReceiveData(new VolleyRequests.IReceiveData() {
            @Override
            public void onDataReceived(Object posts) {
                //tvJSON.setText(((List<Post>)posts).get(0).getBody());
                tvJSON.setText(((ContactResponse)posts).getContacts().get(0).getEmail());
            }


        }).getContacts();

        //volleyRequests.getPosts();




        //requestQueue.add(jsonObjectRequest);
        //requestQueue.add(jsonArrayRequest);
        //requestQueue.add(imageRequest);
        //MyApplication.getInstance().addToRequestQueue(jsonArrayRequest);
        //MyApplication.getInstance().addToRequestQueue(imageRequest);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(o instanceof Bitmap){
            img.setImageBitmap((Bitmap)o);
        }
        else if (o instanceof ContactResponse){
            ContactResponse contactResponse = (ContactResponse)o;

            tvJSON.setText(contactResponse.getContacts().get(0).getEmail());
        }
        else if(o instanceof List){
            List<Post> posts = (List<Post>)o;
            tvJSON.setText(posts.get(0).getBody());
        }
    }


}
