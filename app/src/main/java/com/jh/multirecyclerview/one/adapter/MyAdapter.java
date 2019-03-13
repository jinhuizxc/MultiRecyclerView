package com.jh.multirecyclerview.one.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jh.multirecyclerview.Person;
import com.jh.multirecyclerview.R;
import com.jh.multirecyclerview.two.model.DataModelOne;
import com.jh.multirecyclerview.two.model.DataModelThree;
import com.jh.multirecyclerview.two.model.DataModelTwo;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Person> mList = new ArrayList<>();

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //根据不同的viewType，创建并返回影响的ViewHolder
        switch (viewType) {
            case Person.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_one, parent, false));
            case Person.TYPE_TWO:
                return new TypeTwoViewHolder(mLayoutInflater.inflate(R.layout.item_type_two, parent, false));
            case Person.TYPE_THREE:
                return new TypeThreeViewHolder(mLayoutInflater.inflate(R.layout.item_type_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // 抽象出TypeAbsViewHolder，所以在进行绑定的时候可以直接调用
        ((TypeAbsViewHolder)holder).bindHolder(mList.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    // 使用此方法从获取数据
    public void addList(List<Person> list) {
        mList.addAll(list);
    }

    // 传统方式，不同item写多个
//    private class TypeOneViewHolder1 extends RecyclerView.ViewHolder {
//
//        public TypeOneViewHolder1(View itemView) {
//            super(itemView);
//        }
//    }
//
//    private class TypeTwoViewHolder1 extends RecyclerView.ViewHolder {
//        public TypeTwoViewHolder1(View itemView) {
//            super(itemView);
//        }
//    }
//
//    private class TypeThreeViewHolder1 extends RecyclerView.ViewHolder {
//
//        public TypeThreeViewHolder1(View itemView) {
//            super(itemView);
//        }
//    }
}
