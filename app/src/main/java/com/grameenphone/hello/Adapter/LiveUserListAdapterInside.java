package com.grameenphone.hello.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.grameenphone.hello.R;
import com.pchmn.materialchips.model.Chip;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;


public class LiveUserListAdapterInside extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Integer> users;
    private LayoutInflater inflater;
    private RequestManager glideRequest;
    private final static int FADE_DURATION = 1000 ;// in milliseconds
    public LiveUserListAdapterInside(Context context, ArrayList<Integer> users){
        this.context = context;
        this.users = users;

    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.from(context).inflate(R.layout.item_friend_for_live_screen, parent, false);
        final FriendViewHolder holder = new FriendViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final FriendViewHolder itemHolder = (FriendViewHolder) holder;
        final Integer current = users.get(position);
        Glide.with(itemHolder.friendImageView.getContext()).load(R.drawable.laila).bitmapTransform(new CropCircleTransformation(context))
                .placeholder(R.drawable.hello1)
                .into(itemHolder.friendImageView);

        setFadeAnimation(itemHolder.friendImageView);
        itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }




    private class FriendViewHolder extends RecyclerView.ViewHolder {

    private ImageView friendImageView;
        private TextView text;
        private FriendViewHolder(View v) {
            super(v);

            friendImageView = (ImageView) itemView.findViewById(R.id.iconlivee);

        }
    }
    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

}
