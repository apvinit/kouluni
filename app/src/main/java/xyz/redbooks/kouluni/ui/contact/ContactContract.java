package xyz.redbooks.kouluni.ui.contact;

import xyz.redbooks.kouluni.ui.base.BasePresenter;
import xyz.redbooks.kouluni.ui.base.BaseView;

/**
 * Created by h4rdw1r3 at 3:59 PM on 30/7/18
 */
public interface ContactContract {
    interface View extends BaseView<Presenter> {

        void showErrorMessage();

    }

    interface Presenter extends BasePresenter {

        void submitMessage(String email, String subject, String message);

    }
}
