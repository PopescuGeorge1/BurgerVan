package com.example.burgervan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.burgervan.MainActivity.receipt;

public class addExtraMenu extends AppCompatActivity {

    String [] extraNames = {"garlic", "tomato", "barbeque", "fries", "mustard", "tzatziki"};
    int [] imgRes = {R.drawable.garlic_sauce, R.drawable.tomato_sauce, R.drawable.barbeque_sauce, R.drawable.french_fries, R.drawable.mustard_sauce, R.drawable.tzatziki_sauce};
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_extra_menu);

        gridView = findViewById(R.id.extra_menu_gridview);
        CustomGridAdapter customGridAdapter = new CustomGridAdapter();
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent12 = new Intent(getApplicationContext(), ReceiptWindow.class);
//            intent12.putExtra("menu_name", extraNames[position]);
            receipt.add("garlic");
            startActivity(intent12);

        });

    }

    private class CustomGridAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imgRes.length;
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
            View view1 = getLayoutInflater().inflate(R.layout.grid_item_menu, null);

            TextView textView = view1.findViewById(R.id.grid_image_name_menu);
            ImageView imageView = view1.findViewById(R.id.grid_image_menu);

            //Adjust image size to match current format
            imageView.setAdjustViewBounds(true);
            imageView.setMaxWidth(70);
            imageView.setMaxHeight(70);
            imageView.setBackground(null);

            textView.setText(extraNames[position]);
            imageView.setImageResource(imgRes[position]);

            return view1;
        }
    }
}