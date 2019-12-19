package com.example.roomhomework.presenter;

import com.example.roomhomework.database.HomeWorkEntity;

import java.util.List;

public interface Contract {

    interface HomeworkPresenter {

        void getAllHomework();

        void insertNewHomework(HomeWorkEntity homeWorkEntity);

        void updateHomework(HomeWorkEntity homeWorkEntity);

        void deleteHomework(HomeWorkEntity homeWorkEntity);
    }

    interface HomeworkView {
        void displayAllHomework(List<HomeWorkEntity> homeworkList);

        void displayError(String errorString);

        void homeworkEmpty();

        void insertSuccess();
    }

}
