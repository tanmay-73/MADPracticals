package com.example.practical8;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Output extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputdata);
        MyDbHandler db = new MyDbHandler(Output.this);
        Contact databse1 = new Contact();

        ListView list1 = findViewById(R.id.list1);

        ArrayList<String> list = new ArrayList<>();

        List<Contact> allContacts = db.getAllContacts();

        for(Contact contact: allContacts)
        {
            list.add(contact.getid()+")"+ " Name: " + contact.getName() + " Number: " + contact.getNum());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        list1.setAdapter(arrayAdapter);
    }
}
