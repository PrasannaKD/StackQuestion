package com.test.stack.home.feed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.stack.AppConstants;
import com.test.stack.home.adapter.QuestionsAdapter;
import com.test.stack.home.adapter.QuestionsAdapterRow;
import com.test.stack.home.adapter.QuestionsAdapterRowDataSet;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;
/**
 * Feeds Fragment with filtertype "votes".
 */
public class FeaturedFeedFragment extends FeedFragment implements FeedView {

    @Inject
    public FeaturedFeedFragment() {

    }

    @Inject
    FeedViewPresenter<FeedView> presenter;

    private String filterType = "activity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            filterType = getArguments().getString(AppConstants.ARG_FILTER_TYPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void setUpView(View view) {
        super.setUpView(view);
        Timber.d("setUpView");
        presenter.init(dataset, filterType);
        loadFeeds();
    }

    @Override
    protected void loadNextPage() {
        presenter.loadNextPage();
    }

    @Override
    protected void loadFeeds() {
        presenter.loadQuestions();
    }

    @Override
    protected void attachPresenter() {
        presenter.onAttach(this);
    }

    @Override
    protected QuestionsAdapter getAdapter() {
        return new QuestionsAdapter();
    }


    @Override
    protected QuestionsAdapterRowDataSet getAdapterDataSet(QuestionsAdapter adapter) {
        return QuestionsAdapterRowDataSet.createWithEmptyData(adapter);
    }

    @Override
    public void onQuestionsLoaded(List<QuestionsAdapterRow> rows) {
        Timber.d("onQuestionsLoaded");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.cleanUp();
        presenter.onDetach();
    }
}
