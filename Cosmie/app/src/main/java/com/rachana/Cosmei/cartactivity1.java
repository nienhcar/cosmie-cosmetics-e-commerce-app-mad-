package com.rachana.Cosmei;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class cartactivity1 extends AppCompatActivity {
    private static final String TAG = "ListDataActivity";
    DBhelper DB;
    ListView lv;
    EditText username1;
    String product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartactivity1);
        lv=(ListView)findViewById(R.id.listView);
        DB=new DBhelper(this);
        username1=(EditText)findViewById(R.id.username1) ;
        populateListview();

    }

    private void populateListview() {
        Log.d(TAG,"populateListView: Displaying data in the ListView.");
        Cursor data = DB.getData();
        ArrayList<String> listdata=new ArrayList<>();
        while (data.moveToNext()){
            listdata.add(data.getString(0));
        }
        ListAdapter adapter=new ArrayAdapter< >(this, android.R.layout.simple_list_item_1,listdata);
        lv.setAdapter(adapter);
    }
}