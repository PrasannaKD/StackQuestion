package com.test.stack.common;


import com.test.stack.base.MvpPresenter;
import com.test.stack.base.MvpView;

public interface CommonPresenter<V extends MvpView> extends MvpPresenter<V> {


    void init();

    void cleanUp();
}
