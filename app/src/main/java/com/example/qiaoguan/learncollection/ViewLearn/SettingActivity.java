package com.example.qiaoguan.learncollection.ViewLearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.qiaoguan.learncollection.R;

/**
 * Created by qiaoguan on 2018/3/17.
 */

public class SettingActivity extends AppCompatActivity {

    private ViewGroup nameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_setting_layout);
        nameLayout = findViewById(R.id.ds_nick_name_layout);
        nameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"1234",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
