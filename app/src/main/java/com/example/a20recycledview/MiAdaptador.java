package com.example.a20recycledview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {

    //Atributo la lista a partir de la cual pueblo los elementos del recycler
    private List<String> nameList;

    //Constructor
    public MiAdaptador(List<String> list) {
        nameList = list;
    }

    //Metodo a sobrescribir
    @NonNull
    @Override
    public MiAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.elementito, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //Enlazo el ArrayList de String con el recycler
    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.ViewHolder holder, int position) {
        final String name = nameList.get(position);
        //Setea el texto del textview en el interior del elementito.xml
        holder.textView.setText(name);
        //Necesito dotar a este elemento enlazado de un evento click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Elimino el elemento de la posicion "position"
                eliminarElemento(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        if (nameList == null) {
            return 0;
        } else {
            return nameList.size();
        }
    }

    //Metodo para eliminar elementos visuales de la lista
    public void eliminarElemento(int position) {
        nameList.remove(position);
        //Falla la actualizacion de lista usemos mejor norifiDataSetChanged()
        //Funciona la retirada visual del elemento
        notifyItemRemoved(position);
    }

    //Metodo para anadir un elemento visual a la lista
    public void anadirElemento(String name) {
        nameList.add(name);
        notifyItemInserted(nameList.size()-1);
    }


    //Tengo que crear una INNER CLASS para manipular el soporte visual (ViewHolder)
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Asigno las ID de la vista elementito.xml
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
