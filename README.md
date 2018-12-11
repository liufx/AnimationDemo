# AnimationDemo帧动画,补间动画,属性动画的简单使用

[![](https://img.shields.io/badge/QQ-547166147-orange.svg)](https://github.com/liufx/AnimationDemo)


- **GitHub地址：** [https://github.com/liufx/AnimationDemo](https://github.com/liufx/AnimationDemo)

**（开源不易，如果喜欢的话希望给个小星星，谢谢~）**

《AnimationDemo》 是对帧动画、补间动画、属性动画从xml和java代码两个层面对动画的使用进行了阐述。本项目采用 java 语言编写，，代码结构清晰有详细注释，如有任何疑问和建议请提 Issue或联系[![](https://img.shields.io/badge/QQ:-547166147@qq.com-blue.svg)]()



## 前言

前段时间学习了 Android 中的动画编程，闲了整理了一下，简单易懂，注释清晰方便大家查看！

## 项目截图

- 截图

![](https://github.com/liufx/AnimationDemo/screenshot/home.jpg)

- gif

   <img src="/screenshot/anim_frame.gif" width = "240" height = "360" alt="帧动画">
   <img src="/screenshot/anim_alpha.gif" width = "240" height = "360" alt="透明度动画">
   <img src="/screenshot/anim_scale.gif" width = "240" height = "360" alt="缩放动画">
   <img src="/screenshot/anim_tran.gif" width = "240" height = "360" alt="平移动画">
   <img src="/screenshot/anim_rotate.gif" width = "240" height = "360" alt="旋转动画">
   <img src="/screenshot/animator_value.gif" width = "240" height = "360"alt="属性动画" >

## 具体实现

- **帧动画——FrameAnimation：** 
　　将一系列图片有序播放，形成动画的效果。其本质是一个Drawable，是一系列图片的集合，本身可以当做一个图片一样使用<br>
　　在Drawable文件夹下，创建animation-list为根节点的资源文件<br>
``` Bash
 <animation-list xmlns:android="http://schemas.android.com/apk/res/android"
    android:oneshot="false">

    <!--oneshot 是否只播放一次 -->

    <!--drawable:一帧引用的图片 -->
    <!--duration:一帧播放的时间 -->

    <item
        android:drawable="@drawable/loading00"
        android:duration="40" />
    <item
        android:drawable="@drawable/loading01"
        android:duration="40" />
    <item
        android:drawable="@drawable/loading02"
        android:duration="40" />
    <item
        android:drawable="@drawable/loading03"
        android:duration="40" />
    <item
        android:drawable="@drawable/loading04"
        android:duration="40" />
    <item
        android:drawable="@drawable/loading05"
        android:duration="40" />
    <item
        android:drawable="@drawable/loading06"
        android:duration="40" />
    <item
        android:drawable="@drawable/loading07"
        android:duration="40" />
    <item
        android:drawable="@drawable/loading08"
        android:duration="40" />
</animation-list>
```
oneshot:是否只播放一次   <br>   

　　drawable:一帧引用的图片<br>
　　duration:一帧播放的时间<br>
播放动画<br>
　　将动画作为控件的背景<br>
　　((AnimationDrawable)view.getBackground()).start();<br>
 
Animation常用属性<br>
　　duration:动画时间     <br>              
　　repeatCount:重复次数 infinite无限次<br>
　　fillAfter:是否停止在最后一帧<br>
　　repeatMode:重复模式     值：restart重新开始，reserve反复<br>
　　startOffset:开始延迟时间<br>
- **补间动画 Tween Animation：** <br>
　　只能应用于View对象，只支持部分属性，View animation值改变了View绘制的位置，并没有改变对象本身的真实位置<br>
　　可以使用XML定义也可以使用代码定义     XML定义的动画放在/res/anim/文件夹内<br>
 
　　开始动画 通过view的startAnimation(Animation a)  参数定义的动画<br>
  四种补间动画通过XML定义<br>
**AlphaAnimation：透明度动画**
``` Bash
 <?xml version="1.0" encoding="utf-8"?>
<alpha xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="2000"
    android:fromAlpha="0"
    android:toAlpha="1">
    <!--
    fromAlpha 起始透明度 0为完全透明 1为不透明 0~1之间的浮点值
    toAlpha 结束透明度
    duration 动画运行时间 单位毫秒
    -->
</alpha>
```
``` Java
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
```
**ScaleAnimation：缩放动画**
``` Bash
<?xml version="1.0" encoding="utf-8"?>
<scale xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="2000"
    android:fromXScale="0.1"
    android:fromYScale="0.1"
    android:pivotX="0%"
    android:pivotY="0%"
    android:toXScale="1"
    android:toYScale="1">
    <!--
            浮点值 表示倍数 自身几倍
            fromXScale 动画在X轴以自身几倍伸缩开始
            toXScale   动画在X轴以自身几倍伸缩结束

            fromYScale 动画在Y轴以自身几倍伸缩开始
            toYScale   动画在Y轴以自身几倍伸缩结束

            pivotX  动画相对于控件自身的X坐标的开始位置
            pivotY  动画相对于控件自身的Y坐标的开始位置
            0% 0%  表示控件左上角 为0，0原点坐标
    -->
</scale>
```
``` Java
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
```
**TranslateAnimation：平移动画**
``` Bash
 <?xml version="1.0" encoding="utf-8"?>
<translate xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="2000"
    android:fromXDelta="-100%p"
    android:fromYDelta="0"
    android:toXDelta="100%p"
    android:toYDelta="0">
    <!--
            fromXDelta x轴起始位置
            toXDelta   X轴结束位置
            fromYDelta y轴起始位置
            toYDelta   y轴结束位置
            100%p 表示相对于父级
            100%相对于自身
-->
</translate>
```
``` Java
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

```
**RotateAnimation：旋转动画**
``` Bash
<?xml version="1.0" encoding="utf-8"?>
<rotate xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="2000"
    android:fromDegrees="0"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator"
    android:pivotX="50%"
    android:pivotY="50%"
    android:toDegrees="360">
    <!--
      interpolator 指定动画的插值器
      accelerate_decelerate_interpolator   加速-减速
      accelerate_interpolator               加速
      decelerate_interpolator               减速

      fromDegrees 动画起始角度
      toDegrees   动画结束旋转的角度 可以大于360度
      负数表示逆时针旋转  正数表示顺时针旋转

      pivotX相对于view的X坐标的开始位置
      pivotY相对于view的Y坐标的开始位置
绝对尺寸 100px
      50% 相对尺寸 相对于自身的50%
      50%p 相对尺寸 相对于父容器的50%
      50%为物件的X或Y方向坐标上的中点位置
     duration  动画播放时间 单位毫秒
-->
</rotate>
```
``` Java
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

```

- **属性动画：** <br>
　　相对补间动画  属性动画会真正的使目标对象的属性值发生改变，不像补间动画只是影像的改变只能修改具有get/set方法的属性值<br>
　　因为可以修改对象的属性，属性动画可以做到更多的效果,改变文本大小，背景颜色等等<br>
　　属性动画创建在 res/animator<br>
　　
ValueAnimator<br>
包含属性动画的所有核心功能，动画时间，开始、结束属性值，属性值计算方法等。<br>

ValuAnimiator设置开始结束值 实现ValueAnimator.onUpdateListener接口，<br>

这个接口只有一个函数onAnimationUpdate()，在这个函数中会传入ValueAnimator对象做为参数，<br>
通过这个ValueAnimator对象的getAnimatedValue()函数可以得到当前的属性值<br>

把属性值设置给某个控件的某个属性<br>
```Java
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
```

## 关于我

 - Email: 547166147@qq.com
 
## Thanks

- [感谢所有优秀的blogs](https://www.cnblogs.com/ldq2016/p/5407061.html) 



## LICENSE

```
Copyright 2018 liufx

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


