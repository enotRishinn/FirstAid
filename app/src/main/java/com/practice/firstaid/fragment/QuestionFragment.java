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
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.practice.firstaid.R;
import com.practice.firstaid.activity.MainActivity;
import com.practice.firstaid.model.Answer;
import com.practice.firstaid.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class QuestionFragment extends Fragment implements View.OnClickListener {

    Question this_question;
    ArrayList<Question> questions = new ArrayList<Question>();
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

        Question question1 = new Question(1, "Каким образом проводится сердечно-легочная реанимация пострадавшего?", new Answer("Давление руками на грудину пострадавшего и искусственная вентиляция легких: вначале 30 надавливаний на грудину, затем 2 вдоха методом «Рот ко рту».", true), new Answer("Искусственная вентиляция легких и давление руками на грудину пострадавшего: вначале 1 вдох методом «Рот ко рту», затем 15 надавливаний на грудину.", false), new Answer("Давление руками на грудину пострадавшего и искусственная вентиляция легких: вначале 5 надавливаний на грудину, затем 1 вдох методом «Рот ко рту».", false));
        Question question2 = new Question(2, "Что из перечисленного является признаком венозного кровотечения?", new Answer("Очень темный цвет крови.", true), new Answer("Алая кровь из раны вытекает фонтанирующей струей.", false), new Answer("Кровь пассивно стекает из раны.", false));
        Question question9 = new Question(9, "В какой последовательности следует осматривать ребенка при его травмировании?", new Answer("Голова, шея, грудная клетка, живот и область таза, конечности.", true), new Answer("Конечности, область таза и живот, грудная клетка, шея, голова.", false), new Answer("Грудная клетка, живот и область таза, голова, шея, конечности.", false));
        Question question12 = new Question(12, "Как проверить наличие дыхания у ребенка при внезапной потере сознания?", new Answer("Запрокинуть голову ребенка, поднять подбородок, в течение 10 секунд прислушиваться, пытаться ощутить дыхание ребенка на своей щеке, увидеть дыхательные движения его грудной клетки.", true), new Answer("Наклониться к ребенку, приложить ухо к его грудной клетке и в течение 10 секунд прислушиваться.", false), new Answer("В течение 10 секунд внимательно смотреть на его грудную клетку.", false));
        Question question16 = new Question(16, "Первая медицинская помощь при вывихе конечности?", new Answer("Осуществить иммобилизацию конечности, дать доступные обезболивающие средства, приложить к поврежденному суставу пузырь с холодной водой или льдом, организовать транспортировку в больницу или травмпункт.", true), new Answer("Дать обезболивающее средство, вправить вывих и зафиксировать конечность.", false), new Answer("Зафиксировать конечность, не вправляя вывих, приложить пузырь (грелку) с горячей водой, организовать транспортировку в больницу или травмпункт.", false));

        questions.add(question1);
        questions.add(question2);
        questions.add(question9);
        questions.add(question12);
        questions.add(question16);
        Collections.shuffle(questions);

        this_question = questions.get(0);
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
                (view.getRootView()).findViewById(R.id.first_answer).setClickable(false);
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
                (view.getRootView()).findViewById(R.id.second_answer).setClickable(false);
                (view.getRootView()).findViewById(R.id.first_answer).setClickable(false);
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
                if((number+1) == 5) {
                    ((Button)(view.getRootView().findViewById(R.id.next_question))).setText("Завершить тест");
                }
                if((number+1) == 6) {
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
                    (view.getRootView()).findViewById(R.id.next_question).setVisibility(View.INVISIBLE);
                    (view.getRootView()).findViewById(R.id.first_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.second_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.third_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.skip).setClickable(true);
                    ((TextView) (view.getRootView()).findViewById(R.id.question_comment)).setText("");
                    (view.getRootView()).findViewById(R.id.first_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    (view.getRootView()).findViewById(R.id.second_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    (view.getRootView()).findViewById(R.id.third_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    this_question = questions.get(number);
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
                if((number+1) == 5) {
                    ((Button)(view.getRootView().findViewById(R.id.next_question))).setText("Завершить тест");
                }
                if((number+1) == 6) {
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
                    (view.getRootView()).findViewById(R.id.next_question).setVisibility(View.INVISIBLE);
                    (view.getRootView()).findViewById(R.id.first_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.second_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.third_answer).setClickable(true);
                    (view.getRootView()).findViewById(R.id.skip).setClickable(true);
                    ((TextView) (view.getRootView()).findViewById(R.id.question_comment)).setText("");
                    (view.getRootView()).findViewById(R.id.first_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    (view.getRootView()).findViewById(R.id.second_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    (view.getRootView()).findViewById(R.id.third_answer).setBackground((Drawable) getResources().getDrawable(R.drawable.button_selector));
                    this_question = questions.get(number);
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
