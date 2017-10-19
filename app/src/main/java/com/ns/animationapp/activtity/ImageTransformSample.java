package com.ns.animationapp.activtity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ns.animationapp.R;
import com.ns.mylibrary.ChangeBounds;
import com.ns.mylibrary.ChangeImageTransform;
import com.ns.mylibrary.TransitionManager;
import com.ns.mylibrary.TransitionSet;

/**
 * Created by sangbn on 16/10/2017.
 */

public class ImageTransformSample extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        final ViewGroup transitionsContainer = (ViewGroup) view.findViewById(R.id.transitions_container);
        final ImageView imageView = (ImageView) transitionsContainer.findViewById(R.id.imImage);

        imageView.setOnClickListener(new View.OnClickListener() {

            boolean mExpanded;

            @Override
            public void onClick(View v) {
                mExpanded = !mExpanded;

                TransitionManager.beginDelayedTransition(transitionsContainer, new TransitionSet()
                        .addTransition(new ChangeBounds())
                        .addTransition(new ChangeImageTransform()));
                int width = (int) getResources().getDimension(R.dimen.chart_width);
                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.height = mExpanded ? ViewGroup.LayoutParams.MATCH_PARENT : width;
                imageView.setLayoutParams(params);

                imageView.setScaleType(mExpanded ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_CENTER);
            }
        });

        return view;
    }
}
