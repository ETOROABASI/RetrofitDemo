package com.example.android.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by ETORO on 21/10/2017.
 */


//THIS IS AN INTERFACE FOR OUR Retrofit where we define the method for our API calls

//THE METHOD RETURNS AN INSTANCE OF Call class
public interface ApiInterface {

    //WE USE THE POST ANNOTATION
    @POST("readContacts.php")               //this specifies the endpoint of the base url. where the actual code is
    Call<List<Contact>>  getContacts();


}
