package com.rachana.Cosmei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Productdetails extends AppCompatActivity {
Button button2;
Button btnincre,btndecre;
TextView counterval;
int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);
        button2=(Button) findViewById(R.id.button2);
        btnincre=(Button)findViewById(R.id.btnincrement);
        btndecre=(Button)findViewById(R.id.btndecrement);
        counterval=(TextView)findViewById(R.id.counter);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Productdetails.this, "Your item has been added!", Toast.LENGTH_SHORT).show();
            }
        });

        btnincre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                counterval.setText(String.valueOf(count));
            }
        });
        btndecre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                counterval.setText(String.valueOf(count));
            }
        });

    }

}
