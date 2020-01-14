package com.practice.firstaid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.practice.firstaid.R;
import com.practice.firstaid.activity.MainActivity;
import com.practice.firstaid.data.aid_data.AidInstructions;

public class ManualPageFragment extends Fragment implements View.OnClickListener {

    AidInstructions aidInstructions = new AidInstructions();
    Integer id;

    ManualPageFragment(Integer id) {
        this.id = id;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manual_page, null);

        TextView result_name = (TextView)view.findViewById(R.id.manual_page_name);
        TextView description = (TextView)view.findViewById(R.id.descriprion);
        ImageView description_img = (ImageView)view.findViewById(R.id.description_img);
        TextView symptoms = (TextView)view.findViewById(R.id.symptoms);
        TextView first_block = (TextView)view.findViewById(R.id.first_block_manual);
        ImageView first_image = (ImageView)view.findViewById(R.id.first_image_manual);
        TextView second_block = (TextView)view.findViewById(R.id.second_block_manual);
        ImageView second_image = (ImageView)view.findViewById(R.id.second_image_manual);
        TextView third_block = (TextView)view.findViewById(R.id.third_block_manual);
        ImageView third_image = (ImageView)view.findViewById(R.id.third_image_manual);
        TextView fourth_block = (TextView)view.findViewById(R.id.fourth_block_manual);

        Button back_button = (Button)view.findViewById(R.id.manual_back);
        Button exit_button = (Button)view.findViewById(R.id.manual_exit);

        back_button.setOnClickListener(this);
        exit_button.setOnClickListener(this);

        result_name.setText(aidInstructions.problems.get(id).name);

        switch (aidInstructions.problems.get(id).blocks) {
            case 1 :
                description.setVisibility(View.VISIBLE);
                description.setText(aidInstructions.problems.get(id).decription);
                if (!aidInstructions.problems.get(id).descriptionImgUrl.equals("")) {
                    description_img.setVisibility(View.VISIBLE);
                    Context context = description_img.getContext();
                    int temp_id = context.getResources().getIdentifier(aidInstructions.problems.get(id).descriptionImgUrl, "drawable", context.getPackageName());
                    description_img.setImageResource(temp_id);
                }
                symptoms.setVisibility(View.VISIBLE);
                symptoms.setText(aidInstructions.problems.get(id).symptoms);
                first_block.setVisibility(View.VISIBLE);
                first_block.setText(aidInstructions.problems.get(id).firstBlock);
                break;
            case 2 :
                description.setVisibility(View.VISIBLE);
                description.setText(aidInstructions.problems.get(id).decription);
                if (!aidInstructions.problems.get(id).descriptionImgUrl.equals("")) {
                    description_img.setVisibility(View.VISIBLE);
                    Context context = description_img.getContext();
                    int temp_id = context.getResources().getIdentifier(aidInstructions.problems.get(id).descriptionImgUrl, "drawable", context.getPackageName());
                    description_img.setImageResource(temp_id);
                }
                symptoms.setVisibility(View.VISIBLE);
                symptoms.setText(aidInstructions.problems.get(id).symptoms);
                first_block.setVisibility(View.VISIBLE);
                first_block.setText(aidInstructions.problems.get(id).firstBlock);
                first_image.setVisibility(View.VISIBLE);
                if (aidInstructions.problems.get(id).firstImgUrl == "appendicit1") {
                    first_image.setImageResource(R.drawable.appendicit1);
                } else {
                    first_image.setImageResource(R.drawable.sotrysenie1);
                }
                break;
            case 3 :
                description.setVisibility(View.VISIBLE);
                description.setText(aidInstructions.problems.get(id).decription);
                if (!aidInstructions.problems.get(id).descriptionImgUrl.equals("")) {
                    description_img.setVisibility(View.VISIBLE);
                    Context context = description_img.getContext();
                    int temp_id = context.getResources().getIdentifier(aidInstructions.problems.get(id).descriptionImgUrl, "drawable", context.getPackageName());
                    description_img.setImageResource(temp_id);
                }
                symptoms.setVisibility(View.VISIBLE);
                symptoms.setText(aidInstructions.problems.get(id).symptoms);
                first_block.setVisibility(View.VISIBLE);
                first_block.setText(aidInstructions.problems.get(id).firstBlock);
                first_image.setVisibility(View.VISIBLE);
                switch (aidInstructions.problems.get(id).firstImgUrl) {
                    case "ushib1.jpg" :
                        first_image.setImageResource(R.drawable.ushib1);
                        break;
                    case "ojoglegkiy1.jpg" :
                        first_image.setImageResource(R.drawable.o);
                        break;
                }
                second_block.setVisibility(View.VISIBLE);
                second_block.setText(aidInstructions.problems.get(id).secondBlock);
                break;
            case 5 :
                description.setVisibility(View.VISIBLE);
                description.setText(aidInstructions.problems.get(id).decription);
                if (!aidInstructions.problems.get(id).descriptionImgUrl.equals("")) {
                    description_img.setVisibility(View.VISIBLE);
                    Context context = description_img.getContext();
                    int temp_id = context.getResources().getIdentifier(aidInstructions.problems.get(id).descriptionImgUrl, "drawable", context.getPackageName());
                    description_img.setImageResource(temp_id);
                }
                symptoms.setVisibility(View.VISIBLE);
                symptoms.setText(aidInstructions.problems.get(id).symptoms);
                first_block.setVisibility(View.VISIBLE);
                first_block.setText(aidInstructions.problems.get(id).firstBlock);
                first_image.setVisibility(View.VISIBLE);
                second_block.setVisibility(View.VISIBLE);
                second_block.setText(aidInstructions.problems.get(id).secondBlock);
                second_image.setVisibility(View.VISIBLE);
                third_block.setVisibility(View.VISIBLE);
                third_block.setText(aidInstructions.problems.get(id).thirdBlock);
                switch (aidInstructions.problems.get(id).firstImgUrl) {
                    case "sdavlivanie1.jpg" :
                        first_image.setImageResource(R.drawable.sdavlivanie1);
                        second_image.setImageResource(R.drawable.sdavlivanie2);
                        break;
                    case "rana1.jpg" :
                        first_image.setImageResource(R.drawable.rana1);
                        second_image.setImageResource(R.drawable.rana2);
                        break;
                    case "vivih1.jpg" :
                        first_image.setImageResource(R.drawable.vivih1);
                        second_image.setImageResource(R.drawable.vivih2);
                        break;
                }
                break;
            case 7 :
                description.setVisibility(View.VISIBLE);
                description.setText(aidInstructions.problems.get(id).decription);
                if (!aidInstructions.problems.get(id).descriptionImgUrl.equals("")) {
                    description_img.setVisibility(View.VISIBLE);
                    Context context = description_img.getContext();
                    int temp_id = context.getResources().getIdentifier(aidInstructions.problems.get(id).descriptionImgUrl, "drawable", context.getPackageName());
                    description_img.setImageResource(temp_id);
                }
                symptoms.setVisibility(View.VISIBLE);
                symptoms.setText(aidInstructions.problems.get(id).symptoms);
                first_block.setVisibility(View.VISIBLE);
                first_block.setText(aidInstructions.problems.get(id).firstBlock);
                first_image.setVisibility(View.VISIBLE);
                first_image.setImageResource(R.drawable.vivih1);
                second_block.setVisibility(View.VISIBLE);
                second_block.setText(aidInstructions.problems.get(id).secondBlock);
                second_image.setVisibility(View.VISIBLE);
                second_image.setImageResource(R.drawable.perelom2);
                third_block.setVisibility(View.VISIBLE);
                third_block.setText(aidInstructions.problems.get(id).thirdBlock);
                third_image.setVisibility(View.VISIBLE);
                third_image.setImageResource(R.drawable.vivih2);
                fourth_block.setVisibility(View.VISIBLE);
                fourth_block.setText(aidInstructions.problems.get(id).fourthBlock);
                break;
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.manual_back :
                ((MainActivity)getActivity()).loadFragment(new ManualFragment());
                break;
            case R.id.manual_exit :
                ((MainActivity)getActivity()).loadFragment(new FirstAidFragment());
                break;
        }
    }
}