package com.practice.firstaid.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.practice.firstaid.R;
import com.practice.firstaid.activity.MainActivity;

public class IVLFragment extends Fragment implements View.OnClickListener {

    private boolean queenHasStarted = false;
    private boolean beeHasStarted = false;
    private MediaPlayer media_bee;
    private MediaPlayer media_queen;
    private SeekBar seekBar_bee;
    private SeekBar seekBar_queen;
    private final Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ivl, null);

        ImageButton play_bee = (ImageButton) view.findViewById(R.id.play_bee);
        ImageButton play_queen = (ImageButton) view.findViewById(R.id.play_queen);
        media_bee = MediaPlayer.create(getActivity(), R.raw.bee);
        media_queen = MediaPlayer.create(getActivity(), R.raw.queen);
        seekBar_bee = (SeekBar) view.findViewById(R.id.seekBar_bee);
        seekBar_queen = (SeekBar) view.findViewById(R.id.seekBar_queen);

        play_bee.setOnClickListener(this);
        play_queen.setOnClickListener(this);

        seekBar_bee.setMax(media_bee.getDuration());
        seekBar_queen.setMax(media_queen.getDuration());

        seekBar_bee.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                seekChange(v, media_bee);
                return false;
            }
        });

        seekBar_queen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                seekChange(v, media_queen);
                return false;
            }
        });


        return view;
    }

    private void seekChange(View v, MediaPlayer mediaPlayer) {
        if (mediaPlayer.isPlaying()) {
            SeekBar sb = (SeekBar) v;
            mediaPlayer.seekTo(sb.getProgress());
        }
    }

    public void startPlayProgressUpdater(SeekBar seekBar, MediaPlayer mediaPlayer) {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());

        if (mediaPlayer.isPlaying()) {
            Runnable notification = new Runnable() {
                public void run() {
                    startPlayProgressUpdater(seekBar, mediaPlayer);
                }
            };
            handler.postDelayed(notification,1000);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_bee:
                if (queenHasStarted) {
                    ((ImageButton)(view.getRootView().findViewById(R.id.play_queen))).setImageResource(R.drawable.ic_play_24dp);
                    media_queen.pause();
                    seekBar_queen.setProgress(0);
                    queenHasStarted = false;
                }
                if (!beeHasStarted) {
                    beeHasStarted = true;
                    ((ImageButton)(view.getRootView().findViewById(R.id.play_bee))).setImageResource(R.drawable.ic_pause_24dp);
                    try{
                        media_bee.start();
                        startPlayProgressUpdater(seekBar_bee, media_bee);
                    }catch (IllegalStateException e) {
                        media_bee.pause();
                    }
                } else
                {
                    ((ImageButton)(view.getRootView().findViewById(R.id.play_bee))).setImageResource(R.drawable.ic_play_24dp);
                    media_bee.pause();
                    seekBar_bee.setProgress(media_bee.getCurrentPosition());
                    beeHasStarted = false;
                }
                break;
            case R.id.play_queen:
                if (beeHasStarted) {
                    ((ImageButton)(view.getRootView().findViewById(R.id.play_bee))).setImageResource(R.drawable.ic_play_24dp);
                    media_bee.pause();
                    seekBar_bee.setProgress(0);
                    beeHasStarted = false;
                }
                if (!queenHasStarted) {
                    queenHasStarted = true;
                    ((ImageButton)(view.getRootView().findViewById(R.id.play_queen))).setImageResource(R.drawable.ic_pause_24dp);
                    try{
                        media_queen.start();
                        startPlayProgressUpdater(seekBar_queen, media_queen);
                    }catch (IllegalStateException e) {
                        media_queen.pause();
                    }
                } else
                {
                    ((ImageButton)(view.getRootView().findViewById(R.id.play_queen))).setImageResource(R.drawable.ic_play_24dp);
                    media_queen.pause();
                    seekBar_queen.setProgress(media_queen.getCurrentPosition());
                    queenHasStarted = false;
                }
                break;

        }
    }
}
