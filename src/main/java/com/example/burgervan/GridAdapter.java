package com.example.burgervan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    Context context;
    String [] name;
    int []img;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] name, int[] img) {
        this.context = context;
        this.name = name;
        this.img = img;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater==null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.grid_item_menu, null);

        ImageView imageView = convertView.findViewById(R.id.grid_image_menu);
        TextView textView = convertView.findViewById(R.id.grid_image_name_menu);

        imageView.setImageResource(img[position]);
        textView.setText(img[position]);

        return convertView;
    }
}
