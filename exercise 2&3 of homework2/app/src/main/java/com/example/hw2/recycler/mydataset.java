package com.example.hw2.recycler;

import java.util.ArrayList;
import java.util.List;

public class mydataset {
//public mydata(String title, String time,String description,String icon,boolean iso)
    public static List<mydata> getData() {
        List<mydata> result = new ArrayList();
        result.add(new mydata("抖音小助手", "刚刚","你有一个新的粉丝","TYPE_ROBOT",true));
        result.add(new mydata("游戏小助手", "刚刚","抖出好游戏","TYPE_GAME",true));
        result.add(new mydata("我叫豆豆啊哇塞", "昨天","转发[视频]","TYPE_USER",false));
        result.add(new mydata("系统消息", "2020/07/06","感谢你参加本次举报活动","TYPE_SYSTEM",true));
        result.add(new mydata("陌生人消息", "刚刚","猜猜我是谁","TYPE_STRANGER",false));
        result.add(new mydata("喂喂喂", "刚刚","[Hi]","TYPE_USER",false));
        result.add(new mydata("系统消息", "2020/07/05","账号登录提醒","TYPE_SYSTEM",true));
        result.add(new mydata("吴朝晖", "刚刚","同学你好","TYPE_USER",false));
        result.add(new mydata("抖音小助手", "刚刚","你有一个新的粉丝","TYPE_ROBOT",true));
        result.add(new mydata("陌生人消息", "刚刚","猜猜我是谁","TYPE_STRANGER",false));
        result.add(new mydata("抖音小助手", "刚刚","你有一个新的粉丝","TYPE_ROBOT",true));
        return result;
    }

}