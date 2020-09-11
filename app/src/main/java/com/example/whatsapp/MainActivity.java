package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);


        viewPager2.setAdapter(new PagerAdapter(this));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Chat");
                        BadgeDrawable drawable = tab.getOrCreateBadge();
                        drawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                        drawable.setVisible(true);
                        drawable.setNumber(5);
                        drawable.setBadgeTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                        break;
                    case 1:
                        tab.setText("Status");
                        break;
                    case 2:
                        tab.setText("Call");

                        break;
                }
            }
        });
        tabLayoutMediator.attach();
    }
}