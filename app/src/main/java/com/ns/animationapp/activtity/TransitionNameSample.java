package com.ns.animationapp.activtity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ns.animationapp.R;
import com.ns.mylibrary.ChangeBounds;
import com.ns.mylibrary.TransitionManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sangbn on 16/10/2017.
 */

public class TransitionNameSample extends Fragment {
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);
        final ViewGroup layout = (ViewGroup) view.findViewById(R.id.transitions_container);
        final Button button = (Button) view.findViewById(R.id.btnButton);

        final List<String> titles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            titles.add(String.format("Item %d", i + 1));
        }

        createViews(inflater, layout, titles);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(layout, new ChangeBounds());
                Collections.shuffle(titles);
                createViews(inflater, layout, titles);
            }

        });

        return view;
    }

    private void createViews(LayoutInflater inflater, ViewGroup layout, List<String> titles) {
        layout.removeAllViews();
        for (String title : titles) {
            TextView textView = (TextView) inflater.inflate(R.layout.fragment_names_item, layout, false);
            textView.setText(title);
            TransitionManager.setTransitionName(textView, title);
            layout.addView(textView);
        }
    }
}
