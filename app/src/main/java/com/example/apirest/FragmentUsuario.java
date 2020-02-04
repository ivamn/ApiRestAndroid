package com.example.apirest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentUsuario extends Fragment {

    private EditText usuarioNick, usuarioNombre;
    private ProveedorServivios servicios;
    private static final String BASE_URL = "http://xusa.iesdoctorbalmis.info/usuarios/";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.layout_usuarios, container, false);
        Retrofit r = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        usuarioNick = v.findViewById(R.id.editTextNick);
        usuarioNombre = v.findViewById(R.id.editTextNombre);
        servicios = r.create(ProveedorServivios.class);
        v.findViewById(R.id.fab_usuario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUsuario();
            }
        });
        return v;
    }

    private void addUsuario(){
        Usuario s = new Usuario();
        s.setNombre(usuarioNombre.getText().toString());
        s.setNick(usuarioNick.getText().toString());
        servicios.insertarUsuario(s).enqueue(new Callback<RespuestaJson>() {
            @Override
            public void onResponse(Call<RespuestaJson> call, Response<RespuestaJson> response) {
                Toast.makeText(getContext(), "Insertado correctamente", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RespuestaJson> call, Throwable t) {
                Toast.makeText(getContext(), "No se ha podido insertar el usuario", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
