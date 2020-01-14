package com.practice.firstaid.fragment;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.practice.firstaid.R;
import com.practice.firstaid.activity.MainActivity;

public class AlgorithmFragment extends Fragment implements View.OnClickListener {
    private boolean flag2 = false;
    private boolean flag = false;
    Integer id;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_algorithm, null);



        TextView algorithm_question = (TextView) view.findViewById(R.id.algorithm_question);
        Button first_action = (Button) view.findViewById(R.id.first_action);
        Button second_action = (Button) view.findViewById(R.id.second_action);
        Button third_action = (Button) view.findViewById(R.id.third_action);
        Button fourth_action = (Button) view.findViewById(R.id.fourth_action);
        Button fifth_action = (Button) view.findViewById(R.id.fifth_action);
        Button sixth_action = (Button) view.findViewById(R.id.sixth_action);
        Button exit = (Button) view.findViewById(R.id.exit);
        Button back = (Button) view.findViewById(R.id.back);

        algorithm_question.setText("Человек находится в сознании?");
        first_action.setVisibility(View.VISIBLE);
        second_action.setVisibility(View.VISIBLE);
        first_action.setText("Да");
        second_action.setText("Нет");

        first_action.setOnClickListener(this);
        second_action.setOnClickListener(this);
        third_action.setOnClickListener(this);
        fourth_action.setOnClickListener(this);
        fifth_action.setOnClickListener(this);
        sixth_action.setOnClickListener(this);
        exit.setOnClickListener(this);
        back.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        TextView algorithm_question = (TextView) view.getRootView().findViewById(R.id.algorithm_question);
        Button first_action = (Button) view.getRootView().findViewById(R.id.first_action);
        Button second_action = (Button) view.getRootView().findViewById(R.id.second_action);
        Button third_action = (Button) view.getRootView().findViewById(R.id.third_action);
        Button fourth_action = (Button) view.getRootView().findViewById(R.id.fourth_action);
        Button fifth_action = (Button) view.getRootView().findViewById(R.id.fifth_action);
        Button sixth_action = (Button) view.getRootView().findViewById(R.id.sixth_action);
        switch (view.getId()) {
            case R.id.first_action:
                switch (algorithm_question.getText().toString()) {
                    case "Человек находится в сознании?" :
                        algorithm_question.setText("Есть ли явные изменения в цвете или целостности кожных покровов?");
                        first_action.setText("Ожог");
                        second_action.setText("Травма");
                        third_action.setVisibility(View.VISIBLE);
                        third_action.setText("Укус");
                        fourth_action.setVisibility(View.VISIBLE);
                        fourth_action.setText("Нет");
                        fifth_action.setVisibility(View.VISIBLE);
                        fifth_action.setText("Побеление/Покраснение");
                        break;
                    case "Есть ли явные изменения в цвете или целостности кожных покровов?" :
                        ((MainActivity)getActivity()).loadFragment(new BurnFragment());
                        break;
                    case "Определите по симптомам тяжесть травмы (если вы не уверены, лучше выбрать более тяжелый случай)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(15));
                        break;
                    case "Учащено ли дыхание у пострадавшего?" :
                        algorithm_question.setText("Повышена ли температура тела у пострадавшего? (Приложите в идеале свой лоб/губы ко лбу пострадавшего, или хотя бы запястье, сравните со своей температурой)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Повышена ли температура тела у пострадавшего? (Приложите в идеале свой лоб/губы ко лбу пострадавшего, или хотя бы запястье, сравните со своей температурой)" :
                        algorithm_question.setText("Нащупайте пульс пострадавшего (легче всего на шее или запястье). Присутствует ли аритмия? (Неравномерное, периодически ускоряющееся, замедляющееся сердцебиение)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Нащупайте пульс пострадавшего (легче всего на шее или запястье). Присутствует ли аритмия? (Неравномерное, периодически ускоряющееся, замедляющееся сердцебиение)":
                        algorithm_question.setText("Кожа пострадавшего горячая и сухая? (нет пота)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Кожа пострадавшего горячая и сухая? (нет пота)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(8));
                        break;
                    case "Присутствует ли сильная боль сконцентрированная зонально в нижней правой части живота? (При пальпации и движениях обостряется именно в этой зоне)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(12));
                        break;
                    case "Нащупайте пульс пострадавшего (легче всего на шее или запястье). Включите таймер и посчитайте количество ударов." :
                        flag2 = false;
                        algorithm_question.setText("Затруднено ли дыхание пострадавшего?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Затруднено ли дыхание пострадавшего?" :
                        algorithm_question.setText("Присутствует ли тошнота? Рвота?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли тошнота? Рвота?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(25));
                        break;
                    case "Помутнено ли сознание пострадавшего? (Не до конца осознает и воспринимает действительность, отвечает не в попад, у него ярко выраженный бред, не может ответить адекватно на простые вопросы, делает нелогичные действия)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(4));
                        break;
                    case "Присутствует ли обильная потливость? (Стекающий пот, мокрая одежда от пота, выступившие капли пота или просто влажная кожа)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(24));
                        break;
                    case "Речь пострадавшего несвязная? Язык заплетается?" :
                        algorithm_question.setText("Присутствует ли резкая головная боль?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли резкая головная боль?" :
                        algorithm_question.setText("Присутствует ли ассиметрия в лице? (При улыбке, попытках говорить и прочее) При движениях? (Если пострадавший пытается поднять обе руки, они оказываются на разной высоте)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли ассиметрия в лице? (При улыбке, попытках говорить и прочее) При движениях? (Если пострадавший пытается поднять обе руки, они оказываются на разной высоте)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(1));
                        break;
                    case "Нарушена ли общая координация в движениях?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(10));
                        break;
                    case "Присутствует ли судороги, конвульсии, дрожь?" :
                        algorithm_question.setText("Присутствует ли боль в животе?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли боль в животе?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(24));
                        break;
                    case "Затруднено ли дыхание?" :
                        algorithm_question.setText("Повышено ли слюноотделение?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Повышено ли слюноотделение?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(2));
                        break;
                    case "Кожа бледная и влажная?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(0));
                        break;
                    case "Испытывает ли пострадавший затруднение в дыхании?" :
                        algorithm_question.setText("Присутствует ли тошнота? Рвота?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Испытывает ли пострадавший головную боль?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(9));
                        break;
                    case "Нащупайте пульс пострадавшего (легче всего на шее или запястье). Используйте встроенный таймер и посчитайте количество ударов." :
                        flag2 = false;
                        algorithm_question.setText("Затруднено ли дыхание пострадавшего?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Учащено ли дыхание о пострадавшего, есть ли одышка?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(13));
                        break;
                }

                break;
            case R.id.second_action:
                switch (algorithm_question.getText().toString()) {
                    case "Есть ли явные изменения в цвете или целостности кожных покровов?" :
                        algorithm_question.setText("Определите по симптомам тяжесть травмы (если вы не уверены, лучше выбрать более тяжелый случай)");
                        first_action.setText("Ушиб /n Гематома, небольшой отек, боль при касании");
                        second_action.setText("Сдавливание /n Длительное нахождение конечности под тяжелым предметом");
                        third_action.setText("Разрыв/растяжение связок /n Боль при движении, отек, покраснение, нарушение функционирования");
                        fourth_action.setText("Вывих /n Резкая сильная боль, сустав теряет подвижность, нарушается внешний вид, отек");
                        fifth_action.setText("Перелом /n Сильная боль, нарастающий отек, невозможность двигать, нарушение внешнего вида, покраснение, невозможность функционирования");
                        break;
                    case "Определите по симптомам тяжесть травмы (если вы не уверены, лучше выбрать более тяжелый случай)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(16));
                        break;
                    case "Кожа пострадавшего горячая и сухая? (нет пота)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(7));
                        break;
                    case "Нащупайте пульс пострадавшего (легче всего на шее или запястье). Присутствует ли аритмия? (Неравномерное, периодически ускоряющееся, замедляющееся сердцебиение)":
                        algorithm_question.setText("Присутствует ли сильная боль сконцентрированная зонально в нижней правой части живота? (При пальпации и движениях обостряется именно в этой зоне)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли сильная боль сконцентрированная зонально в нижней правой части живота? (При пальпации и движениях обостряется именно в этой зоне)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(14));
                        break;
                    case "Повышена ли температура тела у пострадавшего? (Приложите в идеале свой лоб/губы ко лбу пострадавшего, или хотя бы запястье, сравните со своей температурой)" :
                        flag = true;
                        algorithm_question.setText("Нащупайте пульс пострадавшего (легче всего на шее или запястье). Включите таймер и посчитайте количество ударов.");
                        // TODO: 13.01.2020 Таймер
                        first_action.setText("Больше 15 ударов");
                        second_action.setText("Меньше 15 ударов");
                        break;
                    case "Присутствует ли тошнота? Рвота?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(6));
                        break;
                    case "Затруднено ли дыхание пострадавшего?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(0));
                        break;
                    case "Нащупайте пульс пострадавшего (легче всего на шее или запястье). Включите таймер и посчитайте количество ударов." :
                        algorithm_question.setText("Помутнено ли сознание пострадавшего? (Не доконца осознает и воспринимает действительность, отвечает не в попад, у него ярко выраженный бред, не может ответить адекватно на простые вопросы, делает нелогичные действия)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Помутнено ли сознание пострадавшего? (Не до конца осознает и воспринимает действительность, отвечает не в попад, у него ярко выраженный бред, не может ответить адекватно на простые вопросы, делает нелогичные действия)" :
                        algorithm_question.setText("Присутствует ли обильная потливость? (Стекающий пот, мокрая одежда от пота, выступившие капли пота или просто влажная кожа)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли обильная потливость? (Стекающий пот, мокрая одежда от пота, выступившие капли пота или просто влажная кожа)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(13));
                        break;
                    case "Учащено ли дыхание у пострадавшего?" :
                        algorithm_question.setText("Речь пострадавшего несвязная? Язык заплетается?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли ассиметрия в лице? (При улыбке, попытках говорить и прочее) При движениях? (Если пострадавший пытается поднять обе руки, они оказываются на разной высоте)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(5));
                        break;
                    case "Присутствует ли резкая головная боль?" :
                        algorithm_question.setText("Нарушена ли общая координация в движениях?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Нарушена ли общая координация в движениях?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(11));
                        break;
                    case "Речь пострадавшего несвязная? Язык заплетается?" :
                        algorithm_question.setText("Присутствует ли судороги, конвульсии, дрожь?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли боль в животе?" :
                        algorithm_question.setText("Затруднено ли дыхание?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Затруднено ли дыхание?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(3));
                        break;
                    case "Повышено ли слюноотделение?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(10));
                        break;
                    case "Присутствует ли судороги, конвульсии, дрожь?" :
                        algorithm_question.setText("Кожа бледная и влажная?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Кожа бледная и влажная?" :
                        flag2 = true;
                        algorithm_question.setText("Испытывает ли пострадавший затруднение в дыхании?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Испытывает ли пострадавший затруднение в дыхании?" :
                        algorithm_question.setText("Испытывает ли пострадавший головную боль?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Испытывает ли пострадавший головную боль?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(23));
                        break;
                    case "Нащупайте пульс пострадавшего (легче всего на шее или запястье). Используйте встроенный таймер и посчитайте количество ударов." :
                        algorithm_question.setText("Учащено ли дыхание о пострадавшего, есть ли одышка?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Учащено ли дыхание о пострадавшего, есть ли одышка?" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(11));
                        break;
                    case "Человек находится в сознании?" :
                        // TODO: 13.01.2020 Без сознания 
                        break;
                }
                break;
            case R.id.third_action:
                switch (algorithm_question.getText().toString()) {
                    case "Определите по симптомам тяжесть травмы (если вы не уверены, лучше выбрать более тяжелый случай)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(17));
                        break;
                    case "Есть ли явные изменения в цвете или целостности кожных покровов?" :
                        ((MainActivity)getActivity()).loadFragment(new BiteFragment());
                        break;
                }
                break;
            case R.id.fourth_action:
                switch (algorithm_question.getText().toString()) {
                    case "Определите по симптомам тяжесть травмы (если вы не уверены, лучше выбрать более тяжелый случай)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(18));
                        break;
                    case "Есть ли явные изменения в цвете или целостности кожных покровов?" :
                        algorithm_question.setText("Учащено ли дыхание у пострадавшего?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        third_action.setVisibility(View.GONE);
                        fourth_action.setVisibility(View.GONE);
                        fifth_action.setVisibility(View.GONE);
                        break;
                }
                break;
            case R.id.fifth_action:
                switch (algorithm_question.getText().toString()) {
                    case "Определите по симптомам тяжесть травмы (если вы не уверены, лучше выбрать более тяжелый случай)" :
                        ((MainActivity)getActivity()).loadFragment(new ResultFragment(19));
                        break;
                    case "Есть ли явные изменения в цвете или целостности кожных покровов?" :
                        third_action.setVisibility(View.GONE);
                        fourth_action.setVisibility(View.GONE);
                        fifth_action.setVisibility(View.GONE);
                        flag = false;
                        algorithm_question.setText("Нащупайте пульс пострадавшего (легче всего на шее или запястье). Используйте встроенный таймер и посчитайте количество ударов.");
                        // TODO: 13.01.2020 Таймер
                        first_action.setText("Более 15 ударов");
                        second_action.setText("Менее 15 ударов");
                        break;
                }
                break;
            case R.id.sixth_action:
                break;
            case R.id.exit:
                ((MainActivity)getActivity()).loadFragment(new FirstAidFragment());
                break;
            case R.id.back:
                switch (algorithm_question.getText().toString()) {
                    case "Присутствует ли тошнота? Рвота?" :
                        if (flag2) {
                            algorithm_question.setText("Испытывает ли пострадавший затруднение в дыхании?");
                            first_action.setText("Да");
                            second_action.setText("Нет");
                        } else {
                            algorithm_question.setText("Затруднено ли дыхание пострадавшего?");
                            first_action.setText("Да");
                            second_action.setText("Нет");
                        }
                        break;
                    case "Затруднено ли дыхание пострадавшего?" :
                        if (flag) {
                            algorithm_question.setText("Нащупайте пульс пострадавшего (легче всего на шее или запястье). Включите таймер и посчитайте количество ударов.");
                            // TODO: 13.01.2020 Таймер
                            first_action.setText("Больше 15 ударов");
                            second_action.setText("Меньше 15 ударов");
                        } else {
                            algorithm_question.setText("Нащупайте пульс пострадавшего (легче всего на шее или запястье). Используйте встроенный таймер и посчитайте количество ударов.");
                            // TODO: 13.01.2020 Таймер
                            first_action.setText("Более 15 ударов");
                            second_action.setText("Менее 15 ударов");
                        }
                        break;
                    case "Нащупайте пульс пострадавшего (легче всего на шее или запястье). Используйте встроенный таймер и посчитайте количество ударов." :
                        algorithm_question.setText("Есть ли явные изменения в цвете или целостности кожных покровов?");
                        first_action.setText("Ожог");
                        second_action.setText("Травма");
                        third_action.setVisibility(View.VISIBLE);
                        third_action.setText("Укус");
                        fourth_action.setVisibility(View.VISIBLE);
                        fourth_action.setText("Нет");
                        fifth_action.setVisibility(View.VISIBLE);
                        fifth_action.setText("Побеление/Покраснение");
                        break;
                    case "Есть ли явные изменения в цвете или целостности кожных покровов?" :
                        algorithm_question.setText("Человек находится в сознании?");
                        third_action.setVisibility(View.GONE);
                        fourth_action.setVisibility(View.GONE);
                        fifth_action.setVisibility(View.GONE);
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Испытывает ли пострадавший затруднение в дыхании?" :
                        algorithm_question.setText("Кожа бледная и влажная?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Кожа бледная и влажная?" :
                        algorithm_question.setText("Присутствует ли судороги, конвульсии, дрожь?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли судороги, конвульсии, дрожь?" :
                        algorithm_question.setText("Речь пострадавшего несвязная? Язык заплетается?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Речь пострадавшего несвязная? Язык заплетается?" :
                        algorithm_question.setText("Учащено ли дыхание у пострадавшего?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Учащено ли дыхание у пострадавшего?" :
                        algorithm_question.setText("Есть ли явные изменения в цвете или целостности кожных покровов?");
                        first_action.setText("Ожог");
                        second_action.setText("Травма");
                        third_action.setVisibility(View.VISIBLE);
                        third_action.setText("Укус");
                        fourth_action.setVisibility(View.VISIBLE);
                        fourth_action.setText("Нет");
                        fifth_action.setVisibility(View.VISIBLE);
                        fifth_action.setText("Побеление/Покраснение");
                        break;
                    case "Учащено ли дыхание о пострадавшего, есть ли одышка?" :
                        flag = true;
                        algorithm_question.setText("Нащупайте пульс пострадавшего (легче всего на шее или запястье). Включите таймер и посчитайте количество ударов.");
                        // TODO: 13.01.2020 Таймер
                        first_action.setText("Больше 15 ударов");
                        second_action.setText("Меньше 15 ударов");
                        break;
                    case "Нащупайте пульс пострадавшего (легче всего на шее или запястье). Включите таймер и посчитайте количество ударов." :
                        algorithm_question.setText("Повышена ли температура тела у пострадавшего? (Приложите в идеале свой лоб/губы ко лбу пострадавшего, или хотя бы запястье, сравните со своей температурой)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Повышена ли температура тела у пострадавшего? (Приложите в идеале свой лоб/губы ко лбу пострадавшего, или хотя бы запястье, сравните со своей температурой)" :
                        algorithm_question.setText("Учащено ли дыхание у пострадавшего?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Испытывает ли пострадавший головную боль?" :
                        flag2 = true;
                        algorithm_question.setText("Испытывает ли пострадавший затруднение в дыхании?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Нарушена ли общая координация в движениях?" :
                        algorithm_question.setText("Присутствует ли резкая головная боль?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли ассиметрия в лице? (При улыбке, попытках говорить и прочее) При движениях? (Если пострадавший пытается поднять обе руки, они оказываются на разной высоте)" :
                        algorithm_question.setText("Присутствует ли резкая головная боль?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли резкая головная боль?" :
                        algorithm_question.setText("Речь пострадавшего несвязная? Язык заплетается?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли сильная боль сконцентрированная зонально в нижней правой части живота? (При пальпации и движениях обостряется именно в этой зоне)" :
                        algorithm_question.setText("Нащупайте пульс пострадавшего (легче всего на шее или запястье). Присутствует ли аритмия? (Неравномерное, периодически ускоряющееся, замедляющееся сердцебиение)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Кожа пострадавшего горячая и сухая? (нет пота)" :
                        algorithm_question.setText("Нащупайте пульс пострадавшего (легче всего на шее или запястье). Присутствует ли аритмия? (Неравномерное, периодически ускоряющееся, замедляющееся сердцебиение)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Нащупайте пульс пострадавшего (легче всего на шее или запястье). Присутствует ли аритмия? (Неравномерное, периодически ускоряющееся, замедляющееся сердцебиение)" :
                        algorithm_question.setText("Повышена ли температура тела у пострадавшего? (Приложите в идеале свой лоб/губы ко лбу пострадавшего, или хотя бы запястье, сравните со своей температурой)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Повышено ли слюноотделение?" :
                        algorithm_question.setText("Затруднено ли дыхание?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Затруднено ли дыхание?" :
                        algorithm_question.setText("Присутствует ли боль в животе?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли боль в животе?" :
                        algorithm_question.setText("Присутствует ли судороги, конвульсии, дрожь?");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Присутствует ли обильная потливость? (Стекающий пот, мокрая одежда от пота, выступившие капли пота или просто влажная кожа)" :
                        algorithm_question.setText("Помутнено ли сознание пострадавшего? (Не доконца осознает и воспринимает действительность, отвечает не в попад, у него ярко выраженный бред, не может ответить адекватно на простые вопросы, делает нелогичные действия)");
                        first_action.setText("Да");
                        second_action.setText("Нет");
                        break;
                    case "Помутнено ли сознание пострадавшего? (Не доконца осознает и воспринимает действительность, отвечает не в попад, у него ярко выраженный бред, не может ответить адекватно на простые вопросы, делает нелогичные действия)" :
                        flag = true;
                        algorithm_question.setText("Нащупайте пульс пострадавшего (легче всего на шее или запястье). Включите таймер и посчитайте количество ударов.");
                        // TODO: 13.01.2020 Таймер
                        first_action.setText("Больше 15 ударов");
                        second_action.setText("Меньше 15 ударов");
                        break;
                }

        }
    }
}
