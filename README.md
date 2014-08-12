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



## Service组件基本使用

### 介绍

Service作为Android四大组件之一，在每一个应用程序中都扮演着非常重要的角色。它主要用于在后台处理一些耗时的逻辑，或者去执行某些需要长期运行的任务。必要的时候我们甚至可以在程序退出的情况下，让Service在后台继续保持运行状态。

### demo

1. 服务的启动/停止(Activity与Service弱关联)

>简单使用Activity启动Service

2. 服务的绑定/解绑(Activity与Service强关联)

>指定Service执行某具体任务

3. 标准Service

>Service内创建子线程来执行任务

4. 前台Service的启动/停止

>防止内存不足而被回收，而前台service不会被回收

5. 远程Service

>跨进程共享Service(demo略)

### 参考

[Android Service完全解析，关于服务你所需知道的一切(上)](http://blog.csdn.net/guolin_blog/article/details/11952435)

[Android Service完全解析，关于服务你所需知道的一切(下)](http://blog.csdn.net/guolin_blog/article/details/9797169)

 
## Android异步处理(Asynchronous processing)

### 需求描述/问题解决

#### 需求描述

有一个耗时的操作(例如，网络读取数据或者本地读取较大文件)，并同时需要根据所得数据进行UI操作。如果放在主线程中(UI线程)，那么app会出现"强制关闭"的错误，因此只能放在子线程中。但是问题又来了，主线程(UI线程)是非线程安全的，因此如果在子线程中同时进行UI操作，那么程序容易奔溃。

#### 问题解决

为此我们使用异步消息处理机制来解决该问题(Thread + Handler)。

### Demo

1. Thread + Handler


### 参考

[Android异步消息处理机制完全解析，带你从源码的角度彻底理解](http://blog.csdn.net/guolin_blog/article/details/9991569)














