package com.mrjalal.testrecyclerviewsample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final int PAGE_SIZE = 20;
    private int pageNumber = 1;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupList();

    }

    private void setupList(){
        RecyclerView recyclerView = findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Adapter(getMockData(pageNumber));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                pageNumber++;
                adapter.addItems(getMockData(pageNumber));
            }
        });
    }

    private List<SimpleModel> getMockData(int step) {
        List<SimpleModel> simpleModelList = new ArrayList<>();
        int color = getRandomColor();
        for (int i = PAGE_SIZE * (step - 1); i < PAGE_SIZE * step; i++) {
            simpleModelList.add(new SimpleModel.SimpleModelBuilder().id(i).text("item (" + i + ")").itemColor(color).build());
        }
        return simpleModelList;
    }

    private int getRandomColor(){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        return color;
    }
}
