package com.company.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.company.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainContract.View {

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}