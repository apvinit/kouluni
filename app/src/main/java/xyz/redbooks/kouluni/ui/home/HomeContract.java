package xyz.redbooks.kouluni.ui.home;

import com.synnapps.carouselview.ImageListener;

import xyz.redbooks.kouluni.ui.base.BasePresenter;
import xyz.redbooks.kouluni.ui.base.BaseView;

/*
 * Created by h4rdw1r3 at 5:19 PM on 30/7/18
 */
public interface HomeContract {

    interface View extends BaseView<Presenter> {

        void setSchoolName(String schoolName);

        void setSchoolAddress(String schoolAddress);

        void setSchoolIcon(int iconId);

        void setCarouselImagesPageCount(int pageCount);

        void setCarouselImageListener(ImageListener listener);

    }

    interface Presenter extends BasePresenter {

    }
}
