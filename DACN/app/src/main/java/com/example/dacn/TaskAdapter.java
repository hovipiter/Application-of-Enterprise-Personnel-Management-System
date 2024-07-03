package com.example.dacn;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public RadioButton radioButton;
        public EditText editTextTask;

        public TaskViewHolder(View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radioButton);
            editTextTask = itemView.findViewById(R.id.item_todolist);
        }
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todolist, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.editTextTask.setText(task.getName());
        holder.radioButton.setChecked(task.isCompleted());

        holder.radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> task.setCompleted(isChecked));

        holder.editTextTask.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                task.setName(s.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
