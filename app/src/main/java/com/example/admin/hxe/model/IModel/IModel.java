package com.example.admin.hxe.model.IModel;

import android.util.Log;

import com.example.admin.hxe.Utils.Api;
import com.example.admin.hxe.Utils.Ret;
import com.example.admin.hxe.model.Bean.LognBean;
import com.example.admin.hxe.model.Bean.RgisterBean;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * author:anqi    Q 1677564461 2018-7-12.
 */
public class IModel {


              public void login(Map<String,String> map, final getcall getcall){//登录
                  Retrofit retrofit = Ret.getRet().getRetrofit();
                  Observable<LognBean> loginpost = retrofit.create(Api.class).Loginpost(map);
                  loginpost.observeOn(AndroidSchedulers.mainThread())
                          .subscribeOn(Schedulers.io())
                          .subscribe(new Observer<LognBean>() {
                              @Override
                              public void onSubscribe(Disposable d) {

                              }

                              @Override
                              public void onNext(LognBean value) {
                                         getcall.Login(value);
                              }

                              @Override
                              public void onError(Throwable e) {
                                  Log.e("0","失败"+e);
                              }

                              @Override
                              public void onComplete() {
                                  Log.e("1","成功");

                              }
                          });



              }
           public void Register(Map<String,String> map, final getcall getcall){
               Retrofit retrofit = Ret.getRet().getRetrofit();

               Observable<RgisterBean> regpost = retrofit.create(Api.class).regpost(map);
               regpost.observeOn(AndroidSchedulers.mainThread())
                       .subscribeOn(Schedulers.io())
                       .subscribe(new Observer<RgisterBean>() {
                           @Override
                           public void onSubscribe(Disposable d) {

                           }

                           @Override
                           public void onNext(RgisterBean value) {
                              getcall.Register(value);
                           }

                           @Override
                           public void onError(Throwable e) {
                               Log.e("注册","失败");
                           }

                           @Override
                           public void onComplete() {
                               Log.e("注册","成功");
                           }
                       });
           }


    public  interface getcall{
        void Login(LognBean lognBean);
        void Register(RgisterBean rgisterBean);
    }

}