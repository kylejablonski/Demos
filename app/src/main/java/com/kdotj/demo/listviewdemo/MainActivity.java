/*
   Copyright 2017 Kyle Jablonski

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.kdotj.demo.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Sample Activity showing the usage of a ListView with an ArrayAdapter.
 * <br/>
 * This demo illustrates how an ArrayAdapter works with a custom Data type.
 * For simple data types such as String lists you can just supply the List of String and
 * these will display in each item.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.contact_row, ContactObject.getContactList()));

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
