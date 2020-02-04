package com.example.apirest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentMensaje extends Fragment {

    private static final String BASE_URL = "http://xusa.iesdoctorbalmis.info/usuarios/";

    private List<Usuario> usuarios;
    private ProveedorServivios api;
    private Spinner spinner;
    private EditText editTextMensaje;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.layout_mensajes, container,false);
        spinner = v.findViewById(R.id.spinner);
        editTextMensaje = v.findViewById(R.id.editTextMensaje);
        Retrofit r =new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        api = r.create(ProveedorServivios.class);
        cargarUsuarios();
        v.findViewById(R.id.fab_mensaje).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMensaje();
            }
        });
        return v;
    }

    private void cargarUsuarios(){
        api.getUsuarios().enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                usuarios = response.body();
                populateSpinner();
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void enviarMensaje(){
        Mensaje m = new Mensaje();
        m.setNick((String)spinner.getSelectedItem());
        m.setMensaje(editTextMensaje.getText().toString());
        api.insertarMensaje(m).enqueue(new Callback<RespuestaJson>() {
            @Override
            public void onResponse(Call<RespuestaJson> call, Response<RespuestaJson> response) {
                Toast.makeText(getContext(), "Se ha enviado el mensaje", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RespuestaJson> call, Throwable t) {
                Toast.makeText(getContext(), "No se ha podido enviar el mensaje", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateSpinner(){
        ArrayList<String> array = new ArrayList<>();
        for (Usuario u : usuarios) {
            array.add(u.getNick());
        }
        spinner.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, array));
    }
}
