package com.myapplicationdev.android.demoswiper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> fragments;
    MyFragmentPagerAdapter fragmentPagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager_1);

        // Add Fragments
        fragments = new ArrayList<>();
        fragments.add(new Frag1());
        fragments.add(new Frag2());

        // Init Adapter
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentPagerAdapter = new MyFragmentPagerAdapter(fragmentManager, fragments);

        // Set View Pager's Adapter
        viewPager.setAdapter(fragmentPagerAdapter);
    }
}