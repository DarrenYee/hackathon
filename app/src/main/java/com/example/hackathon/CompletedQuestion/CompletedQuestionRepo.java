package com.example.hackathon.CompletedQuestion;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CompletedQuestionRepo {
    private CompletedQuestionDao completedQuestionDao;
    private LiveData<List<CompletedQuestion>> allCompletedQuestion;
    CompletedQuestionRepo(Application application) {
        CompletedQuestionDatabase db = CompletedQuestionDatabase.getDatabase(application);
        completedQuestionDao = db.CompletedQuestionDao();
        allCompletedQuestion = completedQuestionDao.getAllQuestion();
    }

    LiveData<List<CompletedQuestion>> getAllQuestion() {
        return allCompletedQuestion;
    }

    void insert(CompletedQuestion completedQuestion) {
        CompletedQuestionDatabase.databaseWriteExecutor.execute(() -> completedQuestionDao.addCar(completedQuestion));
    }

}
