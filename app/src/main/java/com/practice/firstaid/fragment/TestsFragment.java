package com.practice.firstaid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.practice.firstaid.activity.MainActivity;
import com.practice.firstaid.R;

public class TestsFragment extends Fragment implements View.OnClickListener  {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tests, null);

        Button testButton = (Button)view.findViewById(R.id.test);
        testButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        ((MainActivity)getActivity()).loadFragment(new QuestionFragment());
    }
}
