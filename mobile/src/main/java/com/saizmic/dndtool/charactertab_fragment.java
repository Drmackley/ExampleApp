package com.saizmic.dndtool;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by drmac on 6/18/2015.
 */
public class charactertab_fragment extends Fragment {

    View rootview;
    ViewPager viewPager;
    ActionBar actionBar;
    tabPagerAdapter adapter;
    Fragment frag1 = new characterstats_fragment();
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        rootview = inflater.inflate(R.layout.charactertab_layout, container, false);
        context = getActivity();
        viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        viewPager.setAdapter(new tabPagerAdapter(getChildFragmentManager()));

        return rootview;


    }
}