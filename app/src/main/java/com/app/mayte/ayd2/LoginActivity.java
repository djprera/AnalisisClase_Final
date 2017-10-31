package com.app.mayte.ayd2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usertextV;
    EditText contrasenia;
    Button login_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usertextV = (EditText) findViewById(R.id.editText_user);
        contrasenia= (EditText) findViewById(R.id.editText_contra);
        login_button =(Button) findViewById(R.id.button_login);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }


    public void Login(){
        String us= usertextV.getText().toString();
        String con = contrasenia.getText().toString();

        if (us.equals("analisis2") && con.equals("12345")){
            Toast.makeText(getApplication(), "Bienvenido", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }else{

            Toast.makeText(getApplication(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();

        }
    }
}
