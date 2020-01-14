package com.practice.firstaid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.practice.firstaid.R;
import com.practice.firstaid.data.aid_data.AidInstructions;
import com.practice.firstaid.data.aid_data.Problem;

import java.util.ArrayList;

public class ManualFragment extends Fragment {
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
            if (i.decription.indexOf(search.toString()) > 0 || i.decription.indexOf(search.toString()) > 0 ) {

            }
        }

        manual_list.addView(manualList);

        return view;
    }
}
