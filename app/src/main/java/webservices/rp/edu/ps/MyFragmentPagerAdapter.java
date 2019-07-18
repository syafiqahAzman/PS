package webservices.rp.edu.ps;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment>al){
        super(fm);
        fragments = al;
    }

    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    public int getCount(){
        return fragments.size();
    }


}
