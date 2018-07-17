package com.example.admin.hxe.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.admin.hxe.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.m)
    ImageView image;
    @BindView(R.id.dj)
    ImageView dj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        Glide.with(Main2Activity.this).load(R.mipmap.shan).into(new GlideDrawableImageViewTarget(image, 1));
           dj.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(Main2Activity.this, Login.class);
             startActivity(intent);

         }
     });
    }


}
