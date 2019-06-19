package com.example.simplemvp.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter <M extends BaseModel, V extends BaseView, CONTRACT> {

    protected M m;
    public WeakReference<V> weakReference;

    public BasePresenter(){
        m=getModel();
    }


    public void bindView(V v){
        weakReference=new WeakReference<>(v);
    }

    public V getView(){
        if(weakReference!=null){
            return weakReference.get();
        }
        return null;
    }


    public abstract CONTRACT getContract();
    public abstract M getModel();

    public void unBindView(){
        if(weakReference!=null){
            weakReference.clear();
            weakReference=null;
            System.gc();
        }
    }
}
