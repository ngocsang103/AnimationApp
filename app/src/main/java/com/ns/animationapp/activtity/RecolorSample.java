package com.ns.animationapp.activtity;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ns.animationapp.R;
import com.ns.mylibrary.Recolor;
import com.ns.mylibrary.TransitionManager;

/**
 * Created by sangbn on 17/10/2017.
 */

public class RecolorSample extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        final ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.transitions_container);
        final Button btnButton = (Button) view.findViewById(R.id.btnButton);
        btnButton.setOnClickListener(new View.OnClickListener() {
            boolean mColorsInverted;
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                //TransitionManager.beginDelayedTransition(viewGroup);
                TransitionManager.beginDelayedTransition(viewGroup, new Recolor());
                mColorsInverted = !mColorsInverted;
                btnButton.setTextColor(getResources().getColor(!mColorsInverted ? R.color.second_accent : R.color.accent));
                btnButton.setBackgroundDrawable(
                        new ColorDrawable(getResources().getColor(!mColorsInverted ? R.color.accent : R.color.second_accent)));
            }
        });
        return view;
    }
}

