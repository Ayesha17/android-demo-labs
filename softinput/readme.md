
## 知识点一(键盘类型)

adjustResize: 会重绘窗口大小，onMeasure,onSizeChanged,onLayout
adjustPan: 不会重绘窗口大小，onMeasure,onLayout
adjustUnspecified: 默认行为，整个界面往上顶(键盘与焦点所在输入框高度不足以容纳键盘时)

adjustResize和adjustUnspecified的"顶":
 这里需要注意区分adjustResize和adjustUnspecified的"顶",前者是对具体view/viewGroup的顶(需要重绘)而后者是界面的顶(却不进行布局重绘)

adjustResize和adjustPan区别：

adjustPan只保证焦点所在的控件可见。(通过将整个视图往上顶的方式，类似adjustUnspecified)。
然而如果使用adjustResize情况更为复杂，具体查看ResizeActivity。

adjustResize的注意点：

其实就是：线性布局和相对布局对adjustResize的影响

注：暂时把需要顶上去的布局简称：l

线性布局，则会出现顶不上去的情况。但是使用相对布局可以顶上去，前提是l是相对与根容器。
但是又有一个问题：如果l被顶上去，那么可能遮挡其他视图。影响了用户体验。为了解决这个问题
需要将遮挡部分定义未可滚动视图。且始终相对与l之上(above)。

经典案例: 聊天界面

[android:windowSoftInputMode属性详解](http://blog.csdn.net/twoicewoo/article/details/7384398)


## 知识点二(手势)

点击空白或者手势向下时，能够隐藏键盘。

这里有两种情形，即有ScrollView/无ScrollView。

OnGestureListener有下面的几个动作：
按下（onDown）： 刚刚手指接触到触摸屏的那一刹那，就是触的那一下。
抛掷（onFling）： 手指在触摸屏上迅速移动，并松开的动作。
长按（onLongPress）： 手指按在持续一段时间，并且没有松开。
滚动（onScroll）： 手指在触摸屏上滑动。
按住（onShowPress）： 手指按在触摸屏上，它的时间范围在按下起效，在长按之前。
抬起（onSingleTapUp）：手指离开触摸屏的那一刹那。

在Activity进行touch监听，为何子元素ScrollView却没有监听到？(这这可能涉及事件分发的机制)。

解决方案其实简单，在指定的view上进行touch监听便好。

[Android 手动显示和隐藏软键盘](http://blog.csdn.net/h7870181/article/details/8332991)
[Android 触摸及手势操作GestureDetector](http://blog.csdn.net/xyz_lmn/article/details/16826669)
[android使用GestureDetector实现手势下滑关闭页面的效果](http://www.cnblogs.com/yejiurui/p/3803658.html)



















