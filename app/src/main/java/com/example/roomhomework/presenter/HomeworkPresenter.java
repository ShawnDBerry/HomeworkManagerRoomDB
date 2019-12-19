package com.example.roomhomework.presenter;

import androidx.room.Room;

import com.example.roomhomework.view.HomeActivity;
import com.example.roomhomework.database.HomeWorkEntity;
import com.example.roomhomework.database.HomeworkDatabase;

import java.util.List;

public class HomeworkPresenter implements Contract.HomeworkPresenter {
    private HomeworkDatabase homeworkDatabase;
    private Contract.HomeworkView homeworkView;

    private List<HomeWorkEntity> homeworkList;

    public HomeworkPresenter(Contract.HomeworkView homeworkView) {
        this.homeworkView = homeworkView;

        try {
            homeworkDatabase = Room.databaseBuilder(((HomeActivity) homeworkView)
                            .getApplicationContext(),
                    HomeworkDatabase.class, "homework.db")
                    .allowMainThreadQueries()
                    .build();
        } catch (Exception e) {

            homeworkView.displayError("Failed to create Database");

        }

    }


    @Override
    public void getAllHomework() {
        homeworkList = homeworkDatabase.homeworkDAO().getAllHomework();
        if(homeworkList.isEmpty()){
            homeworkView.homeworkEmpty();
        } else {
            homeworkView.displayAllHomework(homeworkDatabase.homeworkDAO().getAllHomework());
        }
    }

    @Override
    public void insertNewHomework(HomeWorkEntity homeWorkEntity) {
        try{
            homeworkDatabase.homeworkDAO().insertNewHomework(homeWorkEntity);
        }catch (Exception e){
            homeworkView.displayError("Failed to Insert " + homeWorkEntity.getHomeworkSubject());

        }

    }

    @Override
    public void updateHomework(HomeWorkEntity homeWorkEntity) {

    }

    @Override
    public void deleteHomework(HomeWorkEntity homeWorkEntity) {

    }
}
