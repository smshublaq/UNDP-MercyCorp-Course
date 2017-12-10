package com.app.volleyexample;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Observable;

/**
 * Created by iSaleem on 12/7/17.
 */

public class VolleyRequests<T> extends Observable{

    interface IReceiveData<T>{
         void onDataReceived(T posts);
    }

    IReceiveData iReceiveData;

    public void getPosts(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(AppConstants.API_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                /*
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
                */
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Type type = new TypeToken<List<Post>>(){}.getType();
                List<Post> posts = gson.fromJson(response.toString(),type);

                setChanged();
                notifyObservers(posts);

                if(iReceiveData !=null){
                    iReceiveData.onDataReceived(posts);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MyApplication.getInstance().addToRequestQueue(jsonArrayRequest);
    }

    public void getContacts(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://api.androidhive.info/contacts/", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                ContactResponse contactResponse = gson.fromJson(response.toString(),ContactResponse.class);

                setChanged();
                notifyObservers(contactResponse);

                if(iReceiveData !=null){
                    iReceiveData.onDataReceived(contactResponse);
                }

                /*
                try {
                    JSONArray array = response.getJSONArray(AppConstants.CONTACTS_KEY);
                    for(int i=0;i<array.length();i++){

                      //JSONObject jsonObject =   array.getJSONObject(i);
                      //jsonObject.get

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                */
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    public void getTogobiImage(){
        ImageRequest imageRequest = new ImageRequest("https://pro-rankedboost.netdna-ssl.com/wp-content/uploads/2016/08/Togepi-Pokemon-Go.png", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                //img.setImageBitmap(response);
                setChanged();
                notifyObservers(response);

                if(iReceiveData !=null){
                    iReceiveData.onDataReceived(response);
                }
            }
        }, 500, 500, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(imageRequest);


    }

    public VolleyRequests setiReceiveData(IReceiveData iReceiveData) {
        this.iReceiveData = iReceiveData;
        return this;
    }
}
