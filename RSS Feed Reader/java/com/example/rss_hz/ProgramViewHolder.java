package com.example.rss_hz;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgramViewHolder {
    ImageView itemImage;
    TextView itemTitulo;
    TextView itemDescripcion;

    ProgramViewHolder(View v) {
        itemImage = v.findViewById(R.id.imageView);
        itemTitulo = v.findViewById(R.id.textView1);
        itemDescripcion = v.findViewById(R.id.textView2);
    }
}
