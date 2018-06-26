package com.adithyavijayakumar.popularmovies;

import com.adithyavijayakumar.popularmovies.MovieData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adithya Vijayakumar on 6/26/2018.
 */

public class MovieParser {
    MovieData data;

    String response;

      MovieParser(String response){
          this.response = response ;
      }
        public void parse(String response){
          this.response= response;
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(response);
                String name = jsonObject.getString("backdrop_path");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        public String finParse(){
            return "lollah";
        }

}
