package com.example.recyclerviewassignment;

import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.recyclerviewassignment.adapter.MyAdapter;
import com.example.recyclerviewassignment.model.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonToggle,buttonLoad;
    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<Post> list=new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        generateData();
        init();
    }

    private void init(){
        recyclerView=findViewById(R.id.recycle_view);
        buttonToggle=findViewById(R.id.button_toggle);
        buttonLoad=findViewById(R.id.button_load);
        buttonLoad.setOnClickListener(this);
        buttonToggle.setOnClickListener(this);
        layoutManager=new LinearLayoutManager(this);
        i=1;
        adapter=new MyAdapter(this,list);
        adapter.notifyDataSetChanged();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void generateData(){
        list.add(new Post(R.drawable.ic_assignment_ind_black_24dp,"title 1"));
        list.add(new Post(R.drawable.ic_alarm_black_24dp,"title 2"));
        list.add(new Post(R.drawable.ic_assistant_black_24dp,"title 3"));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_load:
                generateData();
                adapter.notifyDataSetChanged();
                break;
            case R.id.button_toggle:
                if (i==1){
                    i=2;

                }else {
                    i=1;
                }
                break;

        }

        if(i == 1){
            layoutManager=new LinearLayoutManager(this);
        }else{
            layoutManager=new GridLayoutManager(this,4);
        }
        recyclerView.setLayoutManager(layoutManager);
    }
}
