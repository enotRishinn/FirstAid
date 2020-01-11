package com.practice.firstaid.data;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.practice.firstaid.R;

public class MalibuCountDownTimer extends CountDownTimer {
    private View view;

    public MalibuCountDownTimer(long startTime, long interval, View view) {
        super(startTime, interval);
        this.view = view;
    }

    @Override
    public void onFinish() {
        ((TextView)(view.getRootView().findViewById(R.id.time))).setText("Время вышло!");
    }

    @Override
    public void onTick(long millisUntilFinished) {
        ((TextView)(view.getRootView().findViewById(R.id.time))).setText("Время: " + Math.round(millisUntilFinished / 1000));
    }
}