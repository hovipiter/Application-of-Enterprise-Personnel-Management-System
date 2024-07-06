package com.example.dacn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.MyViewHolder> {
    private List<Project> projectList;
    Context context;

    public ProjectAdapter(Context context, List<Project> projectList){
        this.projectList = projectList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.MyViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.textviewProjectTitle.setText(project.getProjecttitle());
        holder.textviewProjectProgress.setText(project.getProgress());
        holder.textviewTimeLeft.setText(project.getGetTimeleft());
        holder.textviewStartDay.setText(project.getStartday());
        holder.textviewEndDay.setText(project.getEndday());

    }
    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textviewProjectTitle;
        private TextView textviewProjectProgress;
        private TextView textviewTimeLeft;
        private TextView textviewStartDay;
        private TextView textviewEndDay;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textviewProjectTitle = itemView.findViewById(R.id.project_page_item_title);
            textviewProjectProgress = itemView.findViewById(R.id.project_page_progress_number);
            textviewTimeLeft = itemView.findViewById(R.id.project_page_item_timeleft);
            textviewStartDay = itemView.findViewById(R.id.textViewgetStartDay);
            textviewEndDay = itemView.findViewById(R.id.textViewgetEndDay);
        }
    }
}
