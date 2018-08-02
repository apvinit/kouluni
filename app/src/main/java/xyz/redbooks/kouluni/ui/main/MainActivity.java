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
import xyz.redbooks.kouluni.ui.gallery.GalleryFragment;
import xyz.redbooks.kouluni.ui.gallery.GalleryPresenter;
import xyz.redbooks.kouluni.ui.holidayCalendar.HolidayCalendarFragment;
import xyz.redbooks.kouluni.ui.holidayCalendar.HolidayCalendarPresenter;
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

    //**** ButterKnife View Injection ***************//
    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.nav_view) NavigationView navigationView;

    Fragment fragment;
    FragmentManager fm;

    //************ Presenter for View ****************//
    /* We have to initialize presenter somewhere.
     * We have manually done it.
     * We can also use dependency Injection using any library like dagger2
     */

    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*** Inject ButterKnife ***//
        ButterKnife.bind(this);

        setUpToolBar();

        setUpNavigationDrawer();

        setUpBottomNavigationMenu();

        fm = getSupportFragmentManager();
        fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = HomeFragment.getInstance();
            homePresenter = HomePresenter.getInstance((HomeFragment) fragment);
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();

        }

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
//                                fragment = HomeFragment.getInstance();
//                                HomePresenter.getInstance((HomeFragment) fragment);
//                                homePresenter.updateViewReference((HomeFragment) fragment);
//                                fm.beginTransaction()
//                                        .replace(R.id.fragment_container, fragment)
//                                        .commit();
//                                toolbar.setTitle(R.string.home);
                                setUpHomeMenuItem();
                                item.setChecked(true);
                                break;
                            case R.id.menu_btm_attendance :
                                setUpAttendanceMenu();
                                item.setChecked(true);
                                break;

                            case R.id.menu_btm_parent_message:
                                setUpParentMessageMenu();
                                item.setChecked(true);
                                break;

                            case R.id.menu_btm_profile :
                                setUpProfileMenu();
                                item.setChecked(true);
                                break;
                        }
                        return true;
                    }
                }
        );
    }

    private void setUpToolBar(){
        toolbar.setTitle(R.string.home);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
    }

    private void setUpNavigationDrawer(){
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
                                setUpHomeMenuItem();
                                if(bottomNavigationView.getVisibility() == View.GONE){
                                    bottomNavigationView.setVisibility(View.VISIBLE);
                                }
                                break;

                            case R.id.menu_nd_notice :
                                setUpNoticeMenuItem();
                                break;

                            case R.id.menu_nd_holiday_calendar:
                                setUpHolidayCalendarMenuItem();
                                break;

                            case R.id.menu_nd_contact_us :
                                setUpContactUsMenuItem();
                                break;

                            case R.id.menu_nd_about :
                                setUpAboutMenuItem();
                                break;

                            case R.id.menu_nd_gallery:
                                setUpGalleryMenuItem();
                                break;

                            case R.id.menu_nd_loginOrLogout:
                                setUpLoginOrLogoutMenuItem();
                                break;
                        }

                        return true;
                    }
                });
    }

    private void setUpHomeMenuItem(){
        fragment = HomeFragment.getInstance();
        HomePresenter.getInstance((HomeFragment) fragment);
        homePresenter.updateViewReference((HomeFragment) fragment);
        fm.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();
        toolbar.setTitle(R.string.home);
    }

    private void setUpNoticeMenuItem(){
        NoticePresenter noticePresenter;
        fragment = new NoticeFragment();
        noticePresenter = NoticePresenter.getInstance((NoticeFragment) fragment);
        noticePresenter.updateViewReference((NoticeFragment) fragment);
        fm.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();
        bottomNavigationView.setVisibility(View.GONE);
        toolbar.setTitle(R.string.notice);
    }

    private void setUpHolidayCalendarMenuItem(){
        HolidayCalendarPresenter holidayCalendarPresenter;
        fragment = new HolidayCalendarFragment();
        holidayCalendarPresenter = HolidayCalendarPresenter
                .getInstance((HolidayCalendarFragment) fragment);
        holidayCalendarPresenter.updateViewReference((HolidayCalendarFragment) fragment);
        fm.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();
        toolbar.setTitle(R.string.holiday_calendar);
    }

    private void setUpContactUsMenuItem(){
        fragment = ContactUsFragment.getInstance();
        fm.beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(null).commit();
        toolbar.setTitle(R.string.contact_us);
        ContactPresenter.createInstance((ContactUsFragment) fragment);
    }

    private void setUpGalleryMenuItem(){
        GalleryPresenter galleryPresenter;
        fragment = GalleryFragment.getInstance();
        galleryPresenter = GalleryPresenter.getInstance((GalleryFragment) fragment);
        galleryPresenter.updateViewReference((GalleryFragment) fragment);
        fm.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();
        toolbar.setTitle(R.string.gallery);
    }

    private void setUpAboutMenuItem(){
        AboutPresenter aboutPresenter;
        fragment = AboutFragment.getInstance();
        aboutPresenter = AboutPresenter.getInstance((AboutFragment)fragment);
        aboutPresenter.updateViewReference((AboutFragment) fragment);
        fm.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();
        toolbar.setTitle(R.string.about);
    }

    private void setUpLoginOrLogoutMenuItem(){
        LoginPresenter loginPresenter;
        fragment = new LoginFragment();
        loginPresenter = LoginPresenter.getInstance((LoginFragment) fragment);
        loginPresenter.updateViewReference((LoginFragment) fragment);
        fm.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();
        toolbar.setTitle(R.string.login);
    }

    private void setUpAttendanceMenu(){
        AttendancePresenter attendancePresenter;
        fragment = new AttendanceFragment();
        attendancePresenter = AttendancePresenter.getInstance((AttendanceFragment) fragment);
        attendancePresenter.updateViewReference((AttendanceFragment) fragment);
        fm.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();
        toolbar.setTitle(R.string.attendance);
    }

    private void setUpParentMessageMenu(){
        ParentMessagePresenter parentMessagePresenter;
        fragment = new ParentMessageFragment();
        parentMessagePresenter = ParentMessagePresenter
                .getInstance((ParentMessageFragment) fragment );
        parentMessagePresenter.updateViewReference(
                (ParentMessageFragment) fragment);
        fm.beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(null).commit();
        toolbar.setTitle(R.string.message);
    }

    private void setUpProfileMenu(){
        ProfilePresenter profilePresenter;
        fragment = new ProfileFragment();
        profilePresenter = ProfilePresenter.getInstance((ProfileFragment) fragment);
        profilePresenter.updateViewReference((ProfileFragment) fragment);
        fm.beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(null).commit();
        toolbar.setTitle(R.string.profile);
    }
}
