package com.test.stack.common;


import com.test.stack.base.MvpView;
import com.test.stack.data.model.Owner;

public interface CommonView extends MvpView {
    void showUser(Owner owner);

    void onLoggedOut();
}
