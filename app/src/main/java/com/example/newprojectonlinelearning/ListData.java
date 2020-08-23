package com.example.newprojectonlinelearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class ListData extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Model> mahasiswaArrayList;
    private ImageView tambah_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        recyclerView = (RecyclerView) findViewById(R.id.rvdata);
        addData();
    }

    void addData() {
        mahasiswaArrayList = new ArrayList<>();
        Model data1 = new Model();
        data1.setOriginal_title("Makanan");
        data1.setPoster_path("https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/schedule.png");
        data1.setAdult(false);
        data1.setOverview("Makanan ini enak sekali");
        data1.setVote_count(100);
        data1.setRelease_date("01-01-2020");
        mahasiswaArrayList.add(data1);


        adapter = new MahasiswaAdapter(mahasiswaArrayList, new MahasiswaAdapter.Callback() {
            @Override
            public void onClick(int position) {

            }

            @Override
            public void test() {

            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListData.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //get data online


    }
}