package com.example.admin.hxe.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.hxe.R;
import com.example.admin.hxe.view.fragment.MyFragment;
import com.example.admin.hxe.view.fragment.SaomaFragment;
import com.example.admin.hxe.view.fragment.YyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.my)
    ImageView my;
    @BindView(R.id.sm)
    ImageView sm;
    @BindView(R.id.yy)
   ImageView yy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);
        my.setOnClickListener(this);
        sm.setOnClickListener(this);
        yy.setOnClickListener(this);

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
        {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                switch (position){
                    case 0:
                        fragment = new MyFragment();
                        my.setImageDrawable(getResources().getDrawable(R.mipmap.my2));
                        yy.setImageDrawable(getResources().getDrawable(R.mipmap.yy));

                        break;
                    case 1:
                        fragment = new SaomaFragment();
                        my.setImageDrawable(getResources().getDrawable(R.mipmap.my));
                        yy.setImageDrawable(getResources().getDrawable(R.mipmap.yy));

                        break;
                    case 2:

                        fragment = new YyFragment();
                        my.setImageDrawable(getResources().getDrawable(R.mipmap.my));
                        yy.setImageDrawable(getResources().getDrawable(R.mipmap.yy2));

                        break;
                }
                return fragment;
            }
        };
        vp.setAdapter(fragmentPagerAdapter);
        vp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        my.setImageDrawable(getResources().getDrawable(R.mipmap.my2));
                        yy.setImageDrawable(getResources().getDrawable(R.mipmap.yy));
                        break;
                    case 1:
                        my.setImageDrawable(getResources().getDrawable(R.mipmap.my));
                        yy.setImageDrawable(getResources().getDrawable(R.mipmap.yy));
                        break;
                    case 2:
                        my.setImageDrawable(getResources().getDrawable(R.mipmap.my));
                        yy.setImageDrawable(getResources().getDrawable(R.mipmap.yy2));
                        break;
                }
                super.onPageSelected(position);
            }
        });
    }

    @Override
    public void onClick(View view) {
           switch (view.getId()){
               case R.id.my:
                    vp.setCurrentItem(0,false);
                    my.setImageDrawable(getResources().getDrawable(R.mipmap.my2));
                   yy.setImageDrawable(getResources().getDrawable(R.mipmap.yy));

                   break;
               case R.id.sm:
                   vp.setCurrentItem(1,false);
                   my.setImageDrawable(getResources().getDrawable(R.mipmap.my));
                   yy.setImageDrawable(getResources().getDrawable(R.mipmap.yy));

                   break;
               case R.id.yy:
                   vp.setCurrentItem(2,false);
                   my.setImageDrawable(getResources().getDrawable(R.mipmap.my));
                   yy.setImageDrawable(getResources().getDrawable(R.mipmap.yy2));

                   break;
           }
    }
}
