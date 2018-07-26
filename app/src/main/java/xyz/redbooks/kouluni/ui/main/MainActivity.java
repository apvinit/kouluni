package xyz.redbooks.kouluni.ui.main;

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

import xyz.redbooks.kouluni.R;
import xyz.redbooks.kouluni.ui.about.AboutFragment;
import xyz.redbooks.kouluni.ui.user.attendance.AttendanceFragment;
import xyz.redbooks.kouluni.ui.contact.ContactUsFragment;
import xyz.redbooks.kouluni.ui.gallery.GalleryFragment;
import xyz.redbooks.kouluni.ui.holidayCalendar.HolidayCalendarFragment;
import xyz.redbooks.kouluni.ui.home.HomeFragment;
import xyz.redbooks.kouluni.ui.user.login.LoginFragment;
import xyz.redbooks.kouluni.ui.notice.NoticeFragment;
import xyz.redbooks.kouluni.ui.user.parentMessage.ParentMessageFragment;
import xyz.redbooks.kouluni.ui.user.profile.ProfileFragment;

/**
 * Created by h4rdw1r3
 */

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;

    Fragment fragment;
    FragmentManager fm;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.home);
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
                            toolbar.setTitle(R.string.home);
                            break;

                        case R.id.menu_nd_notice :
                            fragment = new NoticeFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            bottomNavigationView.setVisibility(View.GONE);
                            toolbar.setTitle(R.string.notice);
                            break;

                        case R.id.menu_nd_holiday_calendar:
                            fragment = new HolidayCalendarFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            toolbar.setTitle(R.string.holiday_calendar);
                            break;

                        case R.id.menu_nd_contact_us :
                            fragment = new ContactUsFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .addToBackStack(null).commit();
                            toolbar.setTitle(R.string.contact_us);
                            break;

                        case R.id.menu_nd_about :
                            fragment = new AboutFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            toolbar.setTitle(R.string.about);
                            break;
                        case R.id.menu_nd_gallery:
                            fragment = new GalleryFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            toolbar.setTitle(R.string.gallery);
                            break;
                        case R.id.menu_nd_loginOrLogout:
                            fragment = new LoginFragment();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            toolbar.setTitle(R.string.login);
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
                                toolbar.setTitle(R.string.home);
                                break;
                            case R.id.menu_btm_attendance :
                                fragment = new AttendanceFragment();
                                fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                        .addToBackStack(null).commit();
                                item.setChecked(true);
                                toolbar.setTitle(R.string.attendance);
                                break;

                            case R.id.menu_btm_parent_message:
                                fragment = new ParentMessageFragment();
                                fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                        .addToBackStack(null).commit();
                                item.setChecked(true);
                                toolbar.setTitle(R.string.message);
                                break;

                            case R.id.menu_btm_profile :
                                fragment = new ProfileFragment();
                                fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                        .addToBackStack(null).commit();
                                item.setChecked(true);
                                toolbar.setTitle(R.string.profile);
                                break;
                        }
                        return true;
                    }
                }
        );
    }
}
