package com.practice.firstaid.fragment;

import android.os.Bundle;
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
import com.practice.firstaid.data.aid_data.AidInstructions;
import com.practice.firstaid.data.aid_data.Problem;

import java.util.ArrayList;

public class ManualFragment extends Fragment implements View.OnClickListener {
    ArrayList<View> manualList = new ArrayList<>();
    AidInstructions aidInstructions = new AidInstructions();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_manual, null);

        final LinearLayout manual_list = (LinearLayout) view.findViewById(R.id.manual_list);
        EditText search = (EditText) view.findViewById(R.id.search);

        for (Problem i : aidInstructions.problems) {
        //    if (i.decription.indexOf(search.toString()) > 0 || i.firstBlock.indexOf(search.toString()) > 0 || i.secondBlock.indexOf(search.toString()) > 0 || i.thirdBlock.indexOf(search.toString()) > 0 || i.fourthBlock.indexOf(search.toString()) > 0 || i.symptoms.indexOf(search.toString()) > 0) {
                final View v = getLayoutInflater().inflate(R.layout.temp_layout, null);
                Button name = (Button) v.findViewById(R.id.name);
                name.setText(i.name);
                manual_list.addView(v);
          //  }
        }

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
