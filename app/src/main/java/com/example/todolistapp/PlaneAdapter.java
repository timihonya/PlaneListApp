package com.example.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class PlaneAdapter extends ArrayAdapter<Plane> {
    public PlaneAdapter(Context context, List<Plane> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Plane plane = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.plane_lv, parent, false);
        }
    TextView model = (TextView) convertView.findViewById(R.id.planeModel);
    TextView speed_seats = (TextView) convertView.findViewById(R.id.speedSeats);
    TextView cost = (TextView) convertView.findViewById(R.id.costMoney);
    model.setText("Модель: " + plane.model);
    speed_seats.setText("Скорость и места: " +plane.speed_seats);
    cost.setText("Цена: " + plane.cost);
    return convertView;
    }
}
