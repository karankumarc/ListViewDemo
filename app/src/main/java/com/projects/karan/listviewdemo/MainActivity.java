package com.projects.karan.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Declaration -- Visible component
    private ListView listViewDaysOfWeek;

    //Declaration and initilization -- Invisible component
    ArrayAdapter<String> arrayAdapterDaysOfWeek;
    String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    ArrayList<String> arrayListDaysOfWeek = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialization
        listViewDaysOfWeek = (ListView) findViewById(R.id.listViewDaysOfWeek);

        //region Building Array List
        // Building array list
        arrayListDaysOfWeek.add(daysOfWeek[0]);
        arrayListDaysOfWeek.add(daysOfWeek[1]);
        arrayListDaysOfWeek.add(daysOfWeek[2]);
        arrayListDaysOfWeek.add(daysOfWeek[3]);
        arrayListDaysOfWeek.add(daysOfWeek[4]);
        arrayListDaysOfWeek.add(daysOfWeek[5]);
        arrayListDaysOfWeek.add(daysOfWeek[6]);
        //endregion

        // Initializing adapter and attaching data source and row xml to the adapter
        arrayAdapterDaysOfWeek = new ArrayAdapter<String>(this,
                R.layout.row, arrayListDaysOfWeek);

        // Attaching the adapter to the listview (destination)
        listViewDaysOfWeek.setAdapter(arrayAdapterDaysOfWeek);

        listViewDaysOfWeek.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayListDaysOfWeek.remove(i);
                arrayAdapterDaysOfWeek.notifyDataSetChanged();
            }
        });
    }
}
