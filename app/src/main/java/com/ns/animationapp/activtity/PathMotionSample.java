package com.ns.animationapp.activtity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.ns.animationapp.R;

import com.ns.mylibrary.ArcMotion;
import com.ns.mylibrary.ChangeBounds;
import com.ns.mylibrary.TransitionManager;

/**
 * Created by sangbn on 16/10/2017.
 */

public class PathMotionSample extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_pathmotion, container, false);
        final ViewGroup vgContainer = (ViewGroup) view.findViewById(R.id.transitions_container);
        final Button btnButon = (Button) view.findViewById(R.id.btnButton);
        btnButon.setOnClickListener(new View.OnClickListener() {
            boolean mToRightAnimation;
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
//                Transition transition = new ChangeBounds();
//                transition.setPathMotion(new ArcMotion());
//                transition.setDuration(500);
//                TransitionManager.beginDelayedTransition(vgContainer,transition);
                TransitionManager.beginDelayedTransition(vgContainer,
                        new ChangeBounds().setPathMotion(new ArcMotion()).setDuration(500));

                mToRightAnimation = !mToRightAnimation;
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) btnButon.getLayoutParams();
                params.gravity = mToRightAnimation ? (Gravity.RIGHT | Gravity.BOTTOM) :
                        (Gravity.LEFT | Gravity.TOP);
                btnButon.setLayoutParams(params);
            }
        });
        return  view;
    }
}
