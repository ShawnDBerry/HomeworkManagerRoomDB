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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NewHomeworkEntryFragment extends Fragment {

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


    }

    @OnClick(R.id.close_icon_imageview)
    public void closeFragment(View view){
        getActivity().getSupportFragmentManager().popBackStack();
        Log.d("TAG_X", "WHere you at?");
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


}
