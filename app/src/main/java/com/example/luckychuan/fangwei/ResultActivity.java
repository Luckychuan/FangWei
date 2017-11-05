package com.example.luckychuan.fangwei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ResultActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "ResultActivity";
    private RequestPresenter mPresenter;
    private String mCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mCode = getIntent().getStringExtra("code");
        loadData(mCode);


    }

    @Override
    public void loadData(String code) {
        mPresenter = new RequestPresenter(this);
        mPresenter.attach(this);
        mPresenter.requestData(code);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void updateUI(FangWeiBean fangWeiBean) {
        WebView webView = (WebView) findViewById(R.id.web_view);
        //初始化WebView
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(false);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        ImageView resultImage = (ImageView) findViewById(R.id.result_image);

        if(fangWeiBean.isSuccess()){

            Glide.with(this)
                    .load(fangWeiBean.getData().getResultImg())
                    .placeholder(R.color.white)
                    .error(R.color.white)
                    .into(resultImage);

            webView.loadData(fangWeiBean.getData().getResultHTML(), "text/html; charset=UTF-8", null);

            Log.d(TAG, "updateUI: "+fangWeiBean.getData().getResultMsgID());
            if(fangWeiBean.getData().getResultMsgID() == 222){
                Button button = (Button) findViewById(R.id.show_all_button);
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ResultActivity.this,ShowAllActivity.class);
                        intent.putExtra("code",mCode);
                        startActivity(intent);
                    }
                });
            }

        }else{

        }

    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.detach();
        }
    }
}
