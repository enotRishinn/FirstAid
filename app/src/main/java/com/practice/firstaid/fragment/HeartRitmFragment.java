package com.practice.firstaid.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.practice.firstaid.R;
import com.practice.firstaid.data.MalibuCountDownTimer;

public class HeartRitmFragment extends Fragment implements View.OnClickListener {

    private int startTime = 0 * 1000;
    private int interval = 1 * 1000;
    private boolean timerHasStarted = false;
    private MalibuCountDownTimer countDownTimer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_heart_ritm, null);

        TextView time = (TextView) view.findViewById(R.id.time);
        TextView calculated_ritm = (TextView) view.findViewById(R.id.calculated_ritm);
        EditText ritm_in_time = (EditText) view.findViewById(R.id.ritm_in_time);
        Button timer_10 = (Button) view.findViewById(R.id.timer_10);
        Button timer_60 = (Button) view.findViewById(R.id.timer_60);
        Button start = (Button) view.findViewById(R.id.start);
        Button calculate = (Button) view.findViewById(R.id.calculate);

        timer_10.setOnClickListener(this);
        timer_60.setOnClickListener(this);
        start.setOnClickListener(this);
        calculate.setOnClickListener(this);

        ritm_in_time.setText("");
        calculated_ritm.setText("");

        time.setText(time.getText() + String.valueOf(Math.round(startTime / 1000)));

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.timer_10:
                ((LinearLayout)(view.getRootView().findViewById(R.id.linear_timer))).setVisibility(View.VISIBLE);
                ((Button)(view.getRootView().findViewById(R.id.start))).setText("Начать");
                startTime = 10 * 1000;
                ((TextView)(view.getRootView().findViewById(R.id.time))).setText("Время: " + String.valueOf(Math.round(startTime / 1000)));
                if (timerHasStarted) countDownTimer.cancel();
                countDownTimer = new MalibuCountDownTimer(startTime, interval, view.getRootView());
                timerHasStarted = false;
                break;
            case R.id.timer_60:
                ((LinearLayout)(view.getRootView().findViewById(R.id.linear_timer))).setVisibility(View.VISIBLE);
                ((Button)(view.getRootView().findViewById(R.id.start))).setText("Начать");
                startTime = 60 * 1000;
                ((TextView)(view.getRootView().findViewById(R.id.time))).setText("Время: " + String.valueOf(Math.round(startTime / 1000)));
                if (timerHasStarted) countDownTimer.cancel();
                countDownTimer = new MalibuCountDownTimer(startTime, interval, view.getRootView());
                timerHasStarted = false;
                break;
            case R.id.start:
                if (!timerHasStarted) {
                    countDownTimer.start();
                    timerHasStarted = true;
                    ((Button)(view.getRootView().findViewById(R.id.start))).setText("Сбросить");
                }
                else {
                    ((TextView)(view.getRootView().findViewById(R.id.time))).setText("Время: " + String.valueOf(Math.round(startTime / 1000)));
                    countDownTimer.cancel();
                    timerHasStarted = false;
                    ((Button)(view.getRootView().findViewById(R.id.start))).setText("Начать");
                }
                break;
            case R.id.calculate:
                if (!((EditText)(view.getRootView().findViewById(R.id.ritm_in_time))).getText().toString().equals(""))
                    {
                        if (startTime == 10000) {
                            int ritm = 0;
                            try {
                                ritm = Integer.parseInt(((EditText)(view.getRootView().findViewById(R.id.ritm_in_time))).getText().toString());
                            } catch(NumberFormatException nfe) {
                                System.out.println("Could not parse number");
                            }
                            if (ritm != 0) {
                                ritm = ritm * 6;
                                ((TextView)(view.getRootView().findViewById(R.id.calculated_ritm))).setText(ritm + " уд/мин");
                            }

                        }
                        if (startTime == 60000) {
                            int ritm = 0;
                            try {
                                ritm = Integer.parseInt(((EditText)(view.getRootView().findViewById(R.id.ritm_in_time))).getText().toString());
                            } catch(NumberFormatException nfe) {
                                System.out.println("Could not parse number");
                            }
                            if (ritm != 0) {
                                ((TextView)(view.getRootView().findViewById(R.id.calculated_ritm))).setText(ritm + " уд/мин");
                            }

                        }
                    } else {
                    ((TextView)(view.getRootView().findViewById(R.id.calculated_ritm))).setText("");
                }
                break;

        }
    }
}





