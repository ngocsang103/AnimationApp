package com.ns.animationapp.activtity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;

import com.ns.animationapp.R;

/**
 * Created by sangbn on 16/10/2017.
 */

public class InterpolatorDurationStartDelaySample extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interpolator, container, false);
        final ViewGroup vgContainer = (ViewGroup) view.findViewById(R.id.transitions_container);
        final Button btnButton = (Button) vgContainer.findViewById(R.id.btnButton);
        btnButton.setOnClickListener(new View.OnClickListener() {
            boolean mToRightAnimation = false;
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                mToRightAnimation = !mToRightAnimation;
                Transition transition = new ChangeBounds();
                transition.setDuration(mToRightAnimation ? 1000 : 300);
                transition.setInterpolator(mToRightAnimation ? new FastOutSlowInInterpolator() : new AccelerateInterpolator());
                transition.setStartDelay(mToRightAnimation ? 0 : 500);
                TransitionManager.beginDelayedTransition(vgContainer, transition);

                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) btnButton.getLayoutParams();
                params.gravity = mToRightAnimation ? (Gravity.RIGHT | Gravity.BOTTOM) : (Gravity.TOP | Gravity.LEFT);
                btnButton.setLayoutParams(params);
            }
        });
        return view;
    }
}
