package com.jh.multirecyclerview.two;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.multirecyclerview.R;
import com.jh.multirecyclerview.two.model.DataModelThree;

/**
 * Created by Administrator on 2017/12/24.
 */

public class TypeThreeViewHolder1 extends TypeAbstractViewHolder1<DataModelThree> {

    public ImageView avatar;
    public TextView name;
    public TextView content;
    public ImageView contentImage;
    public TypeThreeViewHolder1(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        contentImage = itemView.findViewById(R.id.contentImage);
        itemView.setBackgroundColor(Color.RED);
    }

    @Override
    public void bindViewHolder(DataModelThree model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);
        contentImage.setBackgroundResource(model.contentColor);

    }


}
