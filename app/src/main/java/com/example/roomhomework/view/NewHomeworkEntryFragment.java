package com.example.roomhomework.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.roomhomework.R;
import com.example.roomhomework.database.HomeWorkEntity;
import com.example.roomhomework.presenter.Contract;
import com.example.roomhomework.presenter.HomeworkPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NewHomeworkEntryFragment extends Fragment implements Contract.HomeworkView {

    private Contract.HomeworkPresenter homeworkPresenter;

    @BindView(R.id.enter_homework_subject_edittext)
    EditText enterHomeworkSubjectEditText;

    @BindView(R.id.enter_homework_completed_edittext)
    EditText enterHomeworkCompletedEditText;

    @BindView(R.id.enter_homework_week_edittext)
    EditText enterHomeworkWeekEditText;

    @BindView(R.id.enter_homework_day_edittext)
    EditText enterHomeworkDayEditText;

    @BindView(R.id.insert_new_homework_button)
    Button insertNewHomeworkButton;

    @BindView(R.id.close_icon_imageview)
    ImageView closeFragmentIcon;


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_homework_entry, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        homeworkPresenter = new HomeworkPresenter(this);

        insertNewHomeworkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isComplete = false;
                if(enterHomeworkCompletedEditText.getText().toString().equals(R.string.is_homework_complete_true)){
                    isComplete = true;
                } else if (enterHomeworkCompletedEditText.getText().toString().equals(R.string.is_homework_complete_false)){
                    isComplete = false;
                }
                homeworkPresenter.insertNewHomework(new HomeWorkEntity(enterHomeworkSubjectEditText.getText().toString(),
                        Integer.parseInt(enterHomeworkWeekEditText.getText().toString()),
                        Integer.parseInt(enterHomeworkWeekEditText.getText().toString()), isComplete));

                getActivity().getSupportFragmentManager().popBackStack();
                Log.d("TAG_X", "Im in here!");
            }
        });

    }

    @OnClick(R.id.close_icon_imageview)
    public void closeFragment(View view) {
        getActivity().getSupportFragmentManager().popBackStack();
        Log.d("TAG_X", "WHere you at?");
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Override
    public void displayAllHomework(List<HomeWorkEntity> homeworkList) {

    }

    @Override
    public void displayError(String errorString) {

    }

    @Override
    public void homeworkEmpty() {

    }

    @Override
    public void insertSuccess() {

    }
}
