package com.example.navigator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment implements View.OnClickListener {

    Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_fragment, container, false);

        btn = (Button) v.findViewById(R.id.secFragGoToFirst);
        btn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.secFragGoToFirst:

                AppCompatActivity activity = (AppCompatActivity) v.getContext();

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FirstFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
