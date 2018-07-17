package com.example.admin.hxe.view.activity;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.admin.hxe.R;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.EasyPermissions;

/*
    点击头像底部弹出popwindow
    获取系统相机进行拍照进行裁剪 创建一个新的文件将图片保存，将头像设置给头像，并上传
    获取系统相册进行选择，进行裁剪，设置给头像，并上传
/
*/
public class Gerenziliao extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{


     @BindView(R.id.tx)
     ImageView tx;
     private PopupWindow pop;
    public static final int TAKE_PHOTO = 111;
    private ImageView mImageView;
    private String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "mms";
    private File photo_file = new File(path);
    private String photoPath;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_gerenziliao);
         ButterKnife.bind(this);

         tx.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 showpopwindow();
             }


         });

     }


     private void showpopwindow() {
         View parent = ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
         View inflate = View.inflate(this, R.layout.popwindow, null);

         Button camera = (Button) inflate.findViewById(R.id.camera);
         Button sj = (Button) inflate.findViewById(R.id.sj);
         Button cancel = (Button) inflate.findViewById(R.id.cancel);
         LinearLayout a = inflate.findViewById(R.id.a);
         pop = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
         pop.setAnimationStyle(R.style.Popupwindow);
         pop.setFocusable(true);
         pop.setOutsideTouchable(true);// 设置允许在外点击消失

         View.OnClickListener listener = new View.OnClickListener() {

             @Override
             public void onClick(View view) {
                 switch (view.getId()) {
                     case R.id.a:
                             pop.dismiss();
                         break;
                     case R.id.camera://拍照储存并显示
                         camera();
                         break;
                     case R.id.sj://调取系统相册
                         sj();
                         break;
                 }
                 pop.dismiss();
             }


         };
         camera.setOnClickListener(listener);
         sj.setOnClickListener(listener);
         cancel.setOnClickListener(listener);
         a.setOnClickListener(listener);
         pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
             @Override
             public void onDismiss() {
                 pop.dismiss();
             }
         });

         pop.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

     }


     private void camera() {//动态运行权限
         String[] perms = {Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS};
         if(EasyPermissions.hasPermissions(this,perms)){

         }else{
             EasyPermissions.requestPermissions(this,"必要的权限", 0, perms);
         }


     }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }





    private void sj() {//选取照片的方法

     }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }
}




