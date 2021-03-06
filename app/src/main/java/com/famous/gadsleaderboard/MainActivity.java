package com.famous.gadsleaderboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;


    private ViewPager viewPager;
    private TabLayout tabLayout;

    private LearningLeaders_Fragment learningFragment;
    private Skill_IQ_Fragment skillIQFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);

        learningFragment = new LearningLeaders_Fragment();
        skillIQFragment = new Skill_IQ_Fragment();


        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewpageradapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewpageradapter.addFragment(learningFragment, "Learning Leaders");
        viewpageradapter.addFragment(skillIQFragment, "Skill IQ Leaders");
        viewPager.setAdapter(viewpageradapter);

    }
    public void submitActivity(View view) {
        Intent intent = new Intent(this, Sumbit_Activity.class);
        startActivity(intent);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentsTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentsTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentsTitle.get(position);
        }
    }
}