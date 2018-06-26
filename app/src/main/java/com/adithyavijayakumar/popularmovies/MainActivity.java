package com.adithyavijayakumar.popularmovies;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adithyavijayakumar.popularmovies.Network.SampleToast;
import com.adithyavijayakumar.popularmovies.Network.VolleySingleton;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.adithyavijayakumar.popularmovies.MovieKeys.KeyData;

import static com.adithyavijayakumar.popularmovies.MovieKeys.KeyData.KEY_RESULTS;
import static com.adithyavijayakumar.popularmovies.MovieKeys.KeyData.KEY_TITLE;

public class MainActivity extends AppCompatActivity {
    GridView l;
    VolleySingleton volleySingleton;
    ImageLoader imageLoader;
    RequestQueue requestQueue;
  public ArrayList<MovieData> movieData= new ArrayList<MovieData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (GridView) findViewById(R.id.movie_grid);
        CustomAdapter adapter = new CustomAdapter(this, movieData);
        l.setAdapter(adapter);
       volleySingleton = VolleySingleton.getsInstance();
       requestQueue = volleySingleton.getRequestQueue();
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, "https://api.themoviedb.org/3/movie/popular?api_key=55e33df4641b27871b1b39841b5c3d0e", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJsonResponse(response);
            }
        } , new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(request);
    }
    public void parseJsonResponse(JSONObject response){
        if(response == null||response.length()==0)
            {
            return;
            }
        StringBuilder data = new StringBuilder();
        try {

            JSONArray arrayMovies = response.getJSONArray(KEY_RESULTS);
            for (int i = 0;i<arrayMovies.length(); i++){
                JSONObject currentMovie = arrayMovies.getJSONObject(i);
                String title = currentMovie.getString(KEY_TITLE);
                data.append(title+"\n");
                MovieData detail = new MovieData(title);
                movieData.add(detail);


            }

            SampleToast.customToast(this,data.toString());
            Log.d("Movie List",data.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_menu, menu);
        return true;
    }

}
