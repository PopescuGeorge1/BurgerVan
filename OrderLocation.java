package com.example.burgervan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.burgervan.MainActivity.objects;

public class OrderLocation extends AppCompatActivity {

    EditText address, number;
    Button back, finalize;
    DatabaseReference databaseReference;
    public bundleForDatabase bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_location);
        address = findViewById(R.id.address_field);
        number = findViewById(R.id.number_field);
        back = findViewById(R.id.back_btn);
        finalize = findViewById(R.id.place_order_btn);



        databaseReference = FirebaseDatabase.getInstance().getReference().child("Order");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReceiptWindow.class);
                startActivity(intent);

            }
        });

        finalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //collect data and create bundle
                String loc = address.getText().toString();
                String nr = number.getText().toString();
                String total_Pay=String.valueOf(getIntent().getDoubleExtra("total_to_pay", 0));
                bundle = new bundleForDatabase(loc, nr, total_Pay, objects);

                //regex for contact number check
                Pattern pattern = Pattern.compile(".*\\D.*");
                Matcher matcher = pattern.matcher(number.getText().toString());


                if (address.getText().toString().length()>12&&address.getText().toString().length()<30)
                {
//                    Toast.makeText(OrderLocation.this, "You did not enter your address", Toast.LENGTH_SHORT).show();
                    address.setHint("Please enter a valid address");
                }else if(number.getText().toString().length()<10 && matcher.matches() && number.getText().toString().length()>20)
                {
                    Toast.makeText(OrderLocation.this, "Please enter a valid number with 10 to 20 digits", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference.push().setValue(bundle); 
                }
            }
        });

    }
}