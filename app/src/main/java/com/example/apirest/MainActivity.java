package com.example.apirest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.botonUsuarios).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarFragmentUsuario();
            }
        });
        findViewById(R.id.botonMensajes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarFragmentMensajes();
            }
        });
    }

    private void mostrarFragmentUsuario(){
        getSupportFragmentManager().popBackStack();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new FragmentUsuario())
                .addToBackStack(null)
                .commit();
    }

    private void mostrarFragmentMensajes(){
        getSupportFragmentManager().popBackStack();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new FragmentMensaje())
                .addToBackStack(null)
                .commit();
    }

}
