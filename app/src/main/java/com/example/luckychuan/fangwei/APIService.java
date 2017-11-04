package com.example.luckychuan.fangwei;



import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Luckychuan on 2017/11/3.
 */

public interface APIService {

    @GET("Check.aspx?cmd=check&")
    Observable<FangWeiBean> getData(@Query("code") String code);

}
