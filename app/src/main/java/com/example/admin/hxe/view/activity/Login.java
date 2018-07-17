
package com.example.admin.hxe.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.hxe.R;
import com.example.admin.hxe.model.Bean.LognBean;
import com.example.admin.hxe.model.Bean.RgisterBean;
import com.example.admin.hxe.presenter.Ipre;
import com.example.admin.hxe.view.IMview;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


/*
    页面思路 输入手机号 获取验证码；点击登录。
    点击常规登录方式    跳转到常规登录页面。
    第三方登录
/
 */


public class Login extends AppCompatActivity implements IMview,View.OnClickListener {

    @BindView(R.id.text_sj)
    TextView text_sj;//输入的手机号
    @BindView(R.id.text_dx)
    TextView text_dx;//短信验证码
    @BindView(R.id.dx)
    ImageView dx;//获取短信按钮
    @BindView(R.id.DL)
    ImageView DL;//登录按钮
    @BindView(R.id.cg)
    TextView cg;//常规登录方式
    @BindView(R.id.wx)
    ImageView wx;//微信登录
    @BindView(R.id.qq)
    ImageView qq;//QQ登录
   @BindView(R.id.dxyz)
   RelativeLayout dxyz;
   @BindView(R.id.mima)
   RelativeLayout mima;
   @BindView(R.id.text_mm)
   TextView mm;
   @BindView(R.id.yz)
   TextView yz;
   @BindView(R.id.daojishi)
   ImageView daojishi;
   @BindView(R.id.s)
   TextView s;
   @BindView(R.id.cx)
   ImageView cx;
   private Map<String,String> map=new HashMap<>();
   private int text_s=30;
   private int text_s2=30;

    private EventHandler eventHandler;
    private SharedPreferences sharedPreferences;
   private Handler handler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
         if(msg.what==1){
               text_s--;
               s.setText(text_s+"S");
               if(text_s > 0){
                   Message message = handler.obtainMessage(1);
                   handler.sendMessageDelayed(message, 1000);      // send message
               }else{
                   s.setVisibility(View.GONE);
                   daojishi.setVisibility(View.GONE);
                   cx.setVisibility(View.VISIBLE);

               }

           }
           if(msg.what==2){

               text_s2--;
               s.setText(text_s2+"S");
               if(text_s2 > 0){
                   Message message2 = handler.obtainMessage(2);
                   handler.sendMessageDelayed(message2, 1000);      // send message
               }else{
                   s.setVisibility(View.GONE);
                   daojishi.setVisibility(View.GONE);
                   cx.setVisibility(View.VISIBLE);
                   text_s2=30;
               }

           }
       }
   };

    private Ipre ipre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("a", MODE_PRIVATE);
        ButterKnife.bind(this);
        ipre = new Ipre(this);



        mima.setVisibility(View.GONE);
        yz.setVisibility(View.GONE);
        daojishi.setVisibility(View.GONE);
        s.setVisibility(View.GONE);
       cx.setVisibility(View.GONE);
        dianji();
       }

    private void dianji() {
        dx.setOnClickListener(this);
        DL.setOnClickListener(this);
        cg.setOnClickListener(this);
        wx.setOnClickListener(this);
        qq.setOnClickListener(this);
        yz.setOnClickListener(this);
        cx.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dx:
                dx.setVisibility(View.GONE);
                daojishi.setVisibility(View.VISIBLE);
                s.setVisibility(View.VISIBLE);
                //倒计时功能
                // Message
                SMSSDK.getVerificationCode("86",text_sj.getText().toString());
                Message  message = handler.obtainMessage(1);

                handler.sendMessageDelayed(message, 1000);

                break;
            case R.id.cx:
                s.setText(30+"S");
                cx.setVisibility(View.GONE);
                daojishi.setVisibility(View.VISIBLE);
                s.setVisibility(View.VISIBLE);

                SMSSDK.getVerificationCode("86",text_sj.getText().toString());

                Message  message2 = handler.obtainMessage(2);

                handler.sendMessageDelayed(message2, 1000);

                break;

            case  R.id.DL://点击登录按钮

               if(text_sj.length()>0){
                   if(mm.length()>0){
                       map.put("mobile",""+text_sj.getText());
                       map.put("password",""+mm.getText());
                       ipre.Login(map);
                   }else{
                       SMSSDK.submitVerificationCode("86",text_sj.getText().toString(), text_dx.getText().toString());
                    init();
                   }
               } else{
                   if(text_sj.length()==0){
                       Toast.makeText(this, "请输入手机号", Toast.LENGTH_LONG).show();
                   }


                }


                break;


            case R.id.cg:
                dxyz.setVisibility(View.GONE);
                cg.setVisibility(View.GONE);
                mima.setVisibility(View.VISIBLE);
                 yz.setVisibility(View.VISIBLE);
               break;
            case R.id.yz:
                dxyz.setVisibility(View.VISIBLE);
                cg.setVisibility(View.VISIBLE);
                mima.setVisibility(View.GONE);
                yz.setVisibility(View.GONE);

                break;

            case R.id.wx:

                break;

            case R.id.qq:

                break;



        }
    }

    public  void init(){
        eventHandler=new EventHandler(){
            @Override
            public void afterEvent(int event, int resut, Object data) {
                super.afterEvent(event, resut, data);
                if(resut==SMSSDK.RESULT_COMPLETE){
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) { //提交验证码成功
                        startActivity(new Intent(Login.this, FragmentActivity.class)); //页面跳转
                    }
                    }else{
                    Toast.makeText(Login.this,"验证码提交错误",Toast.LENGTH_LONG).show();
                }
            }

        };
        SMSSDK.registerEventHandler(eventHandler);
    }


    @Override
    public void Login(LognBean lognBean) {
         if(lognBean.getCode().equals("0")){//当登录成功的时候返回码为0
               Intent intent = new Intent(this, FragmentActivity.class);
               startActivity(intent);
             Login.this.finish();
         }else{
             Toast.makeText(this, ""+lognBean.getMsg(), Toast.LENGTH_LONG).show();
         }
    }

    @Override
    public void Register(RgisterBean rgisterBean) {

    }
}
