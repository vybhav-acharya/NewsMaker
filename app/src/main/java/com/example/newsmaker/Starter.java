package com.example.newsmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.newsmaker.database.MainRecentsActivity;

public class Starter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        setContentView(R.layout.activity_starter);
        EditText text=findViewById(R.id.details);
        Button button=findViewById(R.id.button);
        Button button2=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=text.getText().toString();
                if(name==null) {
                    name="bbc.com";

                }
                intent.putExtra("name", name);
                startActivity(intent);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(), MainRecentsActivity.class);
                startActivity(intent2);


            }
        });


    }


}