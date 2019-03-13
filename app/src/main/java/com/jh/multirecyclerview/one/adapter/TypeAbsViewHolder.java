package com.jh.multirecyclerview.one.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jh.multirecyclerview.Person;

public abstract class TypeAbsViewHolder extends RecyclerView.ViewHolder {

    public TypeAbsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    // 公共方法，便于外部调用
    public abstract void bindHolder(Person person);

}
