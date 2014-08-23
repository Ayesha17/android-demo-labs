package com.example.nineoldandroids;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.nineoldandroids.animation.*;

import static com.nineoldandroids.view.ViewPropertyAnimator.animate;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private boolean mIsMenuOpen;

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LinearLayout mainLayout = (LinearLayout)findViewById(R.id.main_layout);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View menu = layoutInflater.inflate(R.layout.menu,null);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mainLayout.addView(menu,layoutParams);

        b1 = (Button)menu.findViewById(R.id.item1);
        b2 = (Button)menu.findViewById(R.id.item2);
        b3 = (Button)menu.findViewById(R.id.item3);
        b4 = (Button)menu.findViewById(R.id.item4);
        b5 = (Button)menu.findViewById(R.id.item5);


    }

    public void AddAnimatorOnClick(View view){

        // 旋转360
        ObjectAnimator.ofFloat((Object)view,"rotation",0,360).start();

        // 向右滑动200dp
//        ObjectAnimator.ofFloat((Object)view,"translationX",0,200).start();

        // x方向渐变
//        ObjectAnimator.ofFloat((Object)view,"scaleX",1,1.5f).start();

        // 渐变不错的例子
//        float [] vaules = new float[]{0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f, 1.1f, 1.2f, 1.3f, 1.25f, 1.2f, 1.15f, 1.1f, 1.0f};
//        AnimatorSet set = new AnimatorSet();
//        set.playTogether(ObjectAnimator.ofFloat(view, "scaleX", vaules),
//                ObjectAnimator.ofFloat(view, "scaleY", vaules));
//        set.setDuration(150);
//        set.start();

        // 透明度渐变
//        ObjectAnimator.ofFloat((Object)view, "alpha", 1, 0.25f, 1).start();

        // 颜色渐变
//        ValueAnimator colorAnim = ObjectAnimator.ofInt((Object)view, "backgroundColor", /*Red*/0xFFFF8080, /*Blue*/0xFF8080FF);
//        colorAnim.setDuration(3000);
//        colorAnim.setEvaluator(new ArgbEvaluator());
//        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
//        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
//        colorAnim.start();

        // 并发执行一组动画
        // 注：无法循环执行一组动画
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(ObjectAnimator.ofFloat((Object)view,"rotation",0,360),ObjectAnimator.ofFloat((Object)view,"translationX",0,200));
//        animatorSet.setDuration(5 * 1000).start();

        // nideoldandroid 特有
//        animate(view).setDuration(2000).rotationYBy(720).x(100).y(100);

    }

    public void animateMenuClick(View view){

        addAnimateClick(view);

        if (!mIsMenuOpen) {
            mIsMenuOpen = true;
            doAnimateOpen(b1, 0, 4, 300);
            doAnimateOpen(b2, 1, 4, 300);
            doAnimateOpen(b3, 2, 4, 300);
            doAnimateOpen(b4, 3, 4, 300);
            //doAnimateOpen(b5, 4, 5, 300);
        } else {
            mIsMenuOpen = false;
            doAnimateClose(b1, 0, 4, 300);
            doAnimateClose(b2, 1, 4, 300);
            doAnimateClose(b3, 2, 4, 300);
            doAnimateClose(b4, 3, 4, 300);
            //doAnimateClose(b5, 4, 5, 300);
        }

    }

    public void addAnimateClick(View view){
        float [] vaules = new float[]{0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f, 1.1f, 1.2f, 1.3f, 1.25f, 1.2f, 1.15f, 1.1f, 1.0f};
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(view, "scaleX", vaules),
                ObjectAnimator.ofFloat(view, "scaleY", vaules));
        set.setDuration(150);
        set.start();
    }

    /**
     * 打开菜单的动画
     * @param view 执行动画的view
     * @param index view在动画序列中的顺序
     * @param total 动画序列的个数
     * @param radius 动画半径
     */
    private void doAnimateOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = (int) (radius * Math.cos(degree));
        int translationY = (int) (radius * Math.sin(degree));
        Log.d(TAG, String.format("degree=%f, translationX=%d, translationY=%d",
                degree, translationX, translationY));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1));
        //动画周期为500ms
        set.setDuration(1 * 200).start();
    }

    /**
     * 关闭菜单的动画
     * @param view 执行动画的view
     * @param index view在动画序列中的顺序
     * @param total 动画序列的个数
     * @param radius 动画半径
     */
    private void doAnimateClose(final View view, int index, int total,
                                int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = (int) (radius * Math.cos(degree));
        int translationY = (int) (radius * Math.sin(degree));
        Log.d(TAG, String.format("degree=%f, translationX=%d, translationY=%d",
                degree, translationX, translationY));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f));
        //为动画加上事件监听，当动画结束的时候，我们把当前view隐藏
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }
        });

        set.setDuration(1 * 500).start();
    }
}
