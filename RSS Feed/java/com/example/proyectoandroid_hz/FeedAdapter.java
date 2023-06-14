package com.example.proyectoandroid_hz;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class FeedAdapter extends CursorAdapter {

    /*
    Etiqueta de Depuración
     */
    private static final String TAG = FeedAdapter.class.getSimpleName();

    /**
     * View holder para evitar multiples llamadas de findViewById()
     */
    static class ViewHolder {
        TextView titulo;
        TextView descripcion;
        NetworkImageView imagen;

        int tituloI;
        int descripcionI;
        int imagenI;
    }

    public FeedAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);

    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.layout, null, false);

        ViewHolder vh = new ViewHolder();

        // Almacenar referencias
        vh.titulo = (TextView) view.findViewById(R.id.titulo);
        vh.descripcion = (TextView) view.findViewById(R.id.descripcion);
        vh.imagen = (NetworkImageView) view.findViewById(R.id.imagen);

        // Setear indices
        vh.tituloI = cursor.getColumnIndex(BBDD.ColumnEntradas.TITULO);
        vh.descripcionI = cursor.getColumnIndex(BBDD.ColumnEntradas.DESCRIPCION);
        vh.imagenI = cursor.getColumnIndex(BBDD.ColumnEntradas.URL_MINIATURA);

        view.setTag(vh);

        return view;
    }

    public void bindView(View view, Context context, Cursor cursor) {

        final ViewHolder vh = (ViewHolder) view.getTag();

        // Setear el texto al titulo
        vh.titulo.setText(cursor.getString(vh.tituloI));

        // Obtener acceso a la descripción y su longitud
        int ln = cursor.getString(vh.descripcionI).length();
        String descripcion = cursor.getString(vh.descripcionI);

        // Acortar descripción a 77 caracteres
        if (ln >= 150)
            vh.descripcion.setText(descripcion.substring(0, 150) + "...");
        else vh.descripcion.setText(descripcion);

        // Obtener URL de la imagen
        String thumbnailUrl = cursor.getString(vh.imagenI);

        // Obtener instancia del ImageLoader
        ImageLoader imageLoader = VolleySingleton.getInstance(context).getImageLoader();

        // Volcar datos en el image view
        vh.imagen.setImageUrl(thumbnailUrl, imageLoader);

    }
}