package com.ns.animationapp.event;

import android.view.View;

/**
 * Created by sangbn on 16/10/2017.
 */

public abstract class VisibleToggleClickListener implements View.OnClickListener {
    boolean mVisible;
    @Override
    public void onClick(View v) {
        mVisible = !mVisible;
        changeVisibility(mVisible);
    }

    protected abstract void changeVisibility(boolean mVisible);
}
