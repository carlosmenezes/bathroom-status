package com.fireball.bathroomstatus;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by carlos on 11/29/14.
 */
public class BathroomAdapter extends RecyclerView.Adapter<BathroomAdapter.ViewHolder> {

    private final List<Bathroom> bathrooms;
    private final int layoutId;
    private Context context;

    public BathroomAdapter(List<Bathroom> bathrooms, int layoutId, Context context) {
        this.bathrooms = bathrooms;
        this.layoutId = layoutId;
        this.context = context;
    }
    
    @Override
    public BathroomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(layoutId, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return bathrooms == null ? 0 : bathrooms.size();
    }

    @Override
    public void onBindViewHolder(BathroomAdapter.ViewHolder viewHolder, int i) {
        Bathroom bathroom = bathrooms.get(i);

        viewHolder.bathroomNameTextView.setText(bathroom.getName());
        viewHolder.bathroomStatusTextView.setCompoundDrawablesWithIntrinsicBounds(drawableForStatus(bathroom.getStatus()), null, null, null);
        viewHolder.bathroomStatusTextView.setText(descriptionForStatus(bathroom.getStatus()));
    }

    private int descriptionForStatus(String status) {
        int result = R.string.bathroom_occupied;

        switch (status) {
            case "O": result = R.string.bathroom_occupied; break;
            case "L": result = R.string.bathroom_free; break;
            case "D": result = R.string.bathroom_destroyed; break;
        }

        return result;
    }

    private Drawable drawableForStatus(String status) {
        int result = R.drawable.bathroom_occupied;

        switch (status) {
            case "O": result = R.drawable.bathroom_occupied; break;
            case "L": result = R.drawable.bathroom_free; break;
            case "D": result = R.drawable.bathroom_destroyed; break;
        }

        return context.getResources().getDrawable(result);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView bathroomNameTextView;
        private ImageView bathroomImageView;
        private TextView bathroomStatusTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            bathroomNameTextView = (TextView) itemView.findViewById(R.id.bathroom_name_textView);
            bathroomStatusTextView = (TextView) itemView.findViewById(R.id.bathroom_status_textView);
        }
    }
}
