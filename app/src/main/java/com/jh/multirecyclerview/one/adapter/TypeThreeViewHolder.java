package com.jh.multirecyclerview.one.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.multirecyclerview.Person;
import com.jh.multirecyclerview.R;

public class TypeThreeViewHolder extends TypeAbsViewHolder {

    private ImageView avater;
    private TextView name;
    private TextView content;
    private ImageView iv;

    public TypeThreeViewHolder(@NonNull View itemView) {
        super(itemView);

        avater = (ImageView) itemView.findViewById(R.id.avater);
        name = (TextView) itemView.findViewById(R.id.name);
        content = (TextView) itemView.findViewById(R.id.content);
        iv = (ImageView) itemView.findViewById(R.id.content_color);

    }

    @Override
    public void bindHolder(Person person) {
        avater.setBackgroundResource(person.getAvaterColor());
        name.setText(person.getName());
        content.setText(person.getContent());
        iv.setBackgroundResource(person.getAvaterColor());
    }

}
