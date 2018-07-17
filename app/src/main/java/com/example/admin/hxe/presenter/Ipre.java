package com.example.admin.hxe.presenter;

import com.example.admin.hxe.model.Bean.LognBean;
import com.example.admin.hxe.model.Bean.RgisterBean;
import com.example.admin.hxe.model.IModel.IModel;
import com.example.admin.hxe.view.IMview;

import java.util.Map;

/**
 * author:anqi    Q 1677564461 2018-7-12.
 */
public class Ipre {
      private IMview iMview;
      private IModel iModel;
      public Ipre(IMview iMview){
           this.iMview=iMview;
           iModel=new IModel();
      }

      public void Login(Map<String,String> map){
              iModel.login(map, new IModel.getcall() {
                  @Override
                  public void Login(LognBean lognBean) {
                         iMview.Login(lognBean);
                  }

                  @Override
                  public void Register(RgisterBean rgisterBean) {

                  }
              });

      }
      public void Register(Map<String,String> map){
           iModel.Register(map, new IModel.getcall() {
               @Override
               public void Login(LognBean lognBean) {

               }

               @Override
               public void Register(RgisterBean rgisterBean) {
                     iMview.Register(rgisterBean);
               }
           });
      }
}
