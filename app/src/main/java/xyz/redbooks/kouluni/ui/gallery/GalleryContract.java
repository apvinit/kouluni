package xyz.redbooks.kouluni.ui.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import xyz.redbooks.kouluni.ui.base.BasePresenter;
import xyz.redbooks.kouluni.ui.base.BaseView;

/**
 * Created by h4rdw1r3 at 5:10 PM on 30/7/18
 */
public interface GalleryContract {

    interface View extends BaseView<Presenter> {

        void setLayoutManager(RecyclerView.LayoutManager lm);
        void setAdapter(GalleryAdapter adapter);
        Context giveContext();
    }

    interface Presenter extends BasePresenter {

    }
}
