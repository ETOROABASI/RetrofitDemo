package com.example.android.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter mAdapter;
    private List<Contact> contactList;
    private ApiInterface apiInterface;

    //THIS APP IS USING ContactsApp from my local wamp server to get it's data. Check this out
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recview_main);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);     //Check what this does and its importance to this app\



        //WE CREATE THE INTERFACE HERE USIMG THE RETROFIT WE BUILT.
        // THIS INTERFACE CRETAES THE RETROFIT OBJECT WE HAD BUILT IN THE ApiClient class (remember we stopped at .build, we didn't
        // add .create(), ass we add now
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        //THIS CALLS THE APPROPRIATE METHOD IN THE INTERFACE AND SAVES IT IN A CALL INSTANCE
        Call<List<Contact>> call  = apiInterface.getContacts();


        //THIS METHOD IS USED TO GET THE RESULT EITHER ON SUCCESSFUL CONNECTION(onResponse) or FAILURE(onFailure)
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                contactList = response.body();      //THIS POSTS THE RESULT OF THE CALL IN THE LIST VARIABLE CONTACT OF List instance
                mAdapter = new RecyclerAdapter(contactList);        //sets the adapter, its passes the contactList which is the body of the response to the Adapter
                                                                    //this response.body() points to our Contact class, hence the data there is filled up with the values from our API JSON array
                                                                    //the adapter uses it to bind data to each view. check out the variable, contact in the Adapter class
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });
    }
}
