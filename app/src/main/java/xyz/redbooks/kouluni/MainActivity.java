package xyz.redbooks.kouluni;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import xyz.redbooks.kouluni.ui.AboutFragment;
import xyz.redbooks.kouluni.ui.AttendanceFragment;
import xyz.redbooks.kouluni.ui.ContactUsFragment;
import xyz.redbooks.kouluni.ui.GalleryFragment;
import xyz.redbooks.kouluni.ui.HolidayCalendarFragment;
import xyz.redbooks.kouluni.ui.HomeFragment;
import xyz.redbooks.kouluni.ui.NoticeFragment;
import xyz.redbooks.kouluni.ui.ParentMessageFragment;
import xyz.redbooks.kouluni.ui.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;

    Fragment fragment;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    // set item as selected to persist highlight
                    menuItem.setChecked(true);
                    // close drawer when item is tapped
                    drawerLayout.closeDrawers();

                    // Add code here to update the UI based on the item selected
                    // swap UI fragments here
                    switch (menuItem.getItemId()){

                        case R.id.menu_nd_home :
                            fragment = new HomeFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            if(bottomNavigationView.getVisibility() == View.GONE){
                                bottomNavigationView.setVisibility(View.VISIBLE);
                            }
                            break;

                        case R.id.menu_nd_notice :
                            fragment = new NoticeFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            bottomNavigationView.setVisibility(View.GONE);
                            break;

                        case R.id.menu_nd_holiday_calendar:
                            fragment = new HolidayCalendarFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            break;

                        case R.id.menu_nd_contact_us :
                            fragment = new ContactUsFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .addToBackStack(null).commit();
                            break;

                        case R.id.menu_nd_about :
                            fragment = new AboutFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            break;
                        case R.id.menu_nd_gallery:
                            fragment = new GalleryFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                    }

                    return true;
                }
            });

        fm = getSupportFragmentManager();
        fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new HomeFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();

        }

        setUpBottomNavigationMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.menu_main_notification :
                Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void setUpBottomNavigationMenu(){
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menu_btm_home:
                                fragment = new HomeFragment();
                                fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                        .commit();
                                item.setChecked(true);
                                break;
                            case R.id.menu_btm_attendance :
                                fragment = new AttendanceFragment();
                                fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                        .addToBackStack(null).commit();
                                item.setChecked(true);
                                break;

                            case R.id.menu_btm_parent_message:
                                fragment = new ParentMessageFragment();
                                fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                        .addToBackStack(null).commit();
                                item.setChecked(true);
                                break;

                            case R.id.menu_btm_profile :
                                fragment = new ProfileFragment();
                                fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                        .addToBackStack(null).commit();
                                item.setChecked(true);
                                break;
                        }
                        return true;
                    }
                }
        );
    }
}
