package xyz.redbooks.kouluni.ui.home;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.ImageListener;

import xyz.redbooks.kouluni.R;
import xyz.redbooks.kouluni.data.AppDataManager;
import xyz.redbooks.kouluni.data.DataManager;

/*
 * Created by h4rdw1r3 at 5:34 PM on 30/7/18
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View homeView;
    private AppDataManager appDataManager;

    private int[] schoolImages = {R.drawable.school1, R.drawable.school2, R.drawable.school3,
        R.drawable.gallery_image1, R.drawable.gallery_image3};

    private static HomePresenter INSTANCE;

    private HomePresenter(HomeContract.View homeView, AppDataManager manager){
        this.homeView = homeView;
        this.homeView.setPresenter(this);
        appDataManager = manager;
    }

    public static HomePresenter getInstance(HomeContract.View homeView, AppDataManager manager) {
        if(INSTANCE == null) {
            INSTANCE = new HomePresenter(homeView, manager);
        }
        return INSTANCE;
    }

    public void updateViewReference(HomeContract.View newHomeView) {
        this.homeView = newHomeView;
        this.homeView.setPresenter(this);
    }

    @Override
    public void start() {
        homeView.setSchoolName(appDataManager.getSchoolName());
        homeView.setSchoolAddress(appDataManager.getSchoolAddress());
        homeView.setSchoolIcon(R.drawable.school_logo);
        homeView.setCarouselImagesPageCount(schoolImages.length);
        homeView.setCarouselImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                Picasso.get().load(schoolImages[position])
                        .into(imageView);
            }
        });
    }

}
