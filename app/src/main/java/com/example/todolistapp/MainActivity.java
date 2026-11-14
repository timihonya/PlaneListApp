package com.example.todolistapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Plane> tasks = new ArrayList<>();
    private PlaneAdapter adapter;
    private ListView listView;
    private Button button;
    private EditText editModel, editSpeedSeats, editCost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);
        editModel = findViewById(R.id.editModel);
        editSpeedSeats = findViewById(R.id.editSpeedSeats);
        editCost = findViewById(R.id.editCost);

        adapter = new PlaneAdapter(this, tasks);

        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String model = editModel.getText().toString().trim();
                String speed_seats = editSpeedSeats.getText().toString();
                String cost = editCost.getText().toString().trim();
                if (!model.isEmpty() && !speed_seats.isEmpty() && !cost.isEmpty()) {
                    tasks.add(new Plane(model, speed_seats, cost));
                    adapter.notifyDataSetChanged();

                    editModel.setText("");
                    editSpeedSeats.setText("");
                    editCost.setText("");
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                tasks.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Удалено", Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}