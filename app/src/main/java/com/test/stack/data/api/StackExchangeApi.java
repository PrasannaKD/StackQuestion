package com.test.stack.data.api;


import com.test.stack.data.model.QuestionsResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StackExchangeApi {
    String API_V1_QUESTIONS_JSON = "/2.2/questions?";
    String SORT = "sort";
    String SITE = "site";
    String ORDER = "order";
    String PAGE = "page";
    String PAGE_SIZE = "pagesize";


    @GET(API_V1_QUESTIONS_JSON)
    Flowable<QuestionsResponse> getQuestionsFlowable(@Query(SORT) String sort, @Query(SITE) String site,
                                                     @Query(ORDER) String order, @Query(PAGE) long page,
                                                     @Query(PAGE_SIZE) long size);

}
