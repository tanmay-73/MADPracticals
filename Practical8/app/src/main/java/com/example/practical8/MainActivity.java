package com.example.practical8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDbHandler db = new MyDbHandler(MainActivity.this);
        Contact databse1 = new Contact();
        EditText name=findViewById(R.id.name);
        EditText number=findViewById(R.id.number);
        Button submit=findViewById(R.id.submit);
        Button output=findViewById(R.id.output);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                   String x=name.getText().toString();
                   String y=number.getText().toString();
                if (x.isEmpty() || y.isEmpty()) {
                    Toast t=Toast.makeText(getApplicationContext(),"Please Enter Username or Password",Toast.LENGTH_SHORT);
                    t.show();
                } else {
                    databse1.setName(x);
                    databse1.setNum(y);
                    db.addContact(databse1);
                }
            }
        });
        output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Output.class);
                startActivity(i);
            }
        });
    }
}