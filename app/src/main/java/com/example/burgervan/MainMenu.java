package com.example.burgervan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.burgervan.MainActivity.quantity;
import static com.example.burgervan.MainActivity.receipt;

public class MainMenu extends AppCompatActivity {



    Button end_order;
    GridView gridView;
    String [] menuNames = {"Burger", "Menus", "Drinks"};
    int [] img = {R.drawable.burgers_menu_icon
            , R.drawable.menus_menu_icon, R.drawable.drinks_menu_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        gridView = findViewById(R.id.main_menu_gridview);


        Intent intent = getIntent();
        String buy_this = intent.getStringExtra("buythis");
        if(buy_this!=null) {
            receipt.add(buy_this);
            quantity.add(1);
        }

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent12 = new Intent(getApplicationContext(), SubMenu.class);
            intent12.putExtra("menu_name", menuNames[position]);
            startActivity(intent12);
        });

        end_order = findViewById(R.id.finish_btn);
        end_order.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(), ReceiptWindow.class);
            intent1.putStringArrayListExtra("order", receipt);
            intent1.putIntegerArrayListExtra("quantity", quantity);
            startActivity(intent1);

        });

    }

    public static void addItem(String x){
        receipt.add("ceva");
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return img.length;
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

            textView.setText(menuNames[position]);
            imageView.setImageResource(img[position]);

            return view1;
        }
    }
}