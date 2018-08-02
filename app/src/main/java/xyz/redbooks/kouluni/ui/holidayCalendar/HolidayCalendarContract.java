package xyz.redbooks.kouluni.ui.holidayCalendar;

import android.content.Context;

import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Date;

import xyz.redbooks.kouluni.ui.base.BasePresenter;
import xyz.redbooks.kouluni.ui.base.BaseView;

/**
 * Created by h4rdw1r3 at 5:17 PM on 30/7/18
 */
public interface HolidayCalendarContract {

    interface View extends BaseView<Presenter> {

        void setHolidayDetails(String holidayDetails);

        void setSelectedDate(Date date);

        void setDateSelectedListener(OnDateSelectedListener listener);

        Context giveContext();

    }

    interface Presenter extends BasePresenter {

    }
}
