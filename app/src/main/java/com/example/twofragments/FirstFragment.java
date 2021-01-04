package com.example.twofragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;

public class FirstFragment extends Fragment implements Serializable {
    TextView txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        txt = view.findViewById(R.id.txt);
        if (savedInstanceState != null) {
            txt.setText(savedInstanceState.getString("txt", ""));
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("txt", txt.getText().toString());
    }

    public void setTextView(String st) {
        txt.setText(st);

    }
}