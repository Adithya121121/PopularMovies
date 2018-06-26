package com.adithyavijayakumar.popularmovies.Network;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Adithya Vijayakumar on 6/26/2018.
 */

public class SampleToast {
    public static void customToast(Context c,String message){
        Toast.makeText(c,message + " ",Toast.LENGTH_LONG).show();
    }
}
