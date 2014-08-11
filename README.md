android-demo-labs
=================



## ActionBar

### demo:

|名称|描述 |
|------|----|
|actionbar01| 主要actionbar的显示隐藏控制，以及最基础的使用且没用到xml来加载菜单 |
|actionbar02| 主要actionbar的位置控制(底部)|
|actionbar03| 主要actionbar添加搜索视图|
|actionbar04| 主要actionbar添加默认actionProvide (分享按钮)|
|actionbar05| 主要添加自定义actionProvide(自定义二级菜单)|
|actionbar06| 主要添加tab+ fragment|


### 参考：

[Android ActionBar完全解析，使用官方推荐的最佳导航栏(上)](http://blog.csdn.net/guolin_blog/article/details/18234477)

[Android ActionBar完全解析，使用官方推荐的最佳导航栏(下)](http://blog.csdn.net/guolin_blog/article/details/25466665)

[Android Working with Action Bar](http://www.androidhive.info/2013/11/android-working-with-action-bar/)



## SlideMenu

### intro

借助第三方库[SlidingMenu](https://github.com/jfeinstein10/SlidingMenu),组合+Fragment实现。

### 参考

[通过SlidingMenu+Fragment实现当前最流行的侧滑](http://www.krislq.com/2013/03/android_case_slidingmenu_fragment/)



## app设置界面

### intro

利用PreferenceFragment进行实现

### 参考

[Using PreferenceFragment to Store User Preferences](http://www.cs.dartmouth.edu/~campbell/cs65/lecture12/lecture12.html)

[Android: Using Switch Preference pre API level 14](http://stackoverflow.com/questions/9505901/android-using-switch-preference-pre-api-level-14)



## photoWallFalls (瀑布流图片demo)

### 知识点：

多任务异步下载,自定义scrollView,图片压缩等


### 参考

[Android瀑布流照片墙实现，体验不规则排列的美感](http://blog.csdn.net/guolin_blog/article/details/10470797)

[Android异步消息处理机制完全解析，带你从源码的角度彻底理解](http://blog.csdn.net/guolin_blog/article/details/9991569)

[Android AsyncTask完全解析，带你从源码的角度彻底理解](http://blog.csdn.net/guolin_blog/article/details/11711405)



## Tab (选项卡各实例)

### demo


|名称|描述 |
|------|----|
|TabActivity01|借助TabActivity实现旧的tab页切换demo1|
|TabActivity02|借助TabActivity实现旧的tab页切换demo2|
|TabActivity03|组合 TabHost + Fragment 实现tab页切换,并且将其置于视图底部|



### 参考

[Android TabActivity之感叹](http://bbs.51cto.com/thread-1012907-1.html)



## Volley

### 介绍

设计目标就是非常适合去进行数据量不大，但通信频繁的网络操作，而对于大数据量的网络操作，比如说下载文件等，Volley的表现就会非常糟糕。

### demo

1. String/Json/Gson
2. 图片

### 参考

[Android Volley系列](http://blog.csdn.net/guolin_blog/article/details/17482095)

## Broadcast 大喇叭

### 介绍

不要在广播中添加过多的逻辑或者进行任何耗时的操作，因为在广播中不允许开启线程的，当onReceive方法运行了较长时间而没有结束，程序就回报错。
因此，一般建议在广播接收器中完成打开程序或者组建的角色。

### demo

1. 系统广播之网络状态变更广播【动态注册】
2. 系统广播之系统启动广播【静态注册】
3. 自定义广播【静态注册】
4. 自定义广播之发送有序广播【静态注册】
5. 自定义本地广播之发送标准广播【动态注册】










