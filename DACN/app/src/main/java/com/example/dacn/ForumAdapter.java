package com.example.dacn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.MyViewHolder> {

    private List<Forum> forumList;
    public ForumAdapter(List<Forum> forumList){
        this.forumList = forumList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forum_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumAdapter.MyViewHolder holder, int position) {
        Forum forum = forumList.get(position);
        holder.tvforumTitle.setText(forum.getForumTitle());
        holder.tvforumContent.setText(forum.getForumContent());
        holder.imgbtnLike.setImageResource(forum.getIDimgbtnForumLike());
        holder.imgbtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgbtnLike.setVisibility(View.VISIBLE);
            }
        });
        holder.tvforumLike.setText(forum.getForumLike());
        holder.imgbtnComment.setImageResource(forum.getIDimgbtnForumComment());
        holder.tvforumComment.setText(forum.getForumComment());
        holder.imgbtnShare.setImageResource(forum.getIDimgbtnForumShare());
        holder.tvforumShare.setText(forum.getForumShare());
    }

    @Override
    public int getItemCount() {
        return forumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvforumTitle;
        private TextView tvforumContent;
        private TextView tvforumLike;
        private TextView tvforumComment;
        private TextView tvforumShare;
        private ImageButton imgbtnLike;
        private ImageButton imgbtnComment;
        private ImageButton imgbtnShare;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvforumTitle = itemView.findViewById(R.id.itemtv_forumtitle);
            tvforumContent = itemView.findViewById(R.id.itemtv_forumcontent);
            tvforumLike = itemView.findViewById(R.id.itemtv_forumlike);
            tvforumComment = itemView.findViewById(R.id.itemtv_forumcmt);
            tvforumShare = itemView.findViewById(R.id.itemtv_forumshare);
            imgbtnLike = itemView.findViewById(R.id.itemimgbtn_forumlike);
            imgbtnComment = itemView.findViewById(R.id.itemimgbtn_forumcmt);
            imgbtnShare = itemView.findViewById(R.id.itemimgbtn_forumshare);
        }
    }
}
