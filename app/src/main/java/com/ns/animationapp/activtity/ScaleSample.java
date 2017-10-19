package com.ns.animationapp.activtity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.ns.animationapp.R;
import com.ns.animationapp.event.VisibleToggleClickListener;
import com.ns.mylibrary.Fade;
import com.ns.mylibrary.TransitionManager;
import com.ns.mylibrary.TransitionSet;
import com.ns.mylibrary.extra.Scale;

/**
 * Created by sangbn on 16/10/2017.
 */

public class ScaleSample extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scale, container, false);
        final ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.transitions_container);
        final TextView txtText1, txtText2;
        Button btnSimple, btnFade;
        txtText1 = (TextView) viewGroup.findViewById(R.id.txtText1);
        txtText2 = (TextView) viewGroup.findViewById(R.id.txtText2);
        btnSimple = (Button) viewGroup.findViewById(R.id.btnSimple);
        btnFade = (Button) viewGroup.findViewById(R.id.btnFade);
        btnSimple.setOnClickListener(new VisibleToggleClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            protected void changeVisibility(boolean mVisible) {
                TransitionManager.beginDelayedTransition(viewGroup, new Scale());
                txtText1.setVisibility(mVisible ? View.VISIBLE : View.INVISIBLE);
            }
        });
        btnFade.setOnClickListener(new VisibleToggleClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            protected void changeVisibility(boolean mVisible) {
                TransitionSet set = new TransitionSet();
                set.addTransition(new Scale());
                set.addTransition(new Fade());
                set.setDuration(1000);
                set.setInterpolator(mVisible ? new FastOutSlowInInterpolator() : new DecelerateInterpolator());
                TransitionManager.beginDelayedTransition(viewGroup, set);
                txtText2.setVisibility(mVisible ? View.VISIBLE : View.INVISIBLE);

            }
        });
        return view;
    }
}
