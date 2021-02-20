package com.example.droidcafe2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    public FirstFragment(){
        super(R.layout.first_fragment);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, ExampleFragment.class, null)
                    .commit();
        }
    }
}
