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

public class SubMenu extends AppCompatActivity {

    Button sub_menu_back_btn;
    //probably i'll have to move these in the main activity in order to have them all together
    GridView gridView;
    String [] burgers_menu_names = {"Normal burger", "Healthy burger", "Deluxe burger"};
    int [] burgers_menu_img = {R.drawable.hamburger_simple, R.drawable.hamburger_healthy, R.drawable.hamburger_premium};
    double []burgers_menu_price = {1.5, 2.5, 4};
    String [] menus_menu_names = {"DoubleTrouble", "Happy Belly", "King"};
    int [] menus_menu_img = {R.drawable.doubletrouble_menu, R.drawable.happybelly_menu, R.drawable.king_menu};
    double []menus_menu_price = {4, 5.5, 8};
    String [] drinks_menu_names = {"Coca-Cola", "7Up", "Water"};
    int [] drinks_menu_img = {R.drawable.drink_menu_cola, R.drawable.drink_menu_7up, R.drawable.drink_menu_water};
    double []drinks_menu_price = {0.75, 0.75, 1.25};
    String pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);

        Intent intent = getIntent();

        pos = intent.getStringExtra("menu_name");
        System.out.println(pos);

        //-----BACK BUTTON
        sub_menu_back_btn = findViewById(R.id.sub_menu_back_btn);
        sub_menu_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent1);
            }
        });



        //-----------
        gridView = findViewById(R.id.main_submenu_gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ItemWindow.class);
                intent.putExtra("menu_name", pos);
                switch (pos) {
                    case "Burger":
                        intent.putExtra("item_name", burgers_menu_names[position]);
                        intent.putExtra("item_img", burgers_menu_img[position]);
                        intent.putExtra("item_price", burgers_menu_price[position]);

                        break;
                    case "Menus":
                        intent.putExtra("item_name", menus_menu_names[position]);
                        intent.putExtra("item_img", menus_menu_img[position]);
                        intent.putExtra("item_price", menus_menu_price[position]);
                        break;
                    case "Drinks":
                        intent.putExtra("item_name", drinks_menu_names[position]);
                        intent.putExtra("item_img", drinks_menu_img[position]);
                        intent.putExtra("item_price", drinks_menu_price[position]);

                        break;
                }

                startActivity(intent);

            }
        });

    }


    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return burgers_menu_img.length;
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
            if(pos.equals("Burger")) {
                textView.setText(burgers_menu_names[position]);
                imageView.setImageResource(burgers_menu_img[position]);
            }
            if(pos.equals("Menus")){
                textView.setText(menus_menu_names[position]);
                imageView.setImageResource(menus_menu_img[position]);
            }
            if(pos.equals("Drinks")){
                textView.setText(drinks_menu_names[position]);
                imageView.setImageResource(drinks_menu_img[position]);
            }
            return view1;
        }
    }
}
