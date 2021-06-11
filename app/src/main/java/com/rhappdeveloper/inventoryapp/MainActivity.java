package com.rhappdeveloper.inventoryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.rhappdeveloper.inventoryapp.adapter.PartListAdapter;
import com.rhappdeveloper.inventoryapp.api.ApiInterface;
import com.rhappdeveloper.inventoryapp.api.RetrofitClient;
import com.rhappdeveloper.inventoryapp.model.PartObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView dataNotFoundTV;
    PartListAdapter adapter;
    ApiInterface apiInstance;
    List<PartObject> PartObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = findViewById(R.id.inventoryPartListRV);
        dataNotFoundTV = findViewById(R.id.dataNotFoundTV);

        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiInstance = RetrofitClient.getClient().create(ApiInterface.class);
        Call<List<PartObject>> call = apiInstance.getParts();
        call.enqueue(new Callback<List<PartObject>>() {
            @Override
            public void onResponse(Call<List<PartObject>> call, Response<List<PartObject>> response) {
                recyclerView.setVisibility(View.VISIBLE);
                dataNotFoundTV.setVisibility(View.GONE);
                PartObjects = response.body();
                adapter = new PartListAdapter(MainActivity.this, PartObjects);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PartObject>> call, Throwable t) {
                recyclerView.setVisibility(View.GONE);
                dataNotFoundTV.setVisibility(View.GONE);
            }
        });

    }
}