package com.app.volleyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        final TextView tvJSON = findViewById(R.id.tvJSON);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(AppConstants.API_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject =  response.getJSONObject(i);
                        int userId = jsonObject.getInt(AppConstants.USER_ID);
                        int id = jsonObject.getInt(AppConstants.ID);
                        String title = jsonObject.getString(AppConstants.TITLE);
                        String body = jsonObject.getString(AppConstants.BODY);
                        Post post = new Post(body,title,userId,id);

                        tvJSON.append(post.getUserId()+"");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //response.getJSONArray()
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue.add(jsonObjectRequest);

    }
}
