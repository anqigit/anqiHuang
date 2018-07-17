package com.example.admin.hxe.view;

import com.example.admin.hxe.model.Bean.LognBean;
import com.example.admin.hxe.model.Bean.RgisterBean;

/**
 * author:anqi    Q 1677564461 2018-7-12.
 */
public interface IMview {
    void Login(LognBean lognBean);//登录
    void Register(RgisterBean rgisterBean);//注册
}
