package com.example.burgervan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.burgervan.MainActivity.receipt;

//import static com.example.burgervan.MainMenu.receipt;

public class ReceiptWindow extends AppCompatActivity {

    ListView listView;
    Button back_btn;
    TextView itemName, itemQ, itemP, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_window);

        listView = findViewById(R.id.receipt_window);


        back_btn = findViewById(R.id.receipt_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
            }
        });

        CustomAdapter customAdapter = new CustomAdapter();

//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.receipt_row, receipt);
        listView.setAdapter(customAdapter);
        System.out.println("onCreateReceipt");
        itemQ = findViewById(R.id.row_item_quantity);
        itemP = findViewById(R.id.row_item_price);
        total = findViewById(R.id.receipt_total);

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return receipt.size();
        }

        @Override
        public Object getItem(int position) {
            return receipt.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.receipt_row, null);
            itemName = findViewById(R.id.row_item_name);
            String s = receipt.get(position);
            if (itemName!=null)
                itemName.setText(s);

            return view;
        }
    }
}