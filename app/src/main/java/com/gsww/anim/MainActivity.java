package com.gsww.anim;

import android.animation.AnimatorInflater;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.buttonA)
    Button buttonA;
    @BindView(R.id.buttonB)
    Button buttonB;
    @BindView(R.id.buttonC)
    Button buttonC;
    @BindView(R.id.consLayout1)
    ConstraintLayout consLayout1;
    @BindView(R.id.buttonD)
    Button buttonD;
    @BindView(R.id.buttonE)
    Button buttonE;
    @BindView(R.id.buttonF)
    Button buttonF;
    @BindView(R.id.consLayout2)
    ConstraintLayout consLayout2;
    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD, R.id.buttonE, R.id.buttonF})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonA:
                framAnim();
                break;
            case R.id.buttonB:
                alphaAnimation();
                break;
            case R.id.buttonC:
                scaleAnimation();
                break;
            case R.id.buttonD:
                translateAnimation();
                break;
            case R.id.buttonE:
                rotateAnimationXml();
                break;
            case R.id.buttonF:
                valueAnimation();
                break;
        }
    }

    //帧动画
    private void framAnim() {
        //将动画作为控件的背景
        image.setBackgroundResource(R.drawable.loading);
        ((AnimationDrawable) image.getBackground()).start();
    }

    //透明度动画
    private void alphaAnimationXml() {
        image.setBackgroundResource(R.drawable.bg_gril);
        // 初始化需要加载的动画资源
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        image.startAnimation(animation);
    }

    //透明度动画
    private void alphaAnimation() {
        image.setBackgroundResource(R.drawable.bg_gril);

        //AlphaAnimation(float fromAlpha, float toAlpha)
        //第一个参数fromAlpha为 动画开始时候透明度
        //第二个参数toAlpha为 动画结束时候透明度
        AlphaAnimation animation = new AlphaAnimation(0f, 1.0f);
        //说明:
        //   0.0表示完全透明
        //   1.0表示完全不透明
        animation.setDuration(2000);//单位是毫秒
        animation.setRepeatCount(2);//执行动画效果结束后重复执行2次  一共3次
        animation.setRepeatMode(Animation.REVERSE);//重复模式
        //动画结束是否停止在最后一帧
        animation.setFillAfter(true);
        //动画结束是否停止在第一帧
//        animation.setFillBefore(false);
        //设置插值器 动画执行速度  变速 加减速。。
        //AccelerateInterpolator减速
        //DecelerateInterpolator加速
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        image.startAnimation(animation);
    }

    //缩放动画
    private void scaleAnimationXml() {
        image.setBackgroundResource(R.drawable.bg_gril);
        // 初始化需要加载的动画资源
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        image.startAnimation(animation);
    }

    //缩放动画
    private void scaleAnimation() {
        image.setBackgroundResource(R.drawable.bg_gril);
        /**ScaleAnimation(float fromX, float toX, float fromY, float toY,
         int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)//
         //第一个参数fromX为动画起始时 X坐标上的伸缩尺寸
         //第二个参数toX为动画结束时 X坐标上的伸缩尺寸
         //第三个参数fromY为动画起始时Y坐标上的伸缩尺寸
         //第四个参数toY为动画结束时Y坐标上的伸缩尺寸
         /*说明:
         以上四种属性值
         0.0表示收缩到没有
         1.0表示正常无伸缩
         值小于1.0表示收缩
         值大于1.0表示放大
         */
        //第五个参数pivotXType为动画在X轴相对于物件位置类型
        //第六个参数pivotXValue为动画相对于物件的X坐标的开始位置
        //第七个参数pivotXType为动画在Y轴相对于物件位置类型
        //第八个参数pivotYValue为动画相对于物件的Y坐标的开始位置
        ScaleAnimation animation = new ScaleAnimation(0.0f, 1f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(1000);
        //设置时间持续时间为 1000毫秒
        image.startAnimation(animation);
    }

    //平移动画
    private void translateAnimationXml() {
        image.setBackgroundResource(R.drawable.bg_gril);
        // 初始化需要加载的动画资源
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        image.startAnimation(animation);
    }

    //平移动画
    private void translateAnimation() {
        image.setBackgroundResource(R.drawable.bg_gril);
        //TranslateAnimation(float fromXDelta, float toXDelta,float fromYDelta, float toYDelta)
        //第一个参数fromXDelta为动画起始时 X坐标上的移动位置
        //第二个参数toXDelta为动画结束时 X坐标上的移动位置
        //第三个参数fromYDelta为动画起始时Y坐标上的移动位置
        //第四个参数toYDelta为动画结束时Y坐标上的移动位置
        TranslateAnimation animation = new TranslateAnimation(-30.0f, 30.0f, -50.0f, 50.0f);
        animation.setDuration(2000);
        //设置时间持续时间为 2000毫秒
        image.startAnimation(animation);
    }

    //旋转动画
    private void rotateAnimationXml() {
        image.setBackgroundResource(R.drawable.bg_gril);
        // 初始化需要加载的动画资源
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        image.startAnimation(animation);
    }

    //旋转动画
    private void rotateAnimation() {
        image.setBackgroundResource(R.drawable.bg_gril);
        //RotateAnimation(float fromDegrees, float toDegrees,int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
        //第一个参数fromDegrees为动画起始时的旋转角度
        //第二个参数toDegrees为动画旋转到的角度
        //第三个参数pivotXType为动画在X轴相对于物件位置类型
        //第四个参数pivotXValue为动画相对于物件的X坐标的开始位置
        //第五个参数pivotXType为动画在Y轴相对于物件位置类型
        //第六个参数pivotYValue为动画相对于物件的Y坐标的开始位置
        RotateAnimation animation = new RotateAnimation(0.0f, +320.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);
        //设置时间持续时间为 2000毫秒
        image.startAnimation(animation);
    }

    //属性动画
    private void valueAnimationXml() {
        image.setBackgroundResource(R.drawable.bg_gril);
        ValueAnimator valueAnimator = null;
        //通过AnimatorInflater.loadAnimator()加载xml 创建ValueAnimator
        valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.animator_value);
        //动画执行时间
        valueAnimator.setDuration(3000);
        //值改变监听
        valueAnimator.addUpdateListener(listenerXml);
        //开始动画
        valueAnimator.start();
    }

    private ValueAnimator.AnimatorUpdateListener listenerXml = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            //获取值
            int value = (int) animation.getAnimatedValue();
            //image为测试控件
            //设置控件X轴平移
            image.setTranslationX(value);
        }
    };

    //属性动画 代码设置
    private void valueAnimation() {
        image.setBackgroundResource(R.drawable.bg_gril);
        ValueAnimator valueAnimator = null;
        /**
         * valueAnimator 单个值
         */
        //代码创建  ValueAnimator类自身的方法
        //ofFloat值类型float
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
//        //ofInt值类型int 从0~300
//        valueAnimator = ValueAnimator.ofInt(0, 300);
//        //也可以用来设置颜色 在颜色改变过程中会将颜色变化情况显示出来
//        //红色到蓝色的改变过程 显示N种颜色
//        valueAnimator = ValueAnimator.ofInt(Color.RED, Color.BLUE);
//        //ofArgb设置颜色 如果无法使用  是的sdk版本低了
//        //这个方法改变颜色过程中只显示红色和蓝色
//        //valueAnimator=ValueAnimator.ofArgb(Color.RED,Color.BLUE);
//        //设置插值器
//        valueAnimator.setInterpolator(new CycleInterpolator(1.0f));


        /**
         *
         * ValueAnimator.ofPropertyValuesHolder 设置多个值
         */
        //设置动画属性  参数1：名字  参数2，3值的变化区间
        PropertyValuesHolder alphaHolder = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
        PropertyValuesHolder widthHolder = PropertyValuesHolder.ofInt("width", 0, 300);
        PropertyValuesHolder rotateHolder = PropertyValuesHolder.ofInt("rotate", 0, 300);
        //ValueAnimator.ofPropertyValuesHolder 添加holder 创建动画
        valueAnimator = ValueAnimator.ofPropertyValuesHolder(alphaHolder, widthHolder, rotateHolder);
        //动画执行时间
        valueAnimator.setDuration(3000);
        //值改变监听
        valueAnimator.addUpdateListener(listener);
        //开始动画
        valueAnimator.start();
    }

    private ValueAnimator.AnimatorUpdateListener listener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            /**
             * 单个值获取 getAnimatedValue取出变化值 根据设置类型强转
             * btnValueAnimator 测试用的button
             */
//            int value= (int) animation.getAnimatedValue();
//            btnValueAnimator.setTranslationX(value);横坐标平移

//            float value= (float) valueAnimator.getAnimatedValue();
//            btnValueAnimator.setAlpha(value);透明度改变

//            int value= (int) animation.getAnimatedValue();
//            btnValueAnimator.setTextColor(value);文字颜色改变
            /**
             * PropertyValuesHolder存了多个值  通过名字获取 强制转换
             */
            float alpha = (float) valueAnimator.getAnimatedValue("alpha");
            int rotate = (int) valueAnimator.getAnimatedValue("rotate");
            int width = (int) valueAnimator.getAnimatedValue("width");
            image.setAlpha(alpha);//改变透明度
            image.setRotationX(rotate);
            //边旋转 边平移
            image.setTranslationX(width);
        }
    };

}
