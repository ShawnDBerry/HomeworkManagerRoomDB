package com.example.roomhomework.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HomeworkDAO {

    @Query("SELECT * FROM homework ORDER BY homework_week, homework_day")
    public List<HomeWorkEntity> getAllHomework();

    @Insert
    void insertNewHomework(HomeWorkEntity homeWorkEntity);

    @Delete
    void deleteHomework(HomeWorkEntity homeWorkEntity);

    @Update
    void updateHomework(HomeWorkEntity homeWorkEntity);

}
