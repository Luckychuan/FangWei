package com.example.luckychuan.fangwei;

/**
 * Created by Luckychuan on 2017/11/3.
 */

public interface RequestModel {

    interface Callback<T>{
        void onSuccess(T data);
        void onError(String error);
    }

    void requestData(String code , Callback<FangWeiBean> callback);

    void requestAllData(String code , Callback<FangWeiBean> callback);


}
