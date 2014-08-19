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



## Volley(网络编程)

### 介绍

设计目标就是非常适合去进行数据量不大，但通信频繁的网络操作，而对于大数据量的网络操作，比如说下载文件等，Volley的表现就会非常糟糕。

### demo

String/Json/Gson

图片

### 参考

[Android Volley系列](http://blog.csdn.net/guolin_blog/article/details/17482095)

## Broadcast 大喇叭

### 介绍

不要在广播中添加过多的逻辑或者进行任何耗时的操作，因为在广播中不允许开启线程的，当onReceive方法运行了较长时间而没有结束，程序就回报错。
因此，一般建议在广播接收器中完成打开程序或者组建的角色。

### demo

 系统广播之网络状态变更广播【动态注册】
 
 系统广播之系统启动广播【静态注册】
 
 自定义广播【静态注册】
 
 自定义广播之发送有序广播【静态注册】
 
 自定义本地广播之发送标准广播【动态注册】


## Small(小而美的功能)

### demo

#### 退出确认功能

#### 全局获取Context

#### Intent对象传递




## Service组件基本使用

### 介绍

Service作为Android四大组件之一，在每一个应用程序中都扮演着非常重要的角色。它主要用于在后台处理一些耗时的逻辑，或者去执行某些需要长期运行的任务。必要的时候我们甚至可以在程序退出的情况下，让Service在后台继续保持运行状态。

### demo

#### 服务的启动/停止(Activity与Service弱关联)

>简单使用Activity启动Service

#### 服务的绑定/解绑(Activity与Service强关联)

>指定Service执行某具体任务

#### 标准Service

>Service内创建子线程来执行任务

#### 前台Service的启动/停止

>防止内存不足而被回收，而前台service不会被回收

#### 远程Service

>跨进程共享Service(demo略)

#### IntentService

> 综合了标准service以及自动关闭service(stopself)的优点而出现的

#### 最佳实践(定时执行任务)

两种方案：

无需setRepeating

需要setRepeating


### 重点

关于service生命周期

#### 如果service分别由bind和start方式启动，那么销毁该service必须经过unbind以及stop该service

#### service其实是在主线程中工作的，为此需要在子线程中进行耗时操作


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

#### Thread + Handler


### 参考

[Android异步消息处理机制完全解析，带你从源码的角度彻底理解](http://blog.csdn.net/guolin_blog/article/details/9991569)



## Android网络编程之HttpUrlConnection和HttpClient-Http请求


### Demo

#### HttpURLConnection请求


#### HttpClient请求


#### HttpURLConnection最佳实践

> 耗时操作必须在子线程操作否则会堵塞主线程。然而正因为在子线程中操作，网络请求返回的结果不可能直接通过return返回()。为此引进回调机制。


### 参考

《第一行代码》(网络编程章节)


## 滚动快速返回(Google Now 搜索) 和 滚动固定位置 (美团立即购买)


### sticky原理

使用一个placeholder视图作为占位,高度和宽度与真正需要显示的sticky视图完全一致。对于滚动操作，这里有两种情况需要处理。

第一：滚动没有超出占位所在的Y位置时，那么不需要置顶固定，只需要显示在占位视图所在的位置。

第二：滚动超出占位所在Y位置时，那么则需要置顶固定。

实现的时候分别取占位的getTop和getScrollY。


### quick return原理 (比较复杂)

有空深入--！



## 参考

[Android View坐标getLeft, getRight, getTop, getBottom解惑](http://blog.csdn.net/kongking0318/article/details/16118213)

[图解Android View的scrollTo(),scrollBy(),getScrollX(), getScrollY()](http://blog.csdn.net/bigconvience/article/details/26697645)

[getViewTreeObserver](http://www.xuebuyuan.com/1293145.html)

延伸：

[android应用程序中获取view的位置(绝对位置)](http://my.oschina.net/u/1376187/blog/172792)


## ListView demo


### 提升ListView运行效率

解决： viewHolder以及重用view解决

### listview子item中包含按钮控件，导致listview的OnItemClick失效

解决：在Button控件定义中追加

``
android:focusable="false"
android:focusableInTouchMode="false"
``


3. 重绘和刷新的区别

重绘：重新设置adapter，便会重绘ListView。滚动条位置重置。

刷新：只改变adapter数据，则不会重绘ListView，会刷新。滚动条位置不变。



## 向下兼容包 Android Switch(Android2.1++)


引用第三方项目（含资源文件）难点：

 Intellij如何引用第三方项目作为主项目使用

Step:

 1: 先将其以modlue方式导入

 2：将其在Facets中将其设置为Library module

 3: 设置原项目的Dependences添加该module


[组件地址](https://github.com/BoD/android-switch-backport)



## 基础控件

### TextView

[帮助文档](http://blog.csdn.net/ameyume/article/details/6094287)

#### Button

按钮响应以及按钮样式
[帮助文档](http://developer.android.com/guide/topics/ui/controls/button.html)

### EditText

定义键盘的表现形式(InputType),定制键盘指定的Action，创建自动提(AutoCompleteTextView)

注：inputType中的textCapSentences|textCapWords在4.2上没有作用。经验证其他同仁也又类似问题发生。

[帮助文档](http://developer.android.com/guide/topics/ui/controls/text.html)

### CheckBox | Radio

### Spinners(下拉)

### timepicker/datepicker 


























 












