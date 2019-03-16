package com.certuit.agroapp.util;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private FragmentManager fragmentManager;

    public TabsAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmentManager = fm;
        this.fragments = fragments;
    }

    public void clearAll() {
        for (int i = 0; i < fragments.size(); i++) {
            fragmentManager.beginTransaction().remove(fragments.get(i));
            fragments.clear();
        }
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
}
