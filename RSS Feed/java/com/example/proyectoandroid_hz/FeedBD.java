package com.example.proyectoandroid_hz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;
import java.util.List;

public class FeedBD extends SQLiteOpenHelper {


    private static final int COLUMN_ID = 0;
    private static final int COLUMN_TITULO = 1;
    private static final int COLUMN_DESC = 2;
    private static final int COLUMN_URL = 3;

    private static FeedBD singleton;

    private static final String TAG = FeedBD.class.getSimpleName();

    public static final String DATABASE_NAME = "Feed.db";

    public static final int DATABASE_VERSION = 1;

    private FeedBD(Context context) {
        super(context,
                DATABASE_NAME,
                null,
                DATABASE_VERSION);

    }
    public static synchronized FeedBD getInstance(Context context) {
        if (singleton == null) {
            singleton = new FeedBD(context.getApplicationContext());
        }
        return singleton;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla 'entrada'
        db.execSQL(BBDD.CREAR_ENTRADA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Añade los cambios que se realizarán en el esquema
        db.execSQL("DROP TABLE IF EXISTS " + BBDD.ENTRADA_TABLE_NAME);
        onCreate(db);
    }
    public Cursor obtenerEntradas() {
        // Seleccionamos todas las filas de la tabla 'entrada'
        return getWritableDatabase().rawQuery(
                "select * from " + BBDD.ENTRADA_TABLE_NAME, null);
    }
    public void insertarEntrada(
            String titulo,
            String descripcion,
            String url,
            String thumb_url) {

        ContentValues values = new ContentValues();
        values.put(BBDD.ColumnEntradas.TITULO, titulo);
        values.put(BBDD.ColumnEntradas.DESCRIPCION, descripcion);
        values.put(BBDD.ColumnEntradas.URL, url);
        values.put(BBDD.ColumnEntradas.URL_MINIATURA, thumb_url);

        // Insertando el registro en la base de datos
        getWritableDatabase().insert(
                BBDD.ENTRADA_TABLE_NAME,
                null,
                values
        );
    }
    public void actualizarEntrada(int id,
                                  String titulo,
                                  String descripcion,
                                  String url,
                                  String thumb_url) {

        ContentValues values = new ContentValues();
        values.put(BBDD.ColumnEntradas.TITULO, titulo);
        values.put(BBDD.ColumnEntradas.DESCRIPCION, descripcion);
        values.put(BBDD.ColumnEntradas.URL, url);
        values.put(BBDD.ColumnEntradas.URL_MINIATURA, thumb_url);

        // Modificar entrada
        getWritableDatabase().update(
                BBDD.ENTRADA_TABLE_NAME,
                values,
                BBDD.ColumnEntradas.ID + "=?",
                new String[]{String.valueOf(id)});

    }
    public void sincronizarEntradas(List<Item> entries) {
        /*
        #1  Mapear temporalemente las entradas nuevas para realizar una
            comparación con las locales
        */
        HashMap<String, Item> entryMap = new HashMap<String, Item>();
        for (Item e : entries) {
            entryMap.put(e.getTitle(), e);
        }

        /*
        #2  Obtener las entradas locales
         */
        Log.i(TAG, "Consultar items actualmente almacenados");
        Cursor c = obtenerEntradas();
        assert c != null;
        Log.i(TAG, "Se encontraron " + c.getCount() + " entradas, computando...");

        /*
        #3  Comenzar a comparar las entradas
         */
        int id;
        String titulo;
        String descripcion;
        String url;

        while (c.moveToNext()) {

            id = c.getInt(COLUMN_ID);
            titulo = c.getString(COLUMN_TITULO);
            descripcion = c.getString(COLUMN_DESC);
            url = c.getString(COLUMN_URL);

            Item match = entryMap.get(titulo);
            if (match != null) {
                // Filtrar entradas existentes. Remover para prevenir futura inserción
                entryMap.remove(titulo);

                /*
                #3.1 Comprobar si la entrada necesita ser actualizada
                */
                if ((match.getTitle() != null && !match.getTitle().equals(titulo)) ||
                        (match.getDescripcion() != null && !match.getDescripcion().equals(descripcion)) ||
                        (match.getLink() != null && !match.getLink().equals(url))) {
                    // Actualizar entradas
                    actualizarEntrada(
                            id,
                            match.getTitle(),
                            match.getDescripcion(),
                            match.getLink(),
                            match.getContent().getUrl()
                    );

                }
            }
        }
        c.close();

        /*
        #4 Añadir entradas nuevas
        */
        for (Item e : entryMap.values()) {
            Log.i(TAG, "Insertado: titulo=" + e.getTitle());
            insertarEntrada(
                    e.getTitle(),
                    e.getDescripcion(),
                    e.getLink(),
                    e.getContent().getUrl()
            );
        }
        Log.i(TAG, "Se actualizaron los registros");


    }

}
