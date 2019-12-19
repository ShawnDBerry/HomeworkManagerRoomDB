package com.example.roomhomework.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomhomework.R;
import com.example.roomhomework.database.HomeWorkEntity;

import java.util.List;

public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkAdapter.HomeworkViewHolder>{
    private List<HomeWorkEntity> homeworkList;
    private HomeworkDelegate homeworkDelegate;

    public HomeworkAdapter(List<HomeWorkEntity> homeworkList, HomeworkDelegate homeworkDelegate) {
        this.homeworkList = homeworkList;
        this.homeworkDelegate = homeworkDelegate;
    }


    public interface HomeworkDelegate {
        void homeworkSelected(HomeworkDelegate homeworkDelegate);
    }
    @NonNull
    @Override
    public HomeworkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homework_item_layout, parent, false);
        return new HomeworkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeworkViewHolder holder, int position) {
        holder.homeworkSubject.setText(homeworkList.get(position).getHomeworkSubject());

        if(homeworkList.get(position).isHomeworkComplete()){
            holder.homeworkComplete.setText(R.string.is_homework_complete_true);
        } else {
            holder.homeworkComplete.setText(R.string.is_homework_complete_false);
        }

        holder.homeworkWeek.setText("" + homeworkList.get(position).getHomeworkWeek());
        holder.homeworkDay.setText("" + homeworkList.get(position).getHomeworkDay());
    }

    @Override
    public int getItemCount() {
        return homeworkList.size();
    }

    public class HomeworkViewHolder extends RecyclerView.ViewHolder{

        TextView homeworkSubject;
        TextView homeworkComplete;
        TextView homeworkWeek;
        TextView homeworkDay;
        public HomeworkViewHolder(@NonNull View itemView) {
            super(itemView);

            homeworkSubject = itemView.findViewById(R.id.homework_subject_textview);
            homeworkComplete  = itemView.findViewById(R.id.homework_completed_textview);
            homeworkWeek  = itemView.findViewById(R.id.homework_week_textview);
            homeworkDay  = itemView.findViewById(R.id.homework_day_textview);
        }
    }
}
