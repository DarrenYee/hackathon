package com.example.hackathon.CompletedQuestion;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CompletedQuestion.class}, version = 1)
public abstract class CompletedQuestionDatabase extends RoomDatabase {
    public static final String CompletedQuestion_DATABASE_NAME = "CompletedQuestion_database";
    public abstract CompletedQuestionDao CompletedQuestionDao();
    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile CompletedQuestionDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static CompletedQuestionDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CompletedQuestionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CompletedQuestionDatabase.class, CompletedQuestion_DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
