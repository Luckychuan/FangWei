package com.example.luckychuan.fangwei;

/**
 * Created by Luckychuan on 2017/11/3.
 */

public interface MainView {

    void loadData(String code);
    void showProgressBar();
    void updateUI(FangWeiBean fangWeiBean);
    void onError(String error);
    void hideProgressBar();

}
