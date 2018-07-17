package com.example.admin.hxe.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.hxe.R;
import com.example.admin.hxe.view.adapter.Vpadapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

   private int []imageview;
    private boolean mIsScrolled ;
    private List<View> list;

    @BindView(R.id.vp)
    ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageview=new int[]{R.mipmap.one,R.mipmap.two,R.mipmap.three,};
        list= new ArrayList<>();
    for (int i=0;i<imageview.length;i++){
        ImageView ima = new ImageView(this);
        ima.setBackgroundResource(imageview[i]);
        list.add(ima);
        }
    vp.setAdapter(new Vpadapter(this,list));

    vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
        }
        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
              case ViewPager.SCROLL_STATE_DRAGGING:

               mIsScrolled = false;

                    break;

              case ViewPager.SCROLL_STATE_SETTLING:
             mIsScrolled = true;
      break;

       case ViewPager.SCROLL_STATE_IDLE:
        if (vp.getCurrentItem() == vp.getAdapter().getCount() - 1 &&!mIsScrolled) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);

        }

         mIsScrolled = true;

break;

            }
        }
    });




    }


}
