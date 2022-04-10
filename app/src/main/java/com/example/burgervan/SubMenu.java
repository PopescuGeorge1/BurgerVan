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
    FoodBase foodBase;
    String pos;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);
        title = findViewById(R.id.sub_menu_title);
        Intent intent = getIntent();
        foodBase = new FoodBase();
        pos = intent.getStringExtra("menu_name");
        title.setText(pos);
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
                        intent.putExtra("item_name", foodBase.getBurgers_menu_names()[position]);
                        intent.putExtra("item_img", foodBase.getBurgers_menu_img()[position]);
                        intent.putExtra("item_price", foodBase.getBurgers_menu_price()[position]);

                        break;
                    case "Menus":
                        intent.putExtra("item_name", foodBase.getMenus_menu_names()[position]);
                        intent.putExtra("item_img", foodBase.getMenus_menu_img()[position]);
                        intent.putExtra("item_price", foodBase.getMenus_menu_price()[position]);
                        break;
                    case "Drinks":
                        intent.putExtra("item_name", foodBase.getDrinks_menu_names()[position]);
                        intent.putExtra("item_img", foodBase.getDrinks_menu_img()[position]);
                        intent.putExtra("item_price", foodBase.getDrinks_menu_price()[position]);

                        break;
                }

                startActivity(intent);

            }
        });

    }


    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return foodBase.getBurgers_menu_img().length;
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
                textView.setText(foodBase.getBurgers_menu_names()[position]);
                imageView.setImageResource(foodBase.getBurgers_menu_img()[position]);
            }
            if(pos.equals("Menus")){
                textView.setText(foodBase.getMenus_menu_names()[position]);
                imageView.setImageResource(foodBase.getMenus_menu_img()[position]);
            }
            if(pos.equals("Drinks")){
                textView.setText(foodBase.getDrinks_menu_names()[position]);
                imageView.setImageResource(foodBase.getDrinks_menu_img()[position]);
            }
            return view1;
        }
    }



}
