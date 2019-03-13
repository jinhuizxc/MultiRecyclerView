package com.jh.multirecyclerview.two;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/12/24.
 */

public abstract class TypeAbstractViewHolder1<T> extends RecyclerView.ViewHolder {

    public TypeAbstractViewHolder1(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(T model);  // 用T model 支持不同的对象
}
