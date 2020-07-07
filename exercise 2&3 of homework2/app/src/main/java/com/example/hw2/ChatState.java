package com.example.hw2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatState extends AppCompatActivity {

    public static final String CHAT_OBJECT = "CHAT_OBJECT";
    public static final String ITEM_NUM = "ITEM_NUM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_state);

        TextView tv_with_name = findViewById(R.id.tv_with_name);
        Intent intent = getIntent();
        String chat_object = intent.getStringExtra(CHAT_OBJECT);
        int item_num = intent.getIntExtra(ITEM_NUM,0);
        tv_with_name.setText("第"+Integer.toString(item_num)+"条，与"+chat_object+"的对话");
    }
}
