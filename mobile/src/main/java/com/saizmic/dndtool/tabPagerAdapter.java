package com.saizmic.dndtool;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by drmac on 6/19/2015.
 */
class tabPagerAdapter extends FragmentPagerAdapter {
    public tabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new characterstats_fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
