package com.ns.animationapp.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ns.animationapp.R;
import com.ns.animationapp.adapter.RecyclerAdapter;

/**
 * Created by sangbn on 16/10/2017.
 */

public class ListFragment extends Fragment {
    SampleProviderList sampleProviderList;
    RecyclerView.Adapter myAdapter;

    public void setSampleProviderList(SampleProviderList sampleProviderList){
        this.sampleProviderList = sampleProviderList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView view = (RecyclerView) inflater.inflate(R.layout.flag_list, container, false);
        view.setLayoutManager(new LinearLayoutManager(container.getContext()));
        myAdapter = new RecyclerAdapter(sampleProviderList);
        view.setAdapter(myAdapter);
        return  view;
    }

    public interface SampleProviderList{
        void selectedSample(int index);
        String getTitleSample(int index);
        int getSampleCount();

    }
}
