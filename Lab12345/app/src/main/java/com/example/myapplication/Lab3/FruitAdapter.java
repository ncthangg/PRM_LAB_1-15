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

public class FruitAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Fruit> traicayList;

    public FruitAdapter(Context context, int layout, List<Fruit> traicayList) {
        this.context = context;
        this.layout = layout;
        this.traicayList = traicayList;
    }

    @Override
    public int getCount() {
        return traicayList.size();
    }

    @Override
    public Object getItem(int position) {
        return traicayList.get(position); // Return the Fruit object at the given position
    }

    @Override
    public long getItemId(int position) {
        return position; // Return the position as the ID
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            // Initialize the ViewHolder
            holder = new ViewHolder();
            holder.textviewten = convertView.findViewById(R.id.txtName);
            holder.textviewmota = convertView.findViewById(R.id.txtDesciption);
            holder.imagehinh = convertView.findViewById(R.id.imgAvata);

            // Store the holder with the view
            convertView.setTag(holder);
        } else {
            // Reuse the existing holder
            holder = (ViewHolder) convertView.getTag();
        }

        // Assign data to views
        Fruit traicay = traicayList.get(position);
        holder.textviewten.setText(traicay.getTen());
        holder.textviewmota.setText(traicay.getMota());

        holder.imagehinh.setImageResource(traicay.getHinhUrl());

        return convertView;
    }

    // ViewHolder class to hold view references
    private static class ViewHolder {
        TextView textviewten;
        TextView textviewmota;
        ImageView imagehinh;
    }
}
