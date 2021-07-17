package com.example.hackathon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hackathon.CompletedQuestion.CompletedQuestion;
import java.util.ArrayList;
import java.util.List;

public class CompletedQuestionAdapter extends RecyclerView.Adapter<CompletedQuestionAdapter.ViewHolder>{

    List<CompletedQuestion> cardList = new ArrayList<CompletedQuestion>();
    private Context context;

    public CompletedQuestionAdapter(Context context){this.context = context;}

    public void setData(List<CompletedQuestion> cardList) {
        this.cardList = cardList;
    }


    @NonNull
    @Override
    public CompletedQuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CompletedQuestionAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
