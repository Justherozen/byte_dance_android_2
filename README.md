# byte_dance_android_2
hw2 of the camp

作业2的`getAllChildViewCount()`单独提交了一份在附属的exercise2.java中（工程中也有）

```java

public int getAllChildViewCount(View view) {
        /*
         对根布局进行一次preorder traversal，记录遍历到的ViewGroup和View的总数
         */
        if(view == null)return 0;
        if(!(view instanceof ViewGroup))return 1;
        //若是ViewGroup,对其所有子view递归遍历
        int i,sum = 1;
        ViewGroup vgroup = (ViewGroup) view;
        for (i=0;i<vgroup.getChildCount();++i){
			sum += getAllChildViewCount(vgroup.getChildAt(i));
		}
     return sum;
    }
      
```

界面初始，区分不同头像与官方

![image-20200707234526814](C:\Users\Administrator\Desktop\hw2admit\byte_dance_android_2\README.assets\image-20200707234526814.png)

点击进入某个聊天窗口，有两处是第几个item的提醒（一处只是短通知）

![image-20200707234625188](C:\Users\Administrator\Desktop\hw2admit\byte_dance_android_2\README.assets\image-20200707234625188.png)

![image-20200707234645336](C:\Users\Administrator\Desktop\hw2admit\byte_dance_android_2\README.assets\image-20200707234645336.png)

统计view的个数

![image-20200707235951981](C:\Users\Administrator\Desktop\hw2admit\byte_dance_android_2\README.assets\image-20200707235951981.png)

