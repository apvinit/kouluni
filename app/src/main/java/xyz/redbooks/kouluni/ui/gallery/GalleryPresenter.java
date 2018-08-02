package xyz.redbooks.kouluni.ui.gallery;

import android.support.v7.widget.GridLayoutManager;

/*
 * Created by h4rdw1r3 at 11:32 AM on 2/8/18
 */
public class GalleryPresenter implements GalleryContract.Presenter {

    private GalleryContract.View galleryView;
    private static GalleryPresenter INSTANCE;

    private GalleryPresenter(GalleryContract.View view){
        galleryView = view;
        galleryView.setPresenter(this);
    }

    public static GalleryPresenter getInstance(GalleryContract.View view){
        if(INSTANCE == null)
            INSTANCE = new GalleryPresenter(view);
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
