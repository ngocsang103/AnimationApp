package com.ns.animationapp.activtity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ns.animationapp.R;
import com.ns.mylibrary.Explode;
import com.ns.mylibrary.Fade;
import com.ns.mylibrary.Transition;
import com.ns.mylibrary.TransitionManager;
import com.ns.mylibrary.TransitionSet;

/**
 * Created by sangbn on 16/10/2017.
 */

public class ExplodeAndEpicenterExample extends Fragment {
    RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRecyclerView = new RecyclerView(container.getContext());
        mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mRecyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 4));
        mRecyclerView.setAdapter(new Adapter());
        return mRecyclerView;
    }

    private void letExplode(View clickedView) {
        // save rect of view in screen coordinated
        final Rect viewRect = new Rect();
       clickedView.getGlobalVisibleRect(viewRect);

        TransitionSet set = new TransitionSet()
                .addTransition(new Explode().setEpicenterCallback(new Transition.EpicenterCallback() {
                    @Override
                    public Rect onGetEpicenter(Transition transition) {
                        return viewRect;
                    }
                }).excludeTarget(clickedView, true))
                .addTransition(new Fade().addTarget(clickedView))
                .addListener(new Transition.TransitionListenerAdapter() {
                    @Override
                    public void onTransitionEnd(Transition transition) {
                        transition.removeListener(this);
                        getActivity().onBackPressed();
                    }
                });
        TransitionManager.beginDelayedTransition(mRecyclerView, set);

        // remove all views from Recycler View
        mRecyclerView.setAdapter(null);
    }

    public class Adapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.fragment_explode, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        letExplode(v);
                    }
                });
        }
        @Override
        public int getItemCount() {
            return 24;
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
