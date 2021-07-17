package com.example.hackathon.CompletedQuestion;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CompletedQuestionDao {
    @Query("select * from CompletedQuestion")
    LiveData<List<CompletedQuestion>> getAllQuestion();

    @Insert
    void addCar(CompletedQuestion car);

}
