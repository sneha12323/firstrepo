package com.example.listviewvolley;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<HeroModel> {

    private final List<HeroModel>heroModelList;
    private final Context context;

    public ListViewAdapter(List<HeroModel>heroModelList,Context context){
        super(context,R.layout.list_items,heroModelList);
        this.heroModelList=heroModelList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        @SuppressLint("ViewHolder") View view= LayoutInflater.from(context).inflate(R.layout.list_items,parent,true);
         TextView textViewName= view.findViewById(R.id.textView2);
         TextView textViewImageurl=view.findViewById(R.id.textView3);
        textViewName.setText(heroModelList.get(position).getName());
        textViewImageurl.setText(heroModelList.get(position).getImageurl());

        return view;


    }
}
