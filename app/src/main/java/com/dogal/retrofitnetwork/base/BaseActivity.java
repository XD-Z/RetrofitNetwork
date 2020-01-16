package com.dogal.retrofitnetwork.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.dogal.retrofitnetwork.R;


/**
 * author: Dogal
 * data: 2020/01/01
 */

public class BaseActivity extends FragmentActivity {

    private TextView title_bar_name;
    private TextView title_bar_back;
    private TextView title_bar_close;
    protected Context mContext;
    protected Activity mActivity;
    private String mActivityJumpTag;
    private long mActivityJumpTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mContext = this;
        mActivity = this;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        title_bar_back = (TextView) findViewById(R.id.title_bar_back);
        title_bar_name = (TextView) findViewById(R.id.title_bar_name);
        title_bar_close = (TextView) findViewById(R.id.title_bar_close);

        if (title_bar_back != null) {
            title_bar_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        if (title_bar_close != null) {
            title_bar_close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    public void setVisible(boolean y) {
        if (y) {
            title_bar_close.setVisibility(View.GONE);
            title_bar_back.setVisibility(View.VISIBLE);
        } else {
            title_bar_close.setVisibility(View.VISIBLE);
            title_bar_back.setVisibility(View.GONE);
        }
    }

    public void setTitleName(String str) {
        if (title_bar_name != null) {
            title_bar_name.setText(str);
        }
    }

    /**
     * 检查当前 Activity 是否重复跳转了，不需要检查则重写此方法并返回 true 即可
     *
     * @param intent 用于跳转的 Intent 对象
     * @return 检查通过返回true, 检查不通过返回false
     */
    protected boolean startActivitySelfCheck(Intent intent) {
        // 默认检查通过
        boolean result = true;
        // 标记对象
        String tag;
        if (intent.getComponent() != null) { // 显式跳转
            tag = intent.getComponent().getClassName();
        } else if (intent.getAction() != null) { // 隐式跳转
            tag = intent.getAction();
        } else {
            return result;
        }

        if (tag.equals(mActivityJumpTag) && mActivityJumpTime >= SystemClock.uptimeMillis() - 500) {
            // 检查不通过
            result = false;
        }

        // 记录启动标记和时间
        mActivityJumpTag = tag;
        mActivityJumpTime = SystemClock.uptimeMillis();
        return result;
    }
}
