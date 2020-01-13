package com.practice.firstaid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.practice.firstaid.R;
import com.practice.firstaid.activity.MainActivity;

public class BurnFragment extends Fragment implements View.OnClickListener  {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_burn, null);

        Button light_btn = (Button) view.findViewById(R.id.light_btn);
        Button tight_btn = (Button) view.findViewById(R.id.tight_btn);
        Button back = (Button) view.findViewById(R.id.burn_back);
        Button exit = (Button) view.findViewById(R.id.burn_exit);

        light_btn.setOnClickListener(this);
        tight_btn.setOnClickListener(this);
        back.setOnClickListener(this);
        exit.setOnClickListener(this);
        
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.light_btn :
                // TODO: 14.01.2020 Ожог легкой степени (индекс - 20)
                break;
            case R.id.tight_btn :
                // TODO: 14.01.2020 Ожог тяжелой степени (индекс - 21)
                break;
            case R.id.burn_back :
                ((MainActivity)getActivity()).loadFragment(new AlgorithmFragment());
                break;
            case R.id.burn_exit :
                ((MainActivity)getActivity()).loadFragment(new FirstAidFragment());
                break;
        }
    }
}
