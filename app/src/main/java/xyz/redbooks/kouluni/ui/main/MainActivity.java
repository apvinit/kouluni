package xyz.redbooks.kouluni.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.redbooks.kouluni.R;
import xyz.redbooks.kouluni.ui.about.AboutFragment;
import xyz.redbooks.kouluni.ui.about.AboutPresenter;
import xyz.redbooks.kouluni.ui.contact.ContactPresenter;
import xyz.redbooks.kouluni.ui.contact.ContactUsFragment;
import xyz.redbooks.kouluni.ui.gallery.GalleryContract;
import xyz.redbooks.kouluni.ui.gallery.GalleryFragment;
import xyz.redbooks.kouluni.ui.gallery.GalleryPresenter;
import xyz.redbooks.kouluni.ui.holidayCalendar.HolidayCalendarContract;
import xyz.redbooks.kouluni.ui.holidayCalendar.HolidayCalendarFragment;
import xyz.redbooks.kouluni.ui.holidayCalendar.HolidayCalendarPresenter;
import xyz.redbooks.kouluni.ui.home.HomeContract;
import xyz.redbooks.kouluni.ui.home.HomeFragment;
import xyz.redbooks.kouluni.ui.home.HomePresenter;
import xyz.redbooks.kouluni.ui.notice.NoticeFragment;
import xyz.redbooks.kouluni.ui.notice.NoticePresenter;
import xyz.redbooks.kouluni.ui.user.attendance.AttendanceFragment;
import xyz.redbooks.kouluni.ui.user.attendance.AttendancePresenter;
import xyz.redbooks.kouluni.ui.user.login.LoginFragment;
import xyz.redbooks.kouluni.ui.user.login.LoginPresenter;
import xyz.redbooks.kouluni.ui.user.parentMessage.ParentMessageFragment;
import xyz.redbooks.kouluni.ui.user.parentMessage.ParentMessagePresenter;
import xyz.redbooks.kouluni.ui.user.profile.ProfileFragment;
import xyz.redbooks.kouluni.ui.user.profile.ProfilePresenter;

/**
 * Created by h4rdw1r3
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.nav_view) NavigationView navigationView;

    Fragment fragment;
    FragmentManager fm;

    private HomePresenter homePresenter;
    private GalleryPresenter galleryPresenter;
    private HolidayCalendarPresenter holidayCalendarPresenter;
    private NoticePresenter noticePresenter;
    private ParentMessagePresenter parentMessagePresenter;
    private LoginPresenter loginPresenter;
    private AttendancePresenter attendancePresenter;
    private ProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inject ButterKnife
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.home);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

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
                            fragment = HomeFragment.getInstance();
                            HomePresenter.getInstance((HomeFragment) fragment);
                            homePresenter.updateViewReference((HomeFragment) fragment);
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            if(bottomNavigationView.getVisibility() == View.GONE){
                                bottomNavigationView.setVisibility(View.VISIBLE);
                            }
                            toolbar.setTitle(R.string.home);
                            break;

                        case R.id.menu_nd_notice :
                            fragment = new NoticeFragment();
                            noticePresenter = NoticePresenter.getInstance((NoticeFragment) fragment);
                            noticePresenter.updateViewReference((NoticeFragment) fragment);
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            bottomNavigationView.setVisibility(View.GONE);
                            toolbar.setTitle(R.string.notice);
                            break;

                        case R.id.menu_nd_holiday_calendar:
                            fragment = new HolidayCalendarFragment();
                            holidayCalendarPresenter = HolidayCalendarPresenter.getInstance((HolidayCalendarFragment) fragment);
                            holidayCalendarPresenter.updateViewReference((HolidayCalendarFragment) fragment);
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            toolbar.setTitle(R.string.holiday_calendar);
                            break;

                        case R.id.menu_nd_contact_us :
                            fragment = ContactUsFragment.getInstance();
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .addToBackStack(null).commit();
                            toolbar.setTitle(R.string.contact_us);
                            ContactPresenter.createInstance((ContactUsFragment) fragment);
                            break;

                        case R.id.menu_nd_about :
                            fragment = AboutFragment.getInstance();

                            //Create Presenter and Pass View to it
                            AboutPresenter.createInstance((AboutFragment)fragment);
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            toolbar.setTitle(R.string.about);
                            break;
                        case R.id.menu_nd_gallery:
                            fragment = GalleryFragment.getInstance();
                            galleryPresenter = GalleryPresenter.getInstance((GalleryFragment) fragment);
                            galleryPresenter.updateViewReference((GalleryFragment) fragment);
                            fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                    .commit();
                            toolbar.setTitle(R.string.gallery);
                            break;
                        case R.id.menu_nd_loginOrLogout:
                            fragment = new LoginFragment();
                            loginPresenter = LoginPresenter.getInstance((LoginFragment) fragment);
                            loginPresenter.updateViewReference((LoginFragment) fragment);
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
            fragment = HomeFragment.getInstance();
            homePresenter = HomePresenter.getInstance((HomeFragment) fragment);
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
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menu_btm_home:
                                fragment = HomeFragment.getInstance();
                                HomePresenter.getInstance((HomeFragment) fragment);
                                homePresenter.updateViewReference((HomeFragment) fragment);
                                fm.beginTransaction()
                                        .replace(R.id.fragment_container, fragment)
                                        .commit();
                                item.setChecked(true);
                                toolbar.setTitle(R.string.home);
                                break;
                            case R.id.menu_btm_attendance :
                                fragment = new AttendanceFragment();
                                attendancePresenter = AttendancePresenter.getInstance((AttendanceFragment) fragment);
                                attendancePresenter.updateViewReference((AttendanceFragment) fragment);
                                fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                        .addToBackStack(null).commit();
                                item.setChecked(true);
                                toolbar.setTitle(R.string.attendance);
                                break;

                            case R.id.menu_btm_parent_message:
                                fragment = new ParentMessageFragment();
                                parentMessagePresenter = ParentMessagePresenter
                                        .getInstance((ParentMessageFragment) fragment );
                                parentMessagePresenter.updateViewReference(
                                        (ParentMessageFragment) fragment);
                                fm.beginTransaction().replace(R.id.fragment_container, fragment)
                                        .addToBackStack(null).commit();
                                item.setChecked(true);
                                toolbar.setTitle(R.string.message);
                                break;

                            case R.id.menu_btm_profile :
                                fragment = new ProfileFragment();
                                profilePresenter = ProfilePresenter.getInstance((ProfileFragment) fragment);
                                profilePresenter.updateViewReference((ProfileFragment) fragment);
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
