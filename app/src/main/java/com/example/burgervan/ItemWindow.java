package com.example.burgervan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.burgervan.MainMenu.addItem;
//import static com.example.burgervan.MainMenu.receipt;
//import static com.example.burgervan.ReceiptWindow.receipt;

public class ItemWindow extends AppCompatActivity {

    Button back_btn, buy_btn;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_window);

        Intent intent1 = getIntent();
        String return_target = intent1.getStringExtra("menu_name");

        back_btn = findViewById(R.id.item_window_back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                switch (return_target){
                    case "Burgers":
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

            }
        });

        buy_btn = findViewById(R.id.item_descr_confirm_btn);
        buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
//                addItem("x"); //nu merge
                intent.putExtra("buythis", "item");
                System.out.println("buy pressed");
                startActivity(intent);
            }
        });

        textView = findViewById(R.id.item_descr_tv);

        textView.setText(intent1.getStringExtra("item_name"));



    }
}