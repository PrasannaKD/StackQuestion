package com.test.stack.common;


import com.test.stack.base.BasePresenter;
import com.test.stack.data.api.StackExchangeApi;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class CommonPresenterImpl<V extends CommonView> extends BasePresenter<V> implements CommonPresenter<V> {

    private StackExchangeApi api;
    private CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    CommonPresenterImpl(StackExchangeApi api) {
        this.api = api;
    }

    @Override
    public void init() {

    }

    @Override
    public void cleanUp() {
        disposables.clear();
    }

}
