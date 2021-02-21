package com.example.droidcafe;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment implements View.OnClickListener {


    ImageView dnut;
    ImageView ice;
    ImageView froyo;
    TextView dtext;
    TextView itext;
    TextView ftext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_fragment, container, false);

        dnut = (ImageView) v.findViewById(R.id.donut);
        dnut.setOnClickListener(this);
        ice = (ImageView) v.findViewById(R.id.icecream);
        ice.setOnClickListener(this);
        froyo = (ImageView) v.findViewById(R.id.froyo);
        froyo.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.donut:
                break;
            case R.id.icecream:
                break;
            case R.id.froyo:
                break;
        }
    }
}
