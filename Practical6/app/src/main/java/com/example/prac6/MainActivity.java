package com.example.prac6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] name={"Name:Rinkesh","Name:Tanmay","Name:Raghav","Name:Abhishek","Name:Akash","Name:Krutarth","Name:Yash","Name:Rohit","Name:Priyam","Name:Harsh","Name:Kavish"};
        String[] add={"Address:Surat","Address:Maroli","Address:Navsari","Address:Surat","Address:Surat","Address:Billimora","Address:Surat","Address:Surat","Address:Navsari","Address:Navsari","Address:Navsari"};
        recyclerView.setAdapter(new RecyclerViewAdapter(name,add));
    }
}