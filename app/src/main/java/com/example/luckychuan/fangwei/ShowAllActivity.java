package com.example.luckychuan.fangwei;

/**
 * Created by Luckychuan on 2017/11/4.
 */

public class ShowAllActivity extends ResultActivity implements MainView{

    private RequestPresenter mPresenter;

    @Override
    public void loadData(String code) {
        mPresenter = new RequestPresenter(this);
        mPresenter.attach(this);
        mPresenter.requestAllData(code);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
