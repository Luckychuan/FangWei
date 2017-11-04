package com.example.luckychuan.fangwei;

/**
 * Created by Luckychuan on 2017/11/3.
 */

public class RequestPresenter extends BasePresenter {

    private MainView mView;
    private RequestModel mModel;

    public RequestPresenter(MainView view){
        mView = view;
        mModel = new RequestModelImpl();
    }

    public void requestData(String code){
        mView.showProgressBar();
        mModel.requestData(code, new RequestModel.Callback<FangWeiBean>() {
            @Override
            public void onSuccess(FangWeiBean data) {
                mView.updateUI(data);
                mView.hideProgressBar();
            }

            @Override
            public void onError(String error) {
                mView.onError(error);
            }
        });
    }

}
