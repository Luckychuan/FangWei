package com.example.luckychuan.fangwei;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Luckychuan on 2017/11/3.
 */

public class RequestModelImpl implements RequestModel {

    private Retrofit mRetrofit;

    public RequestModelImpl() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .writeTimeout(10000L, TimeUnit.MILLISECONDS)
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://www.homewyc.com/WS/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }

    @Override
    public void requestData(String code, final Callback<FangWeiBean> callback) {


        mRetrofit.create(APIService.class)
                .getData(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FangWeiBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.toString());
                    }

                    @Override
                    public void onNext(FangWeiBean fangWeiBean) {
                        callback.onSuccess(fangWeiBean);
                    }
                });

    }

    @Override
    public void requestAllData(String code, final Callback<FangWeiBean> callback) {


        mRetrofit.create(APIService.class)
                .getAllData(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FangWeiBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.toString());
                    }

                    @Override
                    public void onNext(FangWeiBean fangWeiBean) {
                        callback.onSuccess(fangWeiBean);
                    }
                });

    }

}
