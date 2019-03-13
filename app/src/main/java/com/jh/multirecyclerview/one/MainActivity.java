package com.jh.multirecyclerview.one;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;

    private int colors[] = {
            android.R.color.holo_blue_bright,
            android.R.color.black,
            android.R.color.holo_red_dark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initData() {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Person person = new Person();
//            double random = Math.random();
//            Log.d("test", "initData: " + random);
            // Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
            int type = (int) (Math.random() * 3 + 1);  // 0-2 + 1
            person.type = type;
            person.content = "content" + i;
            person.avaterColor = colors[type - 1];
            person.name = "name" + i;
            list.add(person);
        }
        mMyAdapter.addList(list);
        mMyAdapter.notifyDataSetChanged();
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

        mMyAdapter = new MyAdapter(this);
         // 给布局里的子view添加边距
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()) {
                    if (spanIndex == 0) {
                        outRect.right = 0;
                    } else {
                        outRect.right = 10;
                    }
                }

            }
        });

        mRecyclerView.setAdapter(mMyAdapter);

    }
}
