package com.kdotj.demo.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Sample Activity showing the usage of a ListView with a custom View.
 * <br/>
 * This demo illustrates the use of a BaseAdapter with the ViewHolder pattern.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new DemoAdapter(this));

        /*
            Apply an AdapterView.OnItemClickListener to ListView to handle clicks in a ListView
            when no children are clickable
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactObject contactObject = (ContactObject) adapterView.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, String.format(Locale.getDefault(), "%s %s selected!", contactObject.firstName, contactObject.lastName), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
