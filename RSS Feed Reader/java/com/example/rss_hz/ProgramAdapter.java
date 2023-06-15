package com.example.rss_hz;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ProgramAdapter extends ArrayAdapter<String> {
    Context context;
    int[] imagenes;
    String[] nombre_RSS;
    String[] descripcion_RSS;
    String[] urls;


    public ProgramAdapter(Context context, String[] programName, int[] images, String[] programDescription, String[] urls) {
        super(context, R.layout.objeto, R.id.textView1, programName);
        this.context = context;
        this.imagenes = images;
        this.nombre_RSS = programName;
        this.descripcion_RSS = programDescription;
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
        holder.itemImage.setImageResource(imagenes[position]);
        holder.itemTitulo.setText(nombre_RSS[position]);
        holder.itemDescripcion.setText(descripcion_RSS[position]);
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Has clickado:"+ nombre_RSS[position], Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context.getApplicationContext(), RSS_Feed.class).putExtra("rssLink", urls[(position)]));
            }
        });
        return singleItem;
    }
}