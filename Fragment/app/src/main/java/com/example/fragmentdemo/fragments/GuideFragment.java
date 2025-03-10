package com.example.fragmentdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentdemo.R;

public class GuideFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);

        TextView guideText = view.findViewById(R.id.guideText);
        guideText.setText("Đây là GuideFragment tĩnh:\n1. Được gắn trực tiếp trong XML.\n2. Không thay đổi trong runtime.");

        Button closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> {
            // Ẩn fragment tĩnh
            View guideFragment = getActivity().findViewById(R.id.guideFragment);
            guideFragment.setVisibility(View.GONE);

            // Khi đóng GuideFragment, hiện lại MyFragment1
            Fragment fragment = new MyFragment1();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, fragment);
            transaction.commit();
        });


        return view;
    }
}
