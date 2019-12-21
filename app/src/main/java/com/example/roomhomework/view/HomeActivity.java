package com.example.roomhomework.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomhomework.R;
import com.example.roomhomework.adapter.HomeworkAdapter;
import com.example.roomhomework.database.HomeWorkEntity;
import com.example.roomhomework.database.HomeworkDatabase;
import com.example.roomhomework.presenter.Contract;
import com.example.roomhomework.presenter.HomeworkPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements Contract.HomeworkView, HomeworkAdapter.HomeworkDelegate {

    private Contract.HomeworkPresenter homeworkPresenter;

    private NewHomeworkEntryFragment newHomeworkEntryFragment = new NewHomeworkEntryFragment();

    @BindView(R.id.home_recyclerview)
    public RecyclerView homeRecyclerView;

    @BindView(R.id.homework_list_textview)
    public TextView homeListTextView;

    @BindView(R.id.new_homework_button)
    public Button newHomeworkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        homeworkPresenter = new HomeworkPresenter(this);

        /*homeworkPresenter.insertNewHomework(new HomeWorkEntity("RoomDbFav", 1, 4, true));
        homeworkPresenter.insertNewHomework(new HomeWorkEntity("RecieptDocs", 1, 3, true));*/
        homeworkPresenter.getAllHomework();

        newHomeworkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(newHomeworkEntryFragment.getTag())
                        .add(R.id.home_frame_layout, newHomeworkEntryFragment)
                        .commit();

            }
        });
    }

    @Override
    public void homeworkSelected(HomeworkAdapter.HomeworkDelegate homeworkDelegate) {

    }

    @Override
    public void displayAllHomework(List<HomeWorkEntity> homeworkList) {
        HomeworkAdapter homeworkApdapter = new HomeworkAdapter(homeworkList, this);
        homeRecyclerView.setAdapter(homeworkApdapter);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemDecoration decorater = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        homeRecyclerView.addItemDecoration(decorater);
    }

    @Override
    public void displayError(String errorString) {
        homeListTextView.setText(getString(R.string.error_text, errorString));
    }

    @Override
    public void homeworkEmpty() {
        homeListTextView.setText(getString(R.string.no_homework_listed, "Homework Listed"));
    }

    @Override
    public void insertSuccess() {
        Toast.makeText(this, "Insert Successful", Toast.LENGTH_SHORT).show();
    }
}
