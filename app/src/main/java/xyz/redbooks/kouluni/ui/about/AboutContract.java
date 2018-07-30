package xyz.redbooks.kouluni.ui.about;

import xyz.redbooks.kouluni.ui.base.BasePresenter;
import xyz.redbooks.kouluni.ui.base.BaseView;

/**
 * Created by h4rdw1r3 at 6:39 PM on 29/7/18
 *
 * This specifies the contract between the view and the presenter.
 */

public interface AboutContract {

    interface View extends BaseView<Presenter> {

        // Things you want view to do
        void showSchoolImage(int imageId);
        void showSchoolAbout(String aboutSchool);
        void showPrincipalMessage(String principalMessage);
        void showPrincipalName(String principalName);
        void showSchoolName(String schoolName);

    }

    interface Presenter extends BasePresenter {

    }
}
