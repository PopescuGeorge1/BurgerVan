package com.example.burgervan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    TextView about_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        about_field = findViewById(R.id.about_textfield);

        about_field.setText(
                "BurgerVann is  inspired from fast food ordering applications, allowing it's users to browse through the menu, place orders and keep track of offers and new items. \n" +
                "The application is made with Android Studio 4.1 using Android 6.0 (API level 23). \n" +
                "Placed orders are being received by the through a Firebase realtime database \n"+
                "\n"+
                "I do not any of the media resources used in the application. \"BurgerVann\" was made for practicing android application development and not for selling purposes");
    }
}