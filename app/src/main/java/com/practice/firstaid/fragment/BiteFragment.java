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

public class BiteFragment extends Fragment implements View.OnClickListener  {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bite, null);

        Button ukusos = (Button)view.findViewById(R.id.ukusos);
        Button ukusklecsha = (Button)view.findViewById(R.id.ukusklecsha);
        Button ukuspauka = (Button)view.findViewById(R.id.ukuspauka);
        Button ukuszmei = (Button)view.findViewById(R.id.ukuszmei);
        Button ukusanimal = (Button)view.findViewById(R.id.ukusanimal);
        Button ukusmeduza = (Button)view.findViewById(R.id.ukusmeduza);
        Button back = (Button)view.findViewById(R.id.bite_back);
        Button exit = (Button)view.findViewById(R.id.bite_exit);

        ukusos.setOnClickListener(this);
        ukusklecsha.setOnClickListener(this);
        ukuspauka.setOnClickListener(this);
        ukuszmei.setOnClickListener(this);
        ukusanimal.setOnClickListener(this);
        ukusmeduza.setOnClickListener(this);
        back.setOnClickListener(this);
        exit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ukusos :
                // TODO: 14.01.2020 Укус ос, пчел, шершня (индекс - 31)
                break;
            case R.id.ukusklecsha :
                // TODO: 14.01.2020 Укус клеща (индекс - 29)
                break;
            case R.id.ukuspauka :
                // TODO: 14.01.2020 Укус паука (индекс - 27)
                break;
            case R.id.ukuszmei :
                // TODO: 14.01.2020 Укус змеи (индекс - 26)
                break;
            case R.id.ukusanimal :
                // TODO: 14.01.2020 Укус животного (индекс - 30)
                break;
            case R.id.ukusmeduza :
                // TODO: 14.01.2020 Укус медузы (индекс - 28)
                break;
            case R.id.bite_back :
                ((MainActivity)getActivity()).loadFragment(new AlgorithmFragment());
                break;
            case R.id.bite_exit :
                ((MainActivity)getActivity()).loadFragment(new FirstAidFragment());
                break;
        }
    }
}
