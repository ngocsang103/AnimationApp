package com.ns.animationapp.activtity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
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

public class SlideSample extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide, container, false);
        final ViewGroup vgContianer = (ViewGroup) view.findViewById(R.id.transitions_container);
        final TextView txtText = (TextView) view.findViewById(R.id.txtText);
        Button btnButton = (Button) view.findViewById(R.id.btnButton);
        btnButton.setOnClickListener(new VisibleToggleClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            protected void changeVisibility(boolean mVisible) {
                TransitionManager.beginDelayedTransition(vgContianer, new Slide(Gravity.RIGHT));
                txtText.setVisibility(mVisible ? View.VISIBLE : View.GONE);
            }
        });
        return view;
    }
}
