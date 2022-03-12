package com.example.burgervan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.burgervan.MainActivity.receipt;
import static com.example.burgervan.MainActivity.price;
import static com.example.burgervan.MainActivity.total_val;
import static com.example.burgervan.MainActivity.objects;

public class MainMenu extends AppCompatActivity {


    TextView total;
    Button end_order;
    GridView gridView;
    ListView listView;
    String [] menuNames = new String[]{"Burger", "Menus", "Drinks"};
    int [] imgRes = {R.drawable.burgers_menu_icon
            , R.drawable.menus_menu_icon, R.drawable.drinks_menu_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        total = findViewById(R.id.total_value);
        addToOrder();

        //set gridview
        gridView = findViewById(R.id.main_menu_gridview);
        CustomGridAdapter customGridAdapter = new CustomGridAdapter();
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent12 = new Intent(getApplicationContext(), SubMenu.class);
            intent12.putExtra("menu_name", menuNames[position]);
            startActivity(intent12);
        });

        //set listview
        listView = findViewById(R.id.main_menu_listview);
        MyAdapter myAdapter = null;
        if(!objects.isEmpty()) {
            System.out.println("main used");
            myAdapter = new MyAdapter(this);

        }
        listView.setAdapter(myAdapter);

        // go to receipt window button
        end_order = findViewById(R.id.finish_btn);
        end_order.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(), ReceiptWindow.class);
            intent1.putStringArrayListExtra("order", receipt);
//            intent1.putIntegerArrayListExtra("quantity", quantity);
            startActivity(intent1);

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

            textView.setText(menuNames[position]);
            imageView.setImageResource(imgRes[position]);

            return view1;
        }
    }

    private void addToOrder(){

        Intent intent = getIntent();
        String buy_this = intent.getStringExtra("buythis");
        double price_this = intent.getDoubleExtra("item_price", 0);
        if(buy_this!=null) {
            System.out.println("add to Order used");
            receipt.add(buy_this);
            makeTotal();

        }

    }

    public void makeTotal(){
        total_val=0;
        for (int i=0;i<objects.size();i++){
            total_val+=objects.get(i).getPrice()*objects.get(i).getQ();
        }
        total.setText(Double.toString(total_val));
    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        ImageView add, subtract;

        public MyAdapter(Context c) {
            super(c, R.layout.receipt_row, receipt);
            this.context=c;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.receipt_row, parent, false);
            TextView name = row.findViewById(R.id.row_item_name);
            TextView price = row.findViewById(R.id.row_item_price);
            TextView quantity = row.findViewById(R.id.row_item_quantity);
            add = row.findViewById(R.id.add_item);
            subtract = row.findViewById(R.id.subtract_item);
            if(!objects.isEmpty()&&position>=0) {

                name.setText(objects.get(position).getName());
                price.setText(objects.get(position).getPrice().toString());
                quantity.setText(objects.get(position).getQ().toString());

            }

            add.setOnClickListener(v -> {
                objects.get(position).setQ(objects.get(position).getQ()+1);
                quantity.setText(objects.get(position).getQ().toString());
                makeTotal();
            });

            subtract.setOnClickListener(v -> {
                if(objects.get(position).getQ()>0) {
                    objects.get(position).setQ(objects.get(position).getQ() - 1);
                    quantity.setText(objects.get(position).getQ().toString());
                    makeTotal();
                }
            });

            return row;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_1:
                //something
                return true;
            case R.id.item_2:
                //something
                return true;
            case R.id.item_3:
                //something
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}