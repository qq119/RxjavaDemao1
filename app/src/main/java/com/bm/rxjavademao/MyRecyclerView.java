package com.bm.rxjavademao;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hecl on 2016/11/7.
 */

public class MyRecyclerView extends Activity {

    private RecyclerView myRecyclerView;
    private ArrayList<String> mData;
    private myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_recycler_view);
        setdata();
        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(adapter = new myAdapter());
        myRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });

    }

    private void setdata() {
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add("小城故事多"+i);
        }

    }

    class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder itemView = new MyViewHolder(LayoutInflater.from(
                    MyRecyclerView.this).inflate(R.layout.item_recyler, parent,
                    false));
            return itemView;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(mData.get(position).toString());
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView textView;
            public MyViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.textView);
            }
        }
    }
}
