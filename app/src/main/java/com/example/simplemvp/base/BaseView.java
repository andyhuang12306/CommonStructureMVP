package com.example.simplemvp.base;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseView<P extends BasePresenter, CONTRACT> extends Activity {

    protected P p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p=getPresenter();
        p.bindView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.unBindView();
    }

    public abstract P getPresenter();
    public abstract CONTRACT getContract();
}
