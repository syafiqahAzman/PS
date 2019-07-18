package webservices.rp.edu.ps;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button btnLater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = findViewById(R.id.viewpager1);
        btnLater = findViewById(R.id.btnLater);


        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());
        al.add(new Frag3());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_prev) {
            if (vPager.getCurrentItem() > 0){
                int previousPage = vPager.getCurrentItem() - 1;
                vPager.setCurrentItem(previousPage, true);
            }
            return true;
        }

        if (id == R.id.menu_random){
            int max = vPager.getChildCount();
            Random random = new Random();
            if (vPager.getCurrentItem() > 0){
                int randomPage = vPager.getCurrentItem() - random.nextInt(5);
                vPager.setCurrentItem(randomPage, true);
            }
            else if(vPager.getCurrentItem() < max - 1){
                int randomPage = vPager.getCurrentItem() + random.nextInt(5);
                vPager.setCurrentItem(randomPage, true);
            }
            return true;
        }
        if (id == R.id.menu_next) {
            int max = vPager.getChildCount();

            if (vPager.getCurrentItem() < max - 1) {
                int nextPage = vPager.getCurrentItem() + 1;
                vPager.setCurrentItem(nextPage, true);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
