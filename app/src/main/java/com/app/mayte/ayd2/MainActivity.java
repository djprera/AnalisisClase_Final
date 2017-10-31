package com.app.mayte.ayd2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Button button_s1;
    Button button_s2;
    Button button_s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_s1 =(Button) findViewById(R.id.button_s1);

        button_s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service1();
            }
        });

        button_s1 =(Button) findViewById(R.id.button_s2);

        button_s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service2();
            }
        });

        button_s1 =(Button) findViewById(R.id.button_s3);

        button_s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service3();
            }
        });

    }

    public void service1(){

        Intent intent = new Intent(getApplicationContext(), Servicio1Activity.class);
        startActivity(intent);

    }

    public void service2(){

        Intent intent = new Intent(getApplicationContext(), Servicio2Activity.class);
        startActivity(intent);

    }

    public void service3(){

        Intent intent = new Intent(getApplicationContext(), Servicio3Activity.class);
        startActivity(intent);

    }
}


