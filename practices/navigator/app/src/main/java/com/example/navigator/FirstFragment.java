package com.example.navigator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment implements View.OnClickListener{

    Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_fragment, container, false);

        btn = (Button) v.findViewById(R.id.firstFragGoToSec);
        btn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.firstFragGoToSec:
                AppCompatActivity activity = (AppCompatActivity)v.getContext();

                //this commented line is used for the window gets smaller when the keyboard get activated
//                activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new SecondFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
