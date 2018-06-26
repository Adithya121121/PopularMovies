package com.adithyavijayakumar.popularmovies;

/**
 * Created by Adithya Vijayakumar on 6/25/2018.
 */

    public class MovieData {

        public String title;
    public int posterPath;


    MovieData(String title){
        this.title = title;
    }
    public int getPosterPath() {
        return posterPath;
    }
    public int setPosterPath(int posterPath) {
        this.posterPath = posterPath;
        return (posterPath);
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }


    }

