package com.example.burgervan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.burgervan.MainActivity.quantity;
import static com.example.burgervan.MainActivity.receipt;

public class MainMenu extends AppCompatActivity {



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
        gridView = findViewById(R.id.main_menu_gridview);

        addToList();


        CustomGridAdapter customGridAdapter = new CustomGridAdapter();
        gridView.setAdapter(customGridAdapter);


        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent12 = new Intent(getApplicationContext(), SubMenu.class);
            intent12.putExtra("menu_name", menuNames[position]);
            startActivity(intent12);
        });

        listView = findViewById(R.id.main_menu_listview);
//        CustomListAdapter customListAdapter = new CustomListAdapter();
        if(!receipt.isEmpty()) {
            MyAdapter myAdapter = new MyAdapter(this, receipt, imgRes);
            listView.setAdapter(myAdapter);
        }

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

    private void addToList(){
        System.out.println("add to List used");
        Intent intent = getIntent();

        String buy_this = intent.getStringExtra("buythis");
        if(buy_this!=null) {
            receipt.add(buy_this);
            quantity.add(1);
        }
    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        ArrayList<String> rtitle;
        int []rImg;

        public MyAdapter(Context c, ArrayList<String> title, int []res) {
            super(c, R.layout.receipt_row, menuNames);
            this.context=c;
            this.rtitle=title;
            this.rImg=res;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.receipt_row, parent, false);
            TextView names = row.findViewById(R.id.row_item_name);
//            System.out.println("size"+rtitle.size());
//            System.out.println("pos"+position);
            if(!rtitle.isEmpty())
                names.setText(rtitle.get(position));

            return row;
        }
    }
}