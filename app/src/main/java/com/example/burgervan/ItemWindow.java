package com.example.burgervan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.burgervan.MainMenu.addItem;
//import static com.example.burgervan.MainMenu.receipt;
//import static com.example.burgervan.ReceiptWindow.receipt;

public class ItemWindow extends AppCompatActivity {

    Button back_btn, buy_btn;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_window);

        Intent intent1 = getIntent();
        String return_target = intent1.getStringExtra("menu_name");


        String item_name = intent1.getStringExtra("item_name");
        System.out.println("item window: "+item_name);
        //--------------------------
        back_btn = findViewById(R.id.item_window_back_btn);
        back_btn.setOnClickListener(v -> {
            Intent intent = new Intent();
            switch (return_target){

                case "Burger":
                    intent = new Intent(getApplicationContext(), SubMenu.class);
                    intent.putExtra("menu_name", "Burger");

                    break;
                case "Menus":
                    intent = new Intent(getApplicationContext(), SubMenu.class);
                    intent.putExtra("menu_name", "Menus");

                    break;
                case "Drinks":
                    intent = new Intent(getApplicationContext(), SubMenu.class);
                    intent.putExtra("menu_name", "Drinks");
                    break;
            }
            startActivity(intent);
        });
        //---------------------------

        buy_btn = findViewById(R.id.item_descr_confirm_btn);
        buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);

                intent.putExtra("buythis", item_name);
                System.out.println("buy pressed");
                startActivity(intent);
            }
        });
        imageView = findViewById(R.id.item_window_img);
        imageView.setImageResource(intent1.getIntExtra("item_img", 0));
        textView = findViewById(R.id.item_descr_tv);
        textView.setText(intent1.getStringExtra("item_name"));

//        imageView = findViewById(R.id.item_window_img);
//        imageView.setImageResource(intent1.getIntExtra("item_img", 0));

    }
}