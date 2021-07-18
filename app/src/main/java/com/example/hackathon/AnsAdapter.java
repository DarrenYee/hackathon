package com.example.hackathon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.CompletedQuestion.CompletedQuestion;
import com.example.hackathon.CompletedQuestion.CompletedQuestionAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnsAdapter extends RecyclerView.Adapter<AnsAdapter.ViewHolder>{

    List<String> cardList = new ArrayList<String>();
    private Context context;

    public AnsAdapter(Context context){this.context = context;}

    public void setData(List<String> cardList) {
        this.cardList = cardList;
    }


    @NonNull
    @Override
    public AnsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.asked_question_card, parent, false); //CardView inflated as RecyclerView list item
        AnsAdapter.ViewHolder viewHolder = new AnsAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnsAdapter.ViewHolder holder, int position) {
        holder.question.setText(cardList.get(position));
    }

    @Override
    public int getItemCount() {
        {
            return cardList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView question;
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            question =itemView.findViewById(R.id.asked_ques);
        }
    }
}
