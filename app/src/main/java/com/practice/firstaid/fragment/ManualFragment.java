package com.practice.firstaid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.practice.firstaid.R;
import com.practice.firstaid.activity.MainActivity;
import com.practice.firstaid.data.aid_data.AidInstructions;
import com.practice.firstaid.data.aid_data.Problem;

import java.util.ArrayList;

public class ManualFragment extends Fragment implements View.OnClickListener {
    ArrayList<View> manualList = new ArrayList<>();
    AidInstructions aidInstructions = new AidInstructions();
    int counter = 0;
    String for_search;

    public ManualFragment() {
        this.for_search = " ";
    }

    ManualFragment(String for_search) {
        this.for_search = for_search;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_manual, null);

        ImageButton search_button = (ImageButton) view.findViewById(R.id.search_button);
        search_button.setOnClickListener(this);

        final LinearLayout manual_list = (LinearLayout) view.findViewById(R.id.manual_list);
        EditText search = (EditText) view.findViewById(R.id.search);


        for (Problem i : aidInstructions.problems) {

            final int temp = counter;
            if (i.decription.indexOf(for_search) > 0 || i.firstBlock.indexOf(for_search) > 0 || i.secondBlock.indexOf(for_search) > 0 || i.thirdBlock.indexOf(for_search) > 0 || i.fourthBlock.indexOf(for_search) > 0 || i.symptoms.indexOf(for_search) > 0) {
                final View v = getLayoutInflater().inflate(R.layout.temp_layout, null);
                Button name = (Button) v.findViewById(R.id.name);
                name.setText(i.name);
                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((MainActivity)getActivity()).loadFragment(new ManualPageFragment(temp));
                    }
                });
                manual_list.addView(v);
            }
            counter++;
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        TextView search_text = (TextView) view.getRootView().findViewById(R.id.search);
        String search_string = search_text.getText().toString();
        if (search_string.equals("")) {
            search_string = " ";
        }
        ((MainActivity)getActivity()).loadFragment(new ManualFragment(search_string));
    }
}
