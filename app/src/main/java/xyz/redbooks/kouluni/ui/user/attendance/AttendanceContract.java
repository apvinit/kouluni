package xyz.redbooks.kouluni.ui.user.attendance;

import java.util.Date;

import xyz.redbooks.kouluni.ui.base.BasePresenter;
import xyz.redbooks.kouluni.ui.base.BaseView;

/*
 * Created by h4rdw1r3 at 5:23 PM on 30/7/18
 */
public interface AttendanceContract {

    interface View extends BaseView<Presenter> {

        void setSelectedDate(Date date);

    }

    interface Presenter extends BasePresenter {

    }
}
