package com.example.roomhomework.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {HomeWorkEntity.class})
public abstract class HomeworkDatabase extends RoomDatabase {

    public abstract HomeworkDAO homeworkDAO();

}
