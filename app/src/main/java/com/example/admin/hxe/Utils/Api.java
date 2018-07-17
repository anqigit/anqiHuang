package com.example.admin.hxe.Utils;


import com.example.admin.hxe.model.Bean.LognBean;
import com.example.admin.hxe.model.Bean.RgisterBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;


/**
 * author:anqi    Q 1677564461 2018-7-11.
 */
public interface Api{

         @POST("user/login")//登录
         Observable<LognBean> Loginpost(@QueryMap Map<String,String> map);

         @POST("user/reg")//登录
         Observable<RgisterBean> regpost(@QueryMap Map<String,String> map);

}
