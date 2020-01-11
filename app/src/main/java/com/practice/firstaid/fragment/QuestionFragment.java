package com.practice.firstaid.fragment;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.practice.firstaid.R;
import com.practice.firstaid.activity.MainActivity;

import java.util.ArrayList;
import java.util.Collections;

import com.practice.firstaid.data.test_data.Answer;
import com.practice.firstaid.data.test_data.Question;
import com.practice.firstaid.data.test_data.QuestionsForTest;


public class QuestionFragment extends Fragment implements View.OnClickListener {
    Question this_question;
    QuestionsForTest questionsForTest = new QuestionsForTest();
    ArrayList<Answer> answers = new ArrayList<Answer>();
    int number = 0;
    int number_of_correct_answers = 0;
    int number_of_wrong_answers = 0;
    int number_of_skip_answers = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, null);

        TextView number_of_question = (TextView)view.findViewById(R.id.number_of_question);
        TextView question = (TextView)view.findViewById(R.id.question);
        Button first_answer = (Button)view.findViewById(R.id.first_answer);
        Button second_answer = (Button)view.findViewById(R.id.second_answer);
        Button third_answer = (Button)view.findViewById(R.id.third_answer);
        Button skip = (Button)view.findViewById(R.id.skip);
        Button finish = (Button)view.findViewById(R.id.finish);
        Button next_question = (Button)view.findViewById(R.id.next_question);

        first_answer.setOnClickListener(this);
        second_answer.setOnClickListener(this);
        third_answer.setOnClickListener(this);
        skip.setOnClickListener(this);
        finish.setOnClickListener(this);
        next_question.setOnClickListener(this);

        Collections.shuffle(questionsForTest.questions);

        this_question = questionsForTest.questions.get(0);
        number_of_question.setText("Вопрос №1");
        question.setText(this_question.getQuestion());
        answers.clear();
        answers.add(this_question.getFirst_answer());
        answers.add(this_question.getSecond_answer());
        answers.add(this_question.getThird_answer());
        Collections.shuffle(answers);
        first_answer.setText(answers.get(0).getAnswer());
        second_answer.setText(answers.get(1).getAnswer());
        third_answer.setText(answers.get(2).getAnswer());

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first_answer:
                (view.getRootView()).findViewById(R.id.next_question).setVisibility(View.VISIBLE);
                (view.getRootView()).findViewById(R.id.finish).setVisibility(View.GONE);
                (view.getRootView()).findViewById(R.id.skip).setVisibility(View.GONE);
                (view.getRootView()).findViewById(R.id.first_answer).setClickable(false);
                (view.getRootView()).findViewById(R.id.second_answer).setClickable(false);
                (view.getRootView()).findViewById(R.id.third_answer).setClickable(false);
                (view.getRootView()).findViewById(R.id.skip).setClickable(false);
                if (answers.get(0).getCorrect()) {
                    number_of_correct_answers++;
                    (view.getRootView()).findViewById(R.id.first_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector_correct));
                } else {
                    number_of_wrong_answers++;
                    if (answers.get(1).getCorrect()){
                        ((TextView)(view.getRootView()).findViewById(R.id.question_comment)).setText("Правильный ответ: " + answers.get(1).getAnswer());
                    } else {
                        ((TextView)(view.getRootView()).findViewById(R.id.question_comment)).setText("Правильный ответ: " + answers.get(2).getAnswer());
                    }
                    (view.getRootView()).findViewById(R.id.first_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector_error));
                }
                break;
            case R.id.second_answer:
                (view.getRootView()).findViewById(R.id.next_question).setVisibility(View.VISIBLE);
                (view.getRootView()).findViewById(R.id.finish).setVisibility(View.GONE);
                (view.getRootView()).findViewById(R.id.skip).setVisibility(View.GONE);
                (view.getRootView()).findViewById(R.id.first_answer).setClickable(false);
                (view.getRootView()).findViewById(R.id.second_answer).setClickable(false);
                (view.getRootView()).findViewById(R.id.third_answer).setClickable(false);
                (view.getRootView()).findViewById(R.id.skip).setClickable(false);
                if (answers.get(1).getCorrect()) {
                    number_of_correct_answers++;
                    (view.getRootView()).findViewById(R.id.second_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector_correct));
                } else {
                    number_of_wrong_answers++;
                    if (answers.get(0).getCorrect()){
                        ((TextView)(view.getRootView()).findViewById(R.id.question_comment)).setText("Правильный ответ: " + answers.get(0).getAnswer());
                    } else {
                        ((TextView)(view.getRootView()).findViewById(R.id.question_comment)).setText("Правильный ответ: " + answers.get(2).getAnswer());
                    }
                    (view.getRootView()).findViewById(R.id.second_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector_error));
                }
                break;
            case R.id.third_answer:
                (view.getRootView()).findViewById(R.id.next_question).setVisibility(View.VISIBLE);
                (view.getRootView()).findViewById(R.id.finish).setVisibility(View.GONE);
                (view.getRootView()).findViewById(R.id.skip).setVisibility(View.GONE);
                (view.getRootView()).findViewById(R.id.first_answer).setClickable(false);
                (view.getRootView()).findViewById(R.id.second_answer).setClickable(false);
                (view.getRootView()).findViewById(R.id.third_answer).setClickable(false);
                (view.getRootView()).findViewById(R.id.skip).setClickable(false);
                if (answers.get(2).getCorrect()) {
                    number_of_correct_answers++;
                    (view.getRootView()).findViewById(R.id.third_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector_correct));
                } else {
                    number_of_wrong_answers++;
                    if (answers.get(0).getCorrect()){
                        ((TextView)(view.getRootView()).findViewById(R.id.question_comment)).setText("Правильный ответ: " + answers.get(0).getAnswer());
                    } else {
                        ((TextView)(view.getRootView()).findViewById(R.id.question_comment)).setText("Правильный ответ: " + answers.get(1).getAnswer());
                    }
                    (view.getRootView()).findViewById(R.id.third_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector_error));
                }
                break;
            case R.id.next_question:
                number++;
                if((number+1) == 40) {
                    ((Button)(view.getRootView().findViewById(R.id.next_question))).setText("Завершить тест");
                    (view.getRootView()).findViewById(R.id.finish).setVisibility(View.VISIBLE);
                    (view.getRootView()).findViewById(R.id.skip).setVisibility(View.VISIBLE);
                }
                if((number+1) == 41) {
                    ((MainActivity)getActivity()).loadFragment(new TestsFragment());
                    android.app.AlertDialog.Builder builder_end = new android.app.AlertDialog.Builder(getActivity());
                    LayoutInflater inflater_end = getActivity().getLayoutInflater();
                    final View v_end = inflater_end.inflate(R.layout.result_dialog, null);
                    builder_end.setView(v_end)
                            .setNegativeButton("Завершить просмотр",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    final android.app.AlertDialog dialog_end = builder_end.create();
                    ((TextView)v_end.findViewById(R.id.number_of_correct_answer)).setText("Правильно: " + number_of_correct_answers);
                    ((TextView)v_end.findViewById(R.id.number_of_skip_answer)).setText("Пропущено: " + number_of_skip_answers);
                    ((TextView)v_end.findViewById(R.id.number_of_wrong_answer)).setText("Неправильно: " + number_of_wrong_answers);

                    dialog_end.show();
                } else {
                    (view.getRootView()).findViewById(R.id.finish).setVisibility(View.VISIBLE);
                    (view.getRootView()).findViewById(R.id.skip).setVisibility(View.VISIBLE);
                    (view.getRootView()).findViewById(R.id.next_question).setVisibility(View.GONE);
                    (view.getRootView()).findViewById(R.id.first_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.second_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.third_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.skip).setClickable(true);
                    ((TextView) (view.getRootView()).findViewById(R.id.question_comment)).setText("");
                    (view.getRootView()).findViewById(R.id.first_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    (view.getRootView()).findViewById(R.id.second_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    (view.getRootView()).findViewById(R.id.third_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    this_question = questionsForTest.questions.get(number);
                    ((TextView) (view.getRootView()).findViewById(R.id.number_of_question)).setText("Вопрос №" + (number + 1));
                    ((TextView) (view.getRootView()).findViewById(R.id.question)).setText(this_question.getQuestion());
                    answers.clear();
                    answers.add(this_question.getFirst_answer());
                    answers.add(this_question.getSecond_answer());
                    answers.add(this_question.getThird_answer());
                    Collections.shuffle(answers);
                    ((Button) (view.getRootView().findViewById(R.id.first_answer))).setText(answers.get(0).getAnswer());
                    ((Button) (view.getRootView().findViewById(R.id.second_answer))).setText(answers.get(1).getAnswer());
                    ((Button) (view.getRootView().findViewById(R.id.third_answer))).setText(answers.get(2).getAnswer());
                }
                break;
            case R.id.finish:
                ((MainActivity)getActivity()).loadFragment(new TestsFragment());

                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                final View v = inflater.inflate(R.layout.result_dialog, null);

                builder.setView(v)
                        .setNegativeButton("Завершить просмотр",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                final android.app.AlertDialog dialog = builder.create();
                ((TextView)v.findViewById(R.id.number_of_correct_answer)).setText("Правильно: " + number_of_correct_answers);
                ((TextView)v.findViewById(R.id.number_of_skip_answer)).setText("Пропущено: " + number_of_skip_answers);
                ((TextView)v.findViewById(R.id.number_of_wrong_answer)).setText("Неправильно: " + number_of_wrong_answers);

                dialog.show();
                break;
            case R.id.skip:
                number++;
                number_of_skip_answers++;
                if((number+1) == 40) {
                    ((Button)(view.getRootView().findViewById(R.id.next_question))).setText("Завершить тест");
                }
                if((number+1) == 41) {
                    ((MainActivity)getActivity()).loadFragment(new TestsFragment());
                    android.app.AlertDialog.Builder builder_end = new android.app.AlertDialog.Builder(getActivity());
                    LayoutInflater inflater_end = getActivity().getLayoutInflater();
                    final View v_end = inflater_end.inflate(R.layout.result_dialog, null);
                    builder_end.setView(v_end)
                            .setNegativeButton("Завершить просмотр",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    final android.app.AlertDialog dialog_end = builder_end.create();
                    ((TextView)v_end.findViewById(R.id.number_of_correct_answer)).setText("Правильно: " + number_of_correct_answers);
                    ((TextView)v_end.findViewById(R.id.number_of_skip_answer)).setText("Пропущено: " + number_of_skip_answers);
                    ((TextView)v_end.findViewById(R.id.number_of_wrong_answer)).setText("Неправильно: " + number_of_wrong_answers);

                    dialog_end.show();
                } else {
                    (view.getRootView()).findViewById(R.id.next_question).setVisibility(View.GONE);
                    (view.getRootView()).findViewById(R.id.first_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.second_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.third_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.skip).setClickable(true);
                    ((TextView) (view.getRootView()).findViewById(R.id.question_comment)).setText("");
                    (view.getRootView()).findViewById(R.id.first_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    (view.getRootView()).findViewById(R.id.second_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    (view.getRootView()).findViewById(R.id.third_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    this_question = questionsForTest.questions.get(number);
                    ((TextView) (view.getRootView()).findViewById(R.id.number_of_question)).setText("Вопрос №" + (number + 1));
                    ((TextView) (view.getRootView()).findViewById(R.id.question)).setText(this_question.getQuestion());
                    answers.clear();
                    answers.add(this_question.getFirst_answer());
                    answers.add(this_question.getSecond_answer());
                    answers.add(this_question.getThird_answer());
                    Collections.shuffle(answers);
                    ((Button) (view.getRootView().findViewById(R.id.first_answer))).setText(answers.get(0).getAnswer());
                    ((Button) (view.getRootView().findViewById(R.id.second_answer))).setText(answers.get(1).getAnswer());
                    ((Button) (view.getRootView().findViewById(R.id.third_answer))).setText(answers.get(2).getAnswer());
                }
                break;
            default:
                break;
        }
    }
}
