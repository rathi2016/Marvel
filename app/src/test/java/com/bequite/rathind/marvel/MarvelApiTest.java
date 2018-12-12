package com.bequite.rathind.marvel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import retrofit2.Call;
import retrofit2.Callback;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)


public class MarvelApiTest {
    @InjectMocks
    private ScrollingActivity mScrollingActivity;

    @Mock
    private MarvelApi.ResultService mResultService;

    @Mock
    private Call<ResulList> mResultListCall;

    @Captor
    private ArgumentCaptor<Callback<ResulList>> mArgumentCaptorResultResponse;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDataTest() throws Exception{
        mScrollingActivity.getData();
//        Mockito.verify(mResultService).showProgressDialog(true);
        verify(mResultListCall).enqueue(mArgumentCaptorResultResponse.capture());
    }
}