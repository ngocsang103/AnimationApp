package com.ns.animationapp.activtity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ns.animationapp.R;
import com.ns.mylibrary.ChangeText;
import com.ns.mylibrary.TransitionManager;

/**
 * Created by sangbn on 17/10/2017.
 */

public class ChangeTextSample extends Fragment {
    public static final String TEXT_1 = "Hi, i am text. Tap on me!";
    public static final String TEXT_2 = "Thanks! Another tap?";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        final ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.transitions_container);
        final TextView txtText = (TextView) view.findViewById(R.id.txtText);
        txtText.setText(TEXT_1);
        txtText.setOnClickListener(new View.OnClickListener() {
            boolean flag;
            @Override
            public void onClick(View v) {
                flag = !flag;
                TransitionManager.beginDelayedTransition(viewGroup,
                        new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN));
                txtText.setText(flag ? TEXT_2 : TEXT_1);
            }
        });
        return view;
    }
}

