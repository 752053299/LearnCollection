package com.example.qiaoguan.learncollection.ViewLearn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.qiaoguan.learncollection.R;

/**
 * Created by qiaoguan on 2018/3/20. 自定义toobar
 */
public class SimpleToobar extends RelativeLayout {
    private TextView tvLeft;
    private TextView tvMiddle;
    private TextView tvRight;
    private RelativeLayout layout_titlebar;

    private int mBackGroundColor = Color.BLUE;
    private int mTextColor = Color.WHITE;
    private String tvLeftText = "";
    private int tvDrawableLeftId;

    public SimpleToobar(Context context) {
        super(context);
        initView(context);
    }

    public SimpleToobar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,R.styleable.SimpleToobar);
        tvLeftText = mTypedArray.getString(R.styleable.SimpleToobar_left_text);
        tvDrawableLeftId = mTypedArray.getResourceId(R.styleable.SimpleToobar_left_icon,0);
        mTypedArray.recycle();
        initView(context);
    }

    public SimpleToobar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.simple_toobar_layout,this,true);
        tvLeft = findViewById(R.id.tv_title_left);
        tvRight = findViewById(R.id.tv_title_right);
        tvMiddle = findViewById(R.id.tv_title_middle);
        layout_titlebar = findViewById(R.id.layout_titlebar_root_layout);
        mBackGroundColor = context.getResources().getColor(R.color.colorPrimary);
        mTextColor = context.getResources().getColor(R.color.common_bg);
        layout_titlebar.setBackgroundColor(mBackGroundColor);
        tvMiddle.setTextColor(mTextColor);
        setLeftIcon(tvDrawableLeftId);
        setTvLeftText(tvLeftText);
    }

    /**
     * 设置标题
     * @param titleName
     */
    public void setTitle(String titleName){
        if (!TextUtils.isEmpty(titleName)){
            tvMiddle.setText(titleName);
        }
    }

    /**
     * 设置左边图标
     * @param
     */
    public void setLeftIcon(int drawableLeftId){
        Drawable drawable = getResources().getDrawable(drawableLeftId);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        tvLeft.setCompoundDrawables(drawable,null,null,null);
        tvLeft.setCompoundDrawablePadding(10);
    }

    /**
     * 设置左边文字
     * @param text
     */
    public void setTvLeftText(String text){
        tvLeft.setText(text);
    }
}
