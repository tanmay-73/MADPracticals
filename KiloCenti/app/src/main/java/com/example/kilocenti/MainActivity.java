package com.example.kilocenti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int meter,centimeter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1=findViewById(R.id.editTextTextPersonName);
        TextView t1 = findViewById(R.id.textView);
        TextView t2 = findViewById(R.id.textView2);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= e1.getText().toString();
                int finalValue=Integer.parseInt(value);
                meter=finalValue*1000;
                centimeter=meter*100;
                t1.setText("Value in meter is:"+meter);
                t2.setText("Value in centimeter is:"+centimeter);
            }
        });
    }
}
