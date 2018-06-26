package com.adithyavijayakumar.popularmovies;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class CustomAdapter extends ArrayAdapter<MovieData> {
    Context context;


    CustomAdapter(Context c, List<MovieData> movieData){
        super(c,R.layout.activity_single_row,movieData);

        this.context = c;

    }


    public class ViewHolder {
        ImageView thumnail;

        TextView name;
        ViewHolder (View v){
            thumnail =(ImageView) v.findViewById(R.id.image_view);

            name =(TextView) v.findViewById(R.id.tv_title);
        }

    }
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieData movieData = getItem(position);
        View v = convertView;
        ViewHolder holder = null;
        if(v==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v =  inflater.inflate(R.layout.activity_single_row,parent,false);
            holder = new ViewHolder(v);
            v.setTag(holder);
            Log.d("ViewHolder", "Creating new grid items");

        }
        else
        {
            holder = (ViewHolder) v.getTag();
            Log.d("ViewHolder", "recycling existing grid items");
        }

        holder.thumnail.setImageResource(R.drawable.ic_launcher_background);


        holder.name.setText(movieData.getTitle());


        return v;

    }
}