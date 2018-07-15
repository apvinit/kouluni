package xyz.redbooks.koulini.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import xyz.redbooks.koulini.ui.GalleryFragment;
import xyz.redbooks.koulini.ui.InfoFragment;

public class AboutTabsViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int noOfTabs = 2;

    public AboutTabsViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new InfoFragment();
        }
        if(position == 1){
            return new GalleryFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "Info";
        if(position == 1)
            return "Gallery";

        return null;
    }
}
