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

public class FirstAidFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first_aid, null);

        Button how_to_call_doctors = (Button) view.findViewById(R.id.how_to_call_doctors);
        Button heart_ritm = (Button) view.findViewById(R.id.heart_ritm);
        Button ivl = (Button) view.findViewById(R.id.ivl);
        Button dont_know_what_happen = (Button) view.findViewById(R.id.dont_know_what_happen);

        how_to_call_doctors.setOnClickListener(this);
        heart_ritm.setOnClickListener(this);
        ivl.setOnClickListener(this);
        dont_know_what_happen.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.how_to_call_doctors:
                ((MainActivity)getActivity()).loadFragment(new HowToCallDoctorsFragment());
                break;
            case R.id.heart_ritm:
                ((MainActivity)getActivity()).loadFragment(new HeartRitmFragment());
                break;
            case R.id.ivl:
                ((MainActivity)getActivity()).loadFragment(new IVLFragment());
                break;
            case R.id.dont_know_what_happen:
                ((MainActivity)getActivity()).loadFragment(new AlgorithmFragment());
                break;

        }
    }
}

