package com.jh.multirecyclerview.two;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.multirecyclerview.R;
import com.jh.multirecyclerview.two.model.DataModelOne;

/**
 * Created by Administrator on 2017/12/24.
 */

public class TypeOneViewHolder1 extends TypeAbstractViewHolder1<DataModelOne> {

    public ImageView avatar;
    public TextView name;
    public TypeOneViewHolder1(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        itemView.setBackgroundColor(Color.GREEN);
    }

    @Override
    public void bindViewHolder(DataModelOne model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);

    }


}
