package com.example.rss_hz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class ArrayListAdapter  extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> listaNombres;
    private ArrayList<String> listaDescripciones;
    private ArrayList<Integer> listaImagenes;
    private ArrayList<String> urls;

    public ArrayListAdapter(Context context,ArrayList<String> listaNombres, ArrayList<String> urls, ArrayList<String> listaDescripciones, ArrayList<Integer> listaImagenes) {
        super(context, R.layout.objeto, R.id.textView1, listaNombres);
        this.context = context;
        this.listaDescripciones = listaDescripciones;
        this.listaNombres = listaNombres;
        this.listaImagenes = listaImagenes;
        this.urls = urls;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View singleItem = convertView;
        ProgramViewHolder holder = null;
        if(singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.objeto, parent, false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else{
            holder = (ProgramViewHolder) singleItem.getTag();
        }
        holder.itemImage.setImageResource(listaImagenes.get(position));
        holder.itemTitulo.setText(listaNombres.get(position));
        holder.itemDescripcion.setText(listaDescripciones.get(position));
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Has clickado:"+ listaNombres.get(position), Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context.getApplicationContext(), RSS_Feed.class).putExtra("rssLink", urls.get(position)));

            }
        });
        return singleItem;
    }
}