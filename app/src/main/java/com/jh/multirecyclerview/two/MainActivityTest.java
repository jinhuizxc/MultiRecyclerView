package com.jh.multirecyclerview.two;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jh.multirecyclerview.Person;
import com.jh.multirecyclerview.R;
import com.jh.multirecyclerview.one.adapter.MyAdapter;
import com.jh.multirecyclerview.two.model.DataModel;
import com.jh.multirecyclerview.two.model.DataModelOne;
import com.jh.multirecyclerview.two.model.DataModelThree;
import com.jh.multirecyclerview.two.model.DataModelTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用recycleView优雅实现加载不同的布局
 * https://github.com/Reoger/RecycleListView
 * <p>
 * 实现recyclerview中包含多种布局
 * https://github.com/CodingBin/ComplexRecyclerView
 */
public class MainActivityTest extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter recyclerAdapter;

    int colors[] = {android.R.color.holo_red_dark,
            android.R.color.holo_blue_dark,
            android.R.color.holo_orange_dark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        List<DataModel> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            //int type = (int) ((Math.random()*3) + 1);
            int type;
            if (i < 5 || (i > 15 && i < 20)) {
                type = 1;
            } else if (i < 10 || i > 26) {
                type = 2;
            } else {
                type = 3;
            }
            DataModel data = new DataModel();
            data.avatarColor = colors[type - 1];
            data.type = type;
            data.name = "name :" + type;
            data.content = "content :" + i;
            data.contentColor = colors[(type + 1) % 3];
            list.add(data);
        }

        List<DataModelOne> list1 = new ArrayList<DataModelOne>();
        for (int i = 0; i < 10; i++) {
            DataModelOne data = new DataModelOne();
            data.avatarColor = colors[0];
            data.name = "name :" + 1;
            list1.add(data);
        }

        List<DataModelTwo> list2 = new ArrayList<DataModelTwo>();
        for (int i = 0; i < 10; i++) {
            DataModelTwo data = new DataModelTwo();
            data.avatarColor = colors[1];
            data.name = "name :" + 1;
            data.content = "content";
            list2.add(data);
        }

        List<DataModelThree> list3 = new ArrayList<DataModelThree>();
        for (int i = 0; i < 10; i++) {
            DataModelThree data = new DataModelThree();
            data.avatarColor = colors[2];
            data.name = "name :" + 1;
            data.content = "content";
            data.contentColor = colors[2];
            list3.add(data);
        }

        recyclerAdapter.addList(list1, list2, list3);
        recyclerAdapter.notifyDataSetChanged();

    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
        //构造参数里面的2表示的是一行有两列
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                //若是TYPE_THREE，占用两列，否则占用一列
                if (type == Person.TYPE_THREE) {
                    return gridLayoutManager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });

        recyclerAdapter = new RecyclerAdapter(this);

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration(){
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams  = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()){
                    if (spanIndex == 1){
                        outRect.left = 10;
                    }else {
                        outRect.right = 10;
                    }
                }
            }
        });


        mRecyclerView.setAdapter(recyclerAdapter);

    }
}
