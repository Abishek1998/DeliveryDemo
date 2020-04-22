package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeliveryData extends AppCompatActivity {

    TextView door1,address1,city1,contact1;
    Button select,edit,delete,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_data);

        door1 = findViewById(R.id.door1);
        address1 = findViewById(R.id.address1);
        city1 = findViewById(R.id.city1);
        contact1 = findViewById(R.id.contact1);

        select = findViewById(R.id.select1);
        edit = findViewById(R.id.edit1);
        delete = findViewById(R.id.delete1);
        add = findViewById(R.id.add);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryData.this,OrderConfirmed.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryData.this, AddDelivery.class);
                startActivity(intent);
            }
        });

       door1.setText(getIntent().getStringExtra("Door"));
       address1.setText(getIntent().getStringExtra("Address"));
       city1.setText(getIntent().getStringExtra("City"));
       contact1.setText(getIntent().getStringExtra("Contact"));


    }
}
