package com.example.a20recycledview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Necesito una lista de cadenas(Tal vez deberia estar en una clase que modelase los Datos)
    List<String> nameList;
    //El elemento contender visual
    RecyclerView recyclerView;
    //Adaptador para cargar las cadenas en el recycler
    MiAdaptador miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PaisRepository paisRepository = new PaisRepository();
        nameList = paisRepository.obtenerListaPaises();

        //Instancio el recycler
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //Esto hace que el recyclerView sepa que los elementos van a tener un tamaño fijo uno debajo del otro
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        //Instancio el adaptador
        miAdaptador = new MiAdaptador(nameList);
        //Asigno el adaptador al recycler
        recyclerView.setAdapter(miAdaptador);
    }
}