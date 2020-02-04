package com.example.apirest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProveedorServivios {

    @GET("usuarios")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<List<Usuario>> getUsuarios();

    @GET("mensajes")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<List<Mensaje>> getMensajes();


    @GET("usuarios/{id}")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<List<Usuario>> getUsuario(@Path("id") int _id);

    @POST("usuarios")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<RespuestaJson> insertarUsuario(@Body Usuario usuario);


    @POST("mensajes")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<RespuestaJson> insertarMensaje(@Body Mensaje mensaje);

}
