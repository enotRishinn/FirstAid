package com.practice.firstaid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.practice.firstaid.R;
import com.practice.firstaid.activity.MainActivity;
import com.practice.firstaid.dialog.CallToAmbulanceDialog;

public class HowToCallDoctorsFragment extends Fragment implements View.OnClickListener  {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_how_to_call_doctors, null);

        Button callDoctorsButton = (Button)view.findViewById(R.id.call_doctors);
        callDoctorsButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        ((MainActivity)getActivity()).callToAmbulance();
    }
}
