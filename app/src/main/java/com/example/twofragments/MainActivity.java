package com.example.twofragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements SecondFragment.Communicator {
    public static final String FIRST_FRAGMENT = "ftag";
    public static final String SECOND_FRAGMENT = "stag";
    FirstFragment ffragment;
    SecondFragment sfragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            ffragment = (FirstFragment)
                    getSupportFragmentManager().findFragmentByTag(FIRST_FRAGMENT);
            sfragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag(SECOND_FRAGMENT);
        } else {
            sfragment = new SecondFragment();
            ffragment = new FirstFragment();

        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.replace(R.id.containr1, ffragment, FIRST_FRAGMENT);
        trans.replace(R.id.container2, sfragment, SECOND_FRAGMENT);
        trans.commit();

    }

    @Override
    public void print(String str) {
        ffragment.setTextView(str);
    }
}