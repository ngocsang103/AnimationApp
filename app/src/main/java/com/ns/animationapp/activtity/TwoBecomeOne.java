package com.ns.animationapp.activtity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.ns.animationapp.R;
import com.ns.mylibrary.TransitionManager;

/**
 * Created by sangbn on 17/10/2017.
 */

public class TwoBecomeOne extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_twobecomeone, container, false);
        final ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.transitions_container);
        final Button btnButton1 = (Button) view.findViewById(R.id.btnButton1);
        final Button btnButton2 = (Button) view.findViewById(R.id.btnButton2);
        final Button btnButton3 = (Button) view.findViewById(R.id.btnButton3);
        btnButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout.LayoutParams paramcenter = (FrameLayout.LayoutParams) btnButton1.getLayoutParams();
                FrameLayout.LayoutParams paramleft = (FrameLayout.LayoutParams) btnButton1.getLayoutParams();
                paramcenter.gravity = Gravity.CENTER_HORIZONTAL;
                btnButton1.setLayoutParams(paramcenter);
                //btnButton2.setLayoutParams(paramcenter);
                btnButton3.setVisibility(View.VISIBLE);
                TransitionManager.beginDelayedTransition(viewGroup);

                paramleft.gravity = Gravity.LEFT | Gravity.TOP;
                //btnButton1.setLayoutParams(paramleft);

            }
        });
        return view;
    }
}
