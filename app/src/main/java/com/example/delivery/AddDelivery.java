package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDelivery extends AppCompatActivity {

    DatabaseHelper myDb;

    public static final String EXTRA_MESSAGE = "com.example.delivery";
    EditText etdoor,etaddress,etcity,etcontact;
    Button save;

    String door;
    String address;
    String city;
    String contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);

        myDb = new DatabaseHelper(this);

        etdoor = (EditText) findViewById(R.id.etdoor);
        etaddress = (EditText) findViewById(R.id.etaddress);
        etcity = (EditText) findViewById(R.id.etcity);
        etcontact = (EditText) findViewById(R.id.etcontact);
        save = (Button) findViewById(R.id.save);
        AddData();

        /*save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String door = etdoor.getText().toString();
                String address = etaddress.getText().toString();
                String city = etcity.getText().toString();
                String contact = etcontact.getText().toString();

                Intent intent = new Intent(AddDelivery.this,DeliveryData.class);

                intent.putExtra("Door",door);
                intent.putExtra("Address",address);
                intent.putExtra("City",city);
                intent.putExtra("Contact",contact);

                startActivity(intent);
            }
        });*/
    }

    public void AddData(){
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(etdoor.getText().toString(),etaddress.getText().toString(),etcity.getText().toString(),etcontact.getText().toString());
                if (isInserted = true) Toast.makeText(AddDelivery.this,"Data Added",Toast.LENGTH_LONG).show();
                else Toast.makeText(AddDelivery.this,"Not Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }




}
