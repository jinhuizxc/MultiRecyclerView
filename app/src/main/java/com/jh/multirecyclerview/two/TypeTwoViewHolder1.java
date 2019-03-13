package com.jh.multirecyclerview.two;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.multirecyclerview.R;
import com.jh.multirecyclerview.two.model.DataModelTwo;

/**
 * Created by Administrator on 2017/12/24.
 */

public class TypeTwoViewHolder1 extends TypeAbstractViewHolder1<DataModelTwo> {

    public ImageView avatar;
    public TextView name;
    public TextView content;
    public TypeTwoViewHolder1(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void bindViewHolder(DataModelTwo model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);

    }


}
