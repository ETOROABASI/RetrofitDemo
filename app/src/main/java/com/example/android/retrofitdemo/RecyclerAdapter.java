package com.example.android.retrofitdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ETORO on 21/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {

    private List<Contact> contact;

    public RecyclerAdapter(List<Contact> contact){
        this.contact = contact;
    }


    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {


        holder.name.setText(contact.get(position).getName());  //sets the name textview to the value of the data in our api
        holder.email.setText(contact.get(position).getEmail());  //same for email


    }

    @Override
    public int getItemCount() {
        return contact.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView name, email;

        public myViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.text_list_name);
            email = (TextView) itemView.findViewById(R.id.text_list_email);

        }

    }
}


