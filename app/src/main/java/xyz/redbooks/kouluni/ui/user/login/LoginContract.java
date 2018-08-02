package xyz.redbooks.kouluni.ui.user.login;

import android.content.Context;

import xyz.redbooks.kouluni.ui.base.BasePresenter;
import xyz.redbooks.kouluni.ui.base.BaseView;

/*
 * Created by h4rdw1r3 at 5:24 PM on 30/7/18
 */
public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void showLoginError(String errorMessage);

        void showLogoutOption();

        Context giveContext();

    }

    interface Presenter extends BasePresenter {

        void requestLogin(String username, String password);

    }
}
