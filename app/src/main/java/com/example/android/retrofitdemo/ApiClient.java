package com.example.android.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ETORO on 21/10/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "http://10.0.2.2/ContactsApp/";   //this reps our base url. Android virtual devices
                                                                            //uses 10.0.2.2 to connect to localhost, hence we use it

    public static Retrofit retrofit  =null;      //declare an instance of Retrofit

    // A method that returns an instance of retrofit which actually carries our connection to the json array
    public static Retrofit getApiClient(){
        // if retrofit is not already initialized, initialize it
        if(retrofit == null){
            //This builds our conection to the api or db
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;

    }



}
