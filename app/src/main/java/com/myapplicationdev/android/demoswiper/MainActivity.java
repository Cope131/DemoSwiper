package com.myapplicationdev.android.demoswiper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Fragment> fragments;
    private MyFragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager viewPager;

    private Button backButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager_1);
        backButton = findViewById(R.id.back_button);
        nextButton = findViewById(R.id.next_button);
        backButton.setOnClickListener(this::onClick);
        nextButton.setOnClickListener(this::onClick);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                // Go to Previous Fragment - if previous exists
                Log.d(TAG, "Back Button Pressed");
                Log.d(TAG, "Item: " + viewPager.getCurrentItem());
                if (viewPager.getCurrentItem() > 0) {
                    int previousPage = viewPager.getCurrentItem() - 1;
                    viewPager.setCurrentItem(previousPage, true);
                }
                break;
            case R.id.next_button:
                // Go to Next Fragment - if next exists
                Log.d(TAG, "Next Button Pressed");
                Log.d(TAG, "Item: " + viewPager.getCurrentItem());
                int max = viewPager.getChildCount();
                if (viewPager.getCurrentItem() < max - 1) {
                    int nextPage = viewPager.getCurrentItem() + 1;
                    viewPager.setCurrentItem(nextPage, true);
                }

        }
    }
}