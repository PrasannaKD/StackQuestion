package com.test.stack.home.feed;

import com.test.stack.base.MvpPresenter;
import com.test.stack.base.MvpView;
import com.test.stack.home.adapter.QuestionsAdapterRowDataSet;
/**
 * interface between feedsfragment and implementor class
 */
public interface FeedViewPresenter<V extends MvpView> extends MvpPresenter<V> {
    void init(QuestionsAdapterRowDataSet dataset, String filterType);

    void loadQuestions();

    void loadNextPage();

    void cleanUp();
}
