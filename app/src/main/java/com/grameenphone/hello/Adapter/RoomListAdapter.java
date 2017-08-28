package com.grameenphone.hello.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.grameenphone.hello.Model.Chat;
import com.grameenphone.hello.Model.ChatRoom;
import com.grameenphone.hello.Model.Message;
import com.grameenphone.hello.R;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;


public class RoomListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context context;
    private ArrayList<Message> rooms=new ArrayList<Message>();
    private ArrayList<Message> allrooms=new ArrayList<Message>();
    private ArrayList<Message> filteredList=new ArrayList<Message>();

    private LayoutInflater inflater;



    public RoomListAdapter(Context context, ArrayList<Message> rooms){
        this.context = context;
        allrooms=rooms;
        this.rooms = rooms;

    }

    public void clear() {
        int size = rooms.size();
        rooms.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.from(context).inflate(R.layout.item_friend, parent, false);
        final ChatRoomHolder holder = new ChatRoomHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final ChatRoomHolder itemHolder = (ChatRoomHolder) holder;
        final Message current = rooms.get(position);


        itemHolder.nameTextView.setText(current.getCaption());

       /* Chat lastMessage = current.getLastChat();

        if (lastMessage != null) {


            String Message = lastMessage.getMessage();
            if (Message.matches("[0-9]+") && Message.length() > 5) {
                itemHolder.message.setText("স্টিকার পাঠানো হয়েছে");
            } else if (Message.equals("Image")) {
                itemHolder.message.setText("ছবি পাঠানো হয়েছে");
            } else {
                itemHolder.message.setText(lastMessage.getMessage());
            }

            itemHolder.nameTextView.setTextColor(context.getResources().getColor(R.color.seen_message_color));
            itemHolder.message.setTextColor(context.getResources().getColor(R.color.seen_message_color));
            itemHolder.timeStamp.setTextColor(context.getResources().getColor(R.color.seen_message_color));

            // itemHolder.timeStamp.setText(DateTimeUtility.getFormattedTimeFromTimestamp(lastMessage.getTimestamp()));


/*
            if(!lastMessage.getSenderUid().equals(me.getUid())){
                if(lastMessage.getReadStatus()==1)
                {
                    current.setUnreadMessageCount("0");
                    itemHolder.deliveryStatus.setVisibility(View.VISIBLE);
                    itemHolder.deliveryStatus.setImageDrawable(context.getResources().getDrawable(R.drawable.seen_status));
                    itemHolder.unReadMessageCount.setVisibility(View.INVISIBLE);
                    itemHolder.message.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    itemHolder.nameTextView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                else {
                    itemHolder.deliveryStatus.setVisibility(View.INVISIBLE);

                    if (current.getUnreadMessageCount() != null && !current.getUnreadMessageCount().equals("0")) {
                        itemHolder.unReadMessageCount.setText(current.getUnreadMessageCount());
                        itemHolder.unReadMessageCount.setVisibility(View.INVISIBLE);


                        itemHolder.message.setTextColor(context.getResources().getColor(R.color.unseen_message_color));
                        itemHolder.nameTextView.setTextColor(context.getResources().getColor(R.color.unseen_message_color));

                        itemHolder.message.setTypeface(Typeface.DEFAULT_BOLD);
                        itemHolder.nameTextView.setTypeface(Typeface.DEFAULT_BOLD);

                    } else {
                        itemHolder.unReadMessageCount.setVisibility(View.INVISIBLE);
                        itemHolder.message.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                        itemHolder.nameTextView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    }

                }

            } else {
                if(lastMessage.getReadStatus()==0){
                    itemHolder.deliveryStatus.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_delivered));
                } else {
                    itemHolder.deliveryStatus.setImageDrawable(context.getResources().getDrawable(R.drawable.seen_status));
                }

                itemHolder.deliveryStatus.setVisibility(View.VISIBLE);
                itemHolder.unReadMessageCount.setVisibility(View.INVISIBLE);
            }








        } else {


            String lilname=current.getName().trim().split("\\s+")[0];
            itemHolder.message.setText(lilname+ "-কে হ্যালো বলুন");
            itemHolder.message.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            itemHolder.nameTextView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            itemHolder.message.setTextColor(context.getResources().getColor(R.color.seen_message_color));
            itemHolder.timeStamp.setText("");
            itemHolder.nameTextView.setTextColor(context.getResources().getColor(R.color.seen_message_color));
            itemHolder.deliveryStatus.setVisibility(View.GONE);
            itemHolder.unReadMessageCount.setVisibility(View.GONE);

        }

*/


            if (current.getPhoto() != null) {
String r="http://snovadoma.ru/media/photos/04f631d079c2171827cae83e2ee61c52.jpg";
                Glide.with(itemHolder.roomImage.getContext()).load(r).bitmapTransform(new CropCircleTransformation(context))
                        .placeholder(R.drawable.hello1)

                        .into(itemHolder.roomImage);
              /*  Glide.with(itemHolder.roomImage.getContext())
                        .load(current.getPhoto().toString().trim())
                        .placeholder(R.drawable.ic_accept)
                        .error(R.drawable.ic_user_pic_02)
                        .into(itemHolder.roomImage);*/
            } else {
                itemHolder.roomImage.setImageDrawable(ContextCompat.getDrawable(context,
                        R.drawable.hello1));
            }


            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

             /*   if(current.getType().equals("p2p")) {
                    ((MainActivityHolder)context).StartP2p(current.getRoomId(), current.getName());
                } else {
                    ((MainActivityHolder)context).startGroupChat(current.getRoomId(), current.getName());
                }*/


                }
            });

        }


    @Override
    public int getItemCount() {
        return rooms.size();
    }


    //return the filter class object






    private class ChatRoomHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView message;
        private TextView unReadMessageCount;
        private TextView timeStamp;
        private ImageView roomImage;
        private ImageView deliveryStatus;

        private ChatRoomHolder(View v) {
            super(v);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            message = (TextView) itemView.findViewById(R.id.un_read_messaage);
            unReadMessageCount = (TextView) itemView.findViewById(R.id.un_read_message_count);
            timeStamp = (TextView) itemView.findViewById(R.id.time_stamp_un_read_message);
            roomImage = (ImageView) itemView.findViewById(R.id.friendImageView);


            deliveryStatus = (ImageView) itemView.findViewById(R.id.delivery_status);
            deliveryStatus.setVisibility(View.GONE);
        }
    }


    public void refresh(){
        //manipulate list
        notifyDataSetChanged();

    }
    public int refreshfromswipe(){
        //manipulate list
        notifyDataSetChanged();
        return 1;
    }

}
