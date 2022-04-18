package com.example.burgervan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


import static com.example.burgervan.MainActivity.objects;
import static com.example.burgervan.MainActivity.receipt;
import static com.example.burgervan.MainActivity.total_val;

//import static com.example.burgervan.MainMenu.receipt;

public class ReceiptWindow extends AppCompatActivity {

    private double total_toPay;
    MainActivity mainActivity;
    ListView listView;
    Button back_btn, extra, finish;
    ImageView receipt_add, receipt_subtract;
    TextView itemName, itemQ, itemPrice, receipt_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_window);
        mainActivity= new MainActivity();
        listView = findViewById(R.id.receipt_window);
        receipt_total = findViewById(R.id.receipt_total);
        makeTotal();


        back_btn = findViewById(R.id.receipt_back_btn);
        back_btn.setOnClickListener(v -> {
            Intent intent  = new Intent(getApplicationContext(), MainMenu.class);
            startActivity(intent);
        });
        extra = findViewById(R.id.extra_btn);
        extra.setOnClickListener(v -> {
            Intent intent = new Intent (getApplicationContext(), addExtraMenu.class);
            startActivity(intent);
        });
        finish = findViewById(R.id.place_order_btn);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), OrderLocation.class);
                i.putExtra("total_to_pay", total_toPay);
                startActivity(i);
            }
        });
        CustomAdapter customAdapter = new CustomAdapter();

//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.receipt_row, receipt);
        listView.setAdapter(customAdapter);


    }

    private void makeTotal() {
        total_toPay = 0;
        if (objects != null) {
            for (int i = 0; i < objects.size(); i++) {
                total_toPay += objects.get(i).getPrice() * objects.get(i).getQ();
            }
            receipt_total.setText(Double.toString(total_toPay));
        }
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return objects.size();
        }

        @Override
        public Object getItem(int position) {
            return objects.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.receipt_row, null);

            itemName = view.findViewById(R.id.row_item_name);
            itemPrice = view.findViewById(R.id.row_item_price);
            itemQ = view.findViewById(R.id.row_item_quantity);
            receipt_add = view.findViewById(R.id.add_item);
            receipt_subtract = view.findViewById(R.id.subtract_item);

            System.out.println("we got: "+objects.get(position).getName()+" "+objects.get(position).getQ()+" "+ objects.get(position).getPrice());
            System.out.println("position"+position);
//            if (itemName!=null&&itemPrice!=null) {
                itemName.setText(objects.get(position).getName());
                itemPrice.setText(objects.get(position).getPrice().toString());
                itemQ.setText(objects.get(position).getQ().toString());
//            }

            receipt_add.setOnClickListener(v -> {
                objects.get(position).setQ(objects.get(position).getQ()+1);
                itemQ.setText(objects.get(position).getQ().toString());
                makeTotal();
            });

            receipt_subtract.setOnClickListener(v -> {
                if(objects.get(position).getQ()>0) {
                    objects.get(position).setQ(objects.get(position).getQ() - 1);
                    itemQ.setText(objects.get(position).getQ().toString());
                    makeTotal();
                }
            });

            return view;
        }
    }
}