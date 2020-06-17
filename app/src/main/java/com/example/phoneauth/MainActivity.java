package com.example.phoneauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button Sendbutton;
    EditText phone_no;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sendbutton = (Button) findViewById(R.id.sendbutton);
        phone_no = (EditText) findViewById(R.id.phone_no);
        spinner = findViewById(R.id.spinnercountry);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,CountryData.countryNames));



        Sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];

                String mobile = phone_no.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    phone_no.setError("Enter a valid mobile");
                    phone_no.requestFocus();
                    return;

                }
                Intent intent = new Intent(MainActivity.this, Otpactivity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);

            }});

    }
}
