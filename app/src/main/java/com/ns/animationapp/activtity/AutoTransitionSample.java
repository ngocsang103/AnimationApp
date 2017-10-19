package com.ns.animationapp.activtity;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.transition.ArcMotion;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.PathMotion;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ns.animationapp.R;
import com.ns.animationapp.event.VisibleToggleClickListener;


/**
 * Created by sangbn on 16/10/2017.
 */
public class AutoTransitionSample extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feagment_autotrasition, container, false);
        final ViewGroup vgContainer = (ViewGroup) view.findViewById(R.id.transitions_container);
        final TextView tvText = (TextView) vgContainer.findViewById(R.id.txtText);
        final Button btnButton = (Button) vgContainer.findViewById(R.id.btnButton);
        btnButton.setOnClickListener(new VisibleToggleClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            protected void changeVisibility(boolean visible) {

                // it is the same as
                // TransitionManager.beginDelayedTransition(transitionsContainer, new AutoTransition());
                // where AutoTransition is the set of Fade and ChangeBounds transitions
               // TransitionManager.beginDelayedTransition(vgContainer);

                //seting with transition
                TransitionSet transitionSet = new TransitionSet();
                transitionSet.addTransition(new ChangeBounds());
                transitionSet.addTransition(new Fade(Fade.OUT));
                transitionSet.addTransition(new Fade(Fade.IN));
                transitionSet.setDuration(1000);
                transitionSet.setInterpolator(new FastOutSlowInInterpolator());
                transitionSet.setPathMotion(new ArcMotion());
                TransitionManager.beginDelayedTransition(vgContainer, transitionSet);
                tvText.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        return view;
    }
}
