package com.test.stack.home.feed;

import com.test.stack.base.MvpView;
import com.test.stack.home.adapter.QuestionsAdapterRow;

import java.util.List;

/**
 * interface between implementor and feedsfragment class
 */
public interface FeedView extends MvpView {
    void onQuestionsLoaded(List<QuestionsAdapterRow> rows);
}
