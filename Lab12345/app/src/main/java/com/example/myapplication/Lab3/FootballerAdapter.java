package com.example.myapplication.Lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class FootballerAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Footballer> footballerList;

    public FootballerAdapter(Context context, int layout, List<Footballer> footballerList) {
        this.context = context;
        this.layout = layout;
        this.footballerList = footballerList;
    }

    @Override
    public int getCount() {

        return footballerList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView textViewName =(TextView) view.findViewById(R.id.txtName);
        TextView textViewDescription =(TextView) view.findViewById(R.id.txtDesciption);
        ImageView imageAvatar=(ImageView) view.findViewById(R.id.imgAvata);
        ImageView imageFlag=(ImageView) view.findViewById(R.id.imgFlag);

        Footballer footballer = footballerList.get(i);
        textViewName.setText(footballer.getName());
        textViewDescription.setText(footballer.getDescription());
        imageAvatar.setImageResource(footballer.getAvatarUrl());
        imageFlag.setImageResource(footballer.getFlagUrl());

        return view;
    }
}
