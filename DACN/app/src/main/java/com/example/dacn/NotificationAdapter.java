package com.example.dacn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private List<Notification> listnoti;
    public NotificationAdapter(List<Notification> listnoti){
        this.listnoti = listnoti;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.MyViewHolder holder, int position) {
        Notification noti = listnoti.get(position);
        holder.textview_Notititle.setText(noti.getTitle());
        holder.textview_Noticontent.setText(noti.getContent());
        holder.textview_Notiday.setText(noti.getDay());
    }

    @Override
    public int getItemCount() {
        return listnoti.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textview_Notititle;
        private TextView textview_Noticontent;
        private TextView textview_Notiday;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textview_Notititle = itemView.findViewById(R.id.item_tv_notititle);
            textview_Noticontent = itemView.findViewById(R.id.item_tv_noticontent);
            textview_Notiday = itemView.findViewById(R.id.item_tv_notiday);
        }
    }
}
