package com.example.fragmentdemo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmentdemo.R;


public class MyFragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my1, container, false);

        Button switchButton = view.findViewById(R.id.switchFragmentButton);
        Button guideButton = view.findViewById(R.id.guideButton);

        // Chuyển sang Fragment2 khi nhấn nút
        switchButton.setOnClickListener(v -> {
            Fragment fragment = new MyFragment2();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        // Hiển thị/ẩn GuideFragment tĩnh khi nhấn nút Hướng dẫn
        guideButton.setOnClickListener(v -> {
            View guideFragment = getActivity().findViewById(R.id.guideFragment);
            if (guideFragment.getVisibility() == View.GONE) {
                guideFragment.setVisibility(View.VISIBLE); // Hiện GuideFragment
            } else {
                guideFragment.setVisibility(View.GONE); // Ấn GuideFragment
            }
        });

        return view;
    }

}