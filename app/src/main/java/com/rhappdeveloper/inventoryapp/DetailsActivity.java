package com.rhappdeveloper.inventoryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.rhappdeveloper.inventoryapp.model.PartObject;

public class DetailsActivity extends AppCompatActivity {

    ImageView photoImageView;
    TextView item_partNumber;
    TextView item_quantity;
    TextView sub_item_name;
    TextView sub_item_description;
    Button recieveBtn;
    Button consumeBtn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        PartObject partObject = intent.getParcelableExtra("partObject");

        photoImageView = findViewById(R.id.photoImageViewDA);
        item_partNumber = findViewById(R.id.item_partNumber);
        item_quantity = findViewById(R.id.item_quantity);
        sub_item_name = findViewById(R.id.sub_item_name);
        sub_item_description = findViewById(R.id.sub_item_description);
        recieveBtn = findViewById(R.id.recieveBtn);
        consumeBtn = findViewById(R.id.consumeBtn);

        Glide.with(this).load(partObject.getImage()).into(photoImageView);
        item_partNumber.setText("Part #: " + partObject.getPartNumber());
        item_quantity.setText("Qty #: " + partObject.getInStock());
        sub_item_name.setText("Name: " + partObject.getName());
        sub_item_description.setText("Description: " + partObject.getDescription());
    }
}