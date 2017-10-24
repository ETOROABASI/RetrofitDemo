package com.example.android.retrofitdemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ETORO on 21/10/2017.
 */

public class Contact {
    //we used @Serialized if the name of our variable doesn;t match that in our db. Here it actually matches,  but I am using it
    //incase of some other time where it doesn't match. The string inside the serializedName should be the exact name in your
    //db or API ie the JSON format
    @SerializedName("name")
    private String name;        //this will hold the data for name from our JSON array

    @SerializedName("email")
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
