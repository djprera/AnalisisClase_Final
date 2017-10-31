package com.app.mayte.ayd2.PunteoProducto;


import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Diego Prera on 10/30/2017.
 */

public interface PuntuacionApi {

    @POST("api/producto/puntuar")
    Call<ResponseBody> postPuntuacion(@Body RequestBody body);


}
