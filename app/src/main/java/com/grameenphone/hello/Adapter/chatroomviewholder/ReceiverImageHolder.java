package com.grameenphone.hello.Adapter.chatroomviewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.grameenphone.hello.R;


public class ReceiverImageHolder extends RecyclerView.ViewHolder {

    public ImageView circleImageView;
    public ImageView imageFileView;
    public TextView timestamp;

    public ReceiverImageHolder(View itemView) {
        super(itemView);
        circleImageView = (ImageView) itemView.findViewById(R.id.receiversImage);
        imageFileView = (ImageView) itemView.findViewById(R.id.receivers_image_view);
        timestamp = (TextView) itemView.findViewById(R.id.receiversName);
    }

    public ImageView getCircleImageView() {
        return circleImageView;
    }

    public void setCircleImageView(ImageView circleImageView) {
        this.circleImageView = circleImageView;
    }

    public ImageView getReceiversMessage() {
        return imageFileView;
    }

    public void setReceiversMessage(ImageView receiversMessage) {
        this.imageFileView = receiversMessage;
    }

    public TextView getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(TextView timestamp) {
        this.timestamp = timestamp;
    }

}
