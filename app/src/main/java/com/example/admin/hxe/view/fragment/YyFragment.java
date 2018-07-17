package com.example.admin.hxe.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.hxe.R;
import com.example.admin.hxe.view.activity.Gerenziliao;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author:anqi    Q 1677564461 2018-7-7.
 */
public class YyFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.grzl)
    ImageView grzl;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my,container,false);
        ButterKnife.bind(this,view);
        grzl.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.grzl:
                Intent intent = new Intent(getActivity(),Gerenziliao.class);
                startActivity(intent);
                break;
        }
    }
}
