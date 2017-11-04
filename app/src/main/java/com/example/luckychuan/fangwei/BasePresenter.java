package com.example.luckychuan.fangwei;

/**
 * Created by Luckychuan on 2017/11/3.
 */

public abstract class BasePresenter<T> {

    private T mView;

    public void attach(T view){
        mView =view;
    }

    public void detach(){
        mView = null;
    }

}
