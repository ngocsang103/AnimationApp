package com.ns.animationapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ns.animationapp.R;
import com.ns.animationapp.widget.ListFragment;

/**
 * Created by sangbn on 16/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ListFragment.SampleProviderList sampleProviderList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerAdapter(ListFragment.SampleProviderList sampleProviderList) {
        this.sampleProviderList = sampleProviderList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name =sampleProviderList.getTitleSample(position);
        holder.tvShowText.setText(name);
        holder.tvShowText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleProviderList.selectedSample(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sampleProviderList == null ? 0 : sampleProviderList.getSampleCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvShowText;

        public ViewHolder(View itemView) {
            super(itemView);
            tvShowText = (TextView) itemView.findViewById(R.id.tvShowText);
        }
    }
}
