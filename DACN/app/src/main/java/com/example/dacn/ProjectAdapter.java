package com.example.dacn;

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

    public ProjectAdapter(List<Project> projectList){
        this.projectList = projectList;
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
        holder.textviewProjectContent.setText(project.getProjectcontent());
        holder.textviewTimeLeft.setText(project.getTextviewTimeleft());
        holder.textviewGetTimeLeft.setText(project.getGetTimeleft());


    }
    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textviewProjectTitle;
        private TextView textviewProjectContent;
        private TextView textviewTimeLeft;
        private TextView textviewGetTimeLeft;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textviewProjectTitle = itemView.findViewById(R.id.project_page_item_title);
            textviewProjectContent = itemView.findViewById(R.id.project_page_item_content);
            textviewTimeLeft = itemView.findViewById(R.id.project_page_item_timeleft);
            textviewGetTimeLeft = itemView.findViewById(R.id.project_page_item_gettimeleft);
        }
    }
}
