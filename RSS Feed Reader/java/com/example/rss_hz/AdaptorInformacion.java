package com.example.rss_hz;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

class AdaptadorInformacion extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public int[] lista_imagenes = {
            R.drawable.rss,
            R.drawable.rss1,
            R.drawable.rss2,
            R.drawable.rss3
    };

    public String[] lista_titulos = {
            "¿En que consiste un lector RSS?",
            "¿Como funciona el lector RSS?",
            "¿Que proporciona esta aplicación?",
            "¿En que aspectos usa la aplicación las BBDD SQLite?"
    };

    public String[] lista_descriptiones = {
            "El lector RSS es una plataforma que te permite juntarlos en un mismo lugar y ver las actualizaciones de los blogs sin la necesidad de abrirlos uno por uno...." +
                    " Del inglés Really Simple Syndication o Rich Site Summary anteriormente, RSS es un fichero en formato XML que sirve para difundir información de" +
                    " manera automática." + "\n" + " Desplazate a la derecha para más información",
            "El lector RSS de esta aplicación funciona a partir de links que contengan xml, como por ejemplo : https://www.lne.es/rss/section/1600479/" +
                    "\n" + "La aplicacion transformara este codigo en elementos de un ListView y a partir del link que contiene el archivo xml, nos redireccionara a " +
                    "las diferentes fuentes relacionadas con los Links." + "\n" + " Desplazate a la derecha para más información",
            "Esta aplicación proporcionara fuentes predeterminadas elegidas por el usuario.  \n" + " " +
                    "Tambien permitira a los usuarios introducir sus propias fuentes, con una imagen que pueden seleccionar, el nombre que decidan y la descripcion de esta "
                    + "\n" + " Desplazate a la derecha para más informacíón",
            "La aplicación usa las BBDD SQLite para almacenar las RSS personalizadas del usuario y para el registro y login de cuentas. "
    };
    public int[] lista_colores = {
            Color.rgb(0, 0, 0),
            Color.rgb(0, 0, 0),
            Color.rgb(0, 0, 0),
            Color.rgb(0, 0, 0)
    };


    public AdaptadorInformacion(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista_titulos.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.info, container, false);
        LinearLayout layout =  view.findViewById(R.id.slidelinearlayout);
        ImageView img = view.findViewById(R.id.img);
        TextView titulo = view.findViewById(R.id.titulo);
        TextView descripcion = view.findViewById(R.id.descripcion);
        layout.setBackgroundColor(lista_colores[position]);
        img.setImageResource(lista_imagenes[position]);
        titulo.setText(lista_titulos[position]);
        descripcion.setText(lista_descriptiones[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}