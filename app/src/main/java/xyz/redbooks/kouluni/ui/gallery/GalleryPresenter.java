package xyz.redbooks.kouluni.ui.gallery;

import androidx.recyclerview.widget.GridLayoutManager;

import xyz.redbooks.kouluni.data.AppDataManager;

/*
 * Created by h4rdw1r3 at 11:32 AM on 2/8/18
 */
public class GalleryPresenter implements GalleryContract.Presenter {

    private GalleryContract.View galleryView;
    private AppDataManager appDataManager;
    private static GalleryPresenter INSTANCE;

    private GalleryPresenter(GalleryContract.View view, AppDataManager manager){
        galleryView = view;
        galleryView.setPresenter(this);
        appDataManager = manager;
    }

    public static GalleryPresenter getInstance(GalleryContract.View view, AppDataManager manager){
        if(INSTANCE == null)
            INSTANCE = new GalleryPresenter(view, manager);
        return INSTANCE;
    }

    public void updateViewReference(GalleryContract.View view){
        galleryView = view;
        galleryView.setPresenter(this);
    }

    @Override
    public void start() {
        galleryView.setLayoutManager(new GridLayoutManager(
                galleryView.giveContext(), 2));
        galleryView.setAdapter(new GalleryAdapter());
    }


}
