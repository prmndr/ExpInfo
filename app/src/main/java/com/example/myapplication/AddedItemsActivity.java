package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AddedItemsActivity extends AppCompatActivity {

    String title,desc,time,date;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_items);

        title=getIntent().getStringExtra("EXTRA_TITLE");
        desc=getIntent().getStringExtra("EXTRA_DESC");
        time=getIntent().getStringExtra("EXTRA_TIME");
        date=getIntent().getStringExtra("EXTRA_DATE");
        recyclerView = findViewById(R.id.rvAddItems);

        Item item = new Item(title,desc,time,date);
        ArrayList<Item> list = new ArrayList<>();
        list.add(item);
        AddItemsAdapter adapter = new AddItemsAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();


    }
}