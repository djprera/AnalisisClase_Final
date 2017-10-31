package com.app.mayte.ayd2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.app.mayte.ayd2.PunteoProducto.PuntuacionApi;
import com.app.mayte.ayd2.PunteoProducto.PuntuacionProducto;
import com.app.mayte.ayd2.PunteoProducto.RespuestaPuntuacion;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Servicio3Activity extends AppCompatActivity {

    Spinner punteoSpinner;
    EditText codigoProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio3);
        codigoProducto = (EditText) findViewById(R.id.codigoText);
        punteoSpinner = (Spinner) findViewById(R.id.punteoSpinner);
        setValoresSpinner();
        addEvents();

    }

    private void setValoresSpinner(){

        ArrayList<Integer> punteos = new ArrayList<>();

        for(int i = 0; i <= 10; i++){
            punteos.add(i);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getApplicationContext(),
                android.R.layout.simple_spinner_item, punteos);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        punteoSpinner.setAdapter(adapter);

    }

    private void puntearProducto(){

        int codigo = Integer.parseInt(codigoProducto.getText().toString());
        int punteo = punteoSpinner.getSelectedItemPosition();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://laboratoriovirtual.net:8000").build();

        PuntuacionApi apiService = retrofit.create(PuntuacionApi.class);

        PuntuacionProducto punt = new PuntuacionProducto(codigo,punteo);

        String src = String.format("{\"codigo\":%d, \"puntuacion\":%d}",codigo,punteo);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), src);
        Call<ResponseBody> respuesta = apiService.postPuntuacion(body);


        respuesta.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                JSONObject json = null;

                try {
                   String res  = response.body().string();
                   json = new JSONObject(res);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                if (response.isSuccessful()) {

                    if(json != null){

                        int res = -1;

                        try {
                            res = (int) json.get("resultado");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        String respuesta = "Producto puntuado";

                        if(res == 1){
                            respuesta = "No existe el producto";
                        }

                        else if(res == -1){
                            respuesta = "Error";
                        }

                        Toast.makeText(Servicio3Activity.this, respuesta, Toast.LENGTH_SHORT).show();

                    }

                } else
                    Toast.makeText(Servicio3Activity.this, "Servidor caido", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Servicio3Activity.this, "Revisar conexión de internet", Toast.LENGTH_SHORT).show();
            }

        });

    }


    private void addEvents(){

        (findViewById(R.id.puntearBoton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puntearProducto();
            }
        });

    }
}
