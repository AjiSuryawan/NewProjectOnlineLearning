package com.example.newprojectonlinelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ListDataFavourite extends AppCompatActivity {
    Realm realm;
    RealmHelper realmHelper;
    TextView tvnodata;
    RecyclerView recyclerView;
    DataAdapterFavourite adapter;
    List<ModelMovieRealm> DataArrayList; //kit add kan ke adapter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        getSupportActionBar().hide();
        tvnodata = (TextView) findViewById(R.id.tvnodata);
        recyclerView = (RecyclerView) findViewById(R.id.rvdata);
        DataArrayList = new ArrayList<>();
        // Setup Realm
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);
        DataArrayList = realmHelper.getAllMovie();
        if (DataArrayList.size() == 0){
            tvnodata.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else{
            tvnodata.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter = new DataAdapterFavourite(DataArrayList, new DataAdapterFavourite.Callback() {
                @Override
                public void onClick(int position) {
                    Intent move = new Intent(getApplicationContext(), DetailFavourite.class);
                    move.putExtra("judul",DataArrayList.get(position).getJudul());
                    move.putExtra("path",DataArrayList.get(position).getPath());
                    move.putExtra("date",DataArrayList.get(position).getReleaseDate());
                    move.putExtra("deskripsi",DataArrayList.get(position).getDesc());
                    // di putextra yang lain
                    startActivity(move);
                }

                @Override
                public void test() {

                }
            });
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListDataFavourite.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }


    }


}