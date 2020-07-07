package com.example.hw2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw2.recycler.mAdapter;
import com.example.hw2.recycler.mydata;
import com.example.hw2.recycler.mydataset;

public class MainActivity extends AppCompatActivity implements mAdapter.IOnItemClickListener{
    private static final String TAG = "TAG";
    public static final String CHAT_OBJECT = "CHAT_OBJECT";
    public static final String ITEM_NUM = "ITEM_NUM";
    private RecyclerView recyclerView;
    private com.example.hw2.recycler.mAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ViewGroup root = findViewById(R.id.rootheader);
        int count = getAllChildViewCount(root);
        Toast.makeText(MainActivity.this, "除根布局外所有的View个数为："+(count-1), Toast.LENGTH_SHORT).show();
    }
    public int getAllChildViewCount(View view) {
        //递归截止条件
        if(view == null)
            return 0;
        if(!(view instanceof ViewGroup))
            return 1;
        //若是ViewGroup,对其所有子view递归遍历，sum记录子树总节点数
        int i,sum = 1;
        ViewGroup vg = (ViewGroup) view;
        for (i=0;i<vg.getChildCount();++i){
            sum += getAllChildViewCount(vg.getChildAt(i));
        }

        return sum;
    }
    private void initView() {
        RecyclerView rv_msg= findViewById(R.id.rv_list);
        rv_msg.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv_msg.setLayoutManager(linearLayoutManager);

        //适配器设置
        mAdapter mad = new mAdapter(mydataset.getData());
        mad.setOnItemClickListener(this);
        rv_msg.setAdapter(mad);
        Log.i(TAG,"hahahahah");
/*
        layoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(TestDataSet.getData());
        mAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(mAdapter);
        LinearItemDecoration itemDecoration = new LinearItemDecoration(Color.BLUE);
//        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//        DefaultItemAnimator animator = new DefaultItemAnimator();
//        animator.setAddDuration(3000);
//        recyclerView.setItemAnimator(animator);
*/
    }

    @Override
    protected void onStart() {
        super.onStart();
       // Log.i(TAG, "RecyclerViewActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
      //  Log.i(TAG, "RecyclerViewActivity onResume");
    }


    @Override
    public void onItemCLick(int position, mydata data) {
      Toast.makeText(MainActivity.this, "这是第" + position + "条", Toast.LENGTH_SHORT).show();
      //  mAdapter.addData(position + 1, new TestData("新增头条", "0w"));
        String name=data.title;
        Intent intent = new Intent(this, ChatState.class);
        intent.putExtra(CHAT_OBJECT,name);
        intent.putExtra(ITEM_NUM,position);
        startActivity(intent);
    }

    @Override
    public void onItemLongCLick(int position, mydata data) {
    //    Toast.makeText(RecyclerViewActivity.this, "长按了第" + position + "条", Toast.LENGTH_SHORT).show();
     //   mAdapter.removeData(position);
    }

}
