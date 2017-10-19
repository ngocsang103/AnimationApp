package com.ns.animationapp.activtity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ns.animationapp.R;
import com.ns.mylibrary.Rotate;
import com.ns.mylibrary.TransitionManager;

/**
 * Created by sangbn on 17/10/2017.
 */

public class RotateSample extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rotate, container, false);
        final ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.transitions_container);
        final ImageView imIcon = (ImageView) view.findViewById(R.id.imIcon);
        imIcon.setOnClickListener(new View.OnClickListener() {
            boolean flag ;
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                flag = !flag;
                TransitionManager.beginDelayedTransition(viewGroup, new Rotate());
                imIcon.setRotation(flag ? 270 : 0);

            }
        });
        return  view;

    }
}
