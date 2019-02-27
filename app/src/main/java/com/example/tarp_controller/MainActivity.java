package com.example.tarp_controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(getApplicationContext());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference drill_depth = database.getReference("Drill_Depth");
        final DatabaseReference Num_loc = database.getReference("Num_Loc");
        final DatabaseReference spacing = database.getReference("spacing");

        final TextView drill_depth_view = findViewById(R.id.drill);
        final TextView Num_loc_view = findViewById(R.id.num);
        final TextView spacing_view =findViewById(R.id.spacing);


        Button ok_btn = findViewById(R.id.ok_btn);
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drill_depth.setValue(drill_depth_view.getText().toString());
                Num_loc.setValue(Num_loc_view.getText().toString());
                spacing.setValue(spacing_view.getText().toString());
                Toast.makeText(getApplicationContext(), "Application Loaded", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
