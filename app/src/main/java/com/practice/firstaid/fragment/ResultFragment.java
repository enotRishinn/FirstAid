package com.practice.firstaid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.practice.firstaid.R;
import com.practice.firstaid.data.aid_data.AidInstructions;

public class ResultFragment extends Fragment implements View.OnClickListener{
    final AidInstructions aidInstructions = new AidInstructions();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, null);

        TextView result_name = (TextView)view.findViewById(R.id.result_name);
        TextView first_block = (TextView)view.findViewById(R.id.first_block);
        ImageView first_image = (ImageView)view.findViewById(R.id.first_image);
        TextView second_block = (TextView)view.findViewById(R.id.second_block);
        ImageView second_image = (ImageView)view.findViewById(R.id.second_image);
        TextView third_block = (TextView)view.findViewById(R.id.third_block);
        ImageView third_image = (ImageView)view.findViewById(R.id.third_image);
        TextView fourth_block = (TextView)view.findViewById(R.id.fourth_block);
        Button back_button = (Button)view.findViewById(R.id.back);
        Button exit_button = (Button)view.findViewById(R.id.exit);

        back_button.setOnClickListener(this);
        exit_button.setOnClickListener(this);



        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View view) {

    }
}
