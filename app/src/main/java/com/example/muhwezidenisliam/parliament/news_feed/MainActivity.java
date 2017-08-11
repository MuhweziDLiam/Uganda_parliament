package com.example.muhwezidenisliam.parliament.news_feed;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muhwezidenisliam.parliament.R;

import com.example.muhwezidenisliam.parliament.freeview.FreeView;
import com.example.muhwezidenisliam.parliament.news_feed.data.QuizProvider;
import com.example.muhwezidenisliam.parliament.news_feed.model.Quiz;


import java.util.List;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.quiz_list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new QuizListAdapter(new QuizProvider().readQuizzes()));
    }

    class QuizListAdapter extends RecyclerView.Adapter<QuizViewHolder> {
        private final List<Quiz> quizzes;

        QuizListAdapter(List<Quiz> quizzes) {
            this.quizzes = quizzes;
        }

        @Override
        public QuizViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            final LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            final View v = layoutInflater.inflate(R.layout.quiz_card, viewGroup, false);
            return new QuizViewHolder(v);
        }

        @Override
        public void onBindViewHolder(QuizViewHolder quizViewHolder, int i) {
            quizViewHolder.quizQuestion.setText(quizzes.get(i).getQuestion());
            quizViewHolder.comments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "onShow", Toast.LENGTH_SHORT).show();

                    FreeView.init(MainActivity.this);
                    FreeView.withView(R.layout.news_feed);
                    FreeView.showFreeView(new FreeView.FreeViewListener() {
                        @Override
                        public void onShow() {
                            Toast.makeText(MainActivity.this, "onShow", Toast.LENGTH_SHORT).show();


                        }

                        @Override
                        public void onDismiss() {
                            Toast.makeText(MainActivity.this, "onDismiss", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onClick() {
                            Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }

        @Override
        public int getItemCount() {
            return quizzes.size();
        }
    }

    class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView quizQuestion;
        ImageView comments;

        QuizViewHolder(View itemView) {
            super(itemView);
            quizQuestion = (TextView) itemView.findViewById(R.id.quiz_question);
            comments = (ImageView) itemView.findViewById(R.id.comment);
        }
    }
}
