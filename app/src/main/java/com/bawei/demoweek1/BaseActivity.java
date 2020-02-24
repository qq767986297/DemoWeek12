package com.bawei.demoweek1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract   class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoult());
        initView();
        getData();
    }

    protected abstract int getLayoult();
    protected abstract void initView();
    protected abstract void getData();
}
