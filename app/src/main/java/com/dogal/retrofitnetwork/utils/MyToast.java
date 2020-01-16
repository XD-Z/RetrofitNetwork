package com.dogal.retrofitnetwork.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dogal.retrofitnetwork.R;

/**
 * @author Dogal
 * @time 2020/01/01
 */

public class MyToast {
    public static void myTosat(Context context, int imageId, int duration) {
        //new一个toast传入要显示的activity的上下文
        Toast toast = new Toast(context);
        //显示的时间
        toast.setDuration(duration);
        //显示的位置
        toast.setGravity(Gravity.CENTER, 0, 0);
        //重新给toast进行布局
        LinearLayout toastLayout = new LinearLayout(context);
        toastLayout.setOrientation(LinearLayout.HORIZONTAL);
        toastLayout.setGravity(Gravity.CENTER);
        toastLayout.setBackgroundColor(context.getResources().getColor(R.color.white));

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageId);
        //把imageView添加到toastLayout的布局当中
        toastLayout.addView(imageView);

//        TextView textView = new TextView(context);
//        textView.setText(content);
//        textView.setBackgroundColor(Color.GRAY);
        //把textView添加到toastLayout的布局当中
//        toastLayout.addView(textView);
//        toastLayout.setBackgroundColor(Color.GRAY);
        //把toastLayout添加到toast的布局当中
        toast.setView(toastLayout);
        toast.show();
    }


    /**
     * 显示有image的toast 这是个view
     */
    public static Toast showToastCenterText(Context context, final String tvStr, int duration) {
        Toast toast2 = new Toast(context);
        //显示的时间
        toast2.setDuration(duration);
        View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
        TextView tv = (TextView) view.findViewById(R.id.toast_custom_tv);
        tv.setText(TextUtils.isEmpty(tvStr) ? "" : tvStr);
        toast2.setView(view);
        toast2.setGravity(Gravity.CENTER, 0, 0);
        toast2.show();
        return toast2;
    }

}
