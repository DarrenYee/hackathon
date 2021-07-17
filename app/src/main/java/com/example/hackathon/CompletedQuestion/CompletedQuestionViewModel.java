package com.example.hackathon.CompletedQuestion;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CompletedQuestionViewModel extends AndroidViewModel {

    private CompletedQuestionRepo mRepository;
    private LiveData<List<CompletedQuestion>> mAllCompletedQuestion;
    public CompletedQuestionViewModel(@NonNull Application application) {
        super(application);
        mRepository = new CompletedQuestionRepo(application);
        mAllCompletedQuestion = mRepository.getAllQuestion();
    }
    public LiveData<List<CompletedQuestion>> getAllCompletedQuestion() {
        return mAllCompletedQuestion;
    }
}
