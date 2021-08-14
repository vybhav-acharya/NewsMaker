package com.example.newsmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Starter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        setContentView(R.layout.activity_starter);
        EditText text=findViewById(R.id.details);
        Button button=findViewById(R.id.button);
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


    }
}