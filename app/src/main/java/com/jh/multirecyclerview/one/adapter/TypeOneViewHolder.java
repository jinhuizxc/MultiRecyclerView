package com.jh.multirecyclerview.one.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.multirecyclerview.Person;
import com.jh.multirecyclerview.R;

public class TypeOneViewHolder extends TypeAbsViewHolder {

    private ImageView avater;
    private TextView name;

    public TypeOneViewHolder(@NonNull View itemView) {
        super(itemView);
        avater = (ImageView) itemView.findViewById(R.id.avater);
        name = (TextView) itemView.findViewById(R.id.name);
    }

    @Override
    public void bindHolder(Person person) {
        avater.setBackgroundResource(person.getAvaterColor());
        name.setText(person.getName());
    }

}
