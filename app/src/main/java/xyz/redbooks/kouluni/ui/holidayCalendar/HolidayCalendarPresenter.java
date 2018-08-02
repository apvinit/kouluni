package xyz.redbooks.kouluni.ui.holidayCalendar;

import android.support.annotation.NonNull;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Date;

/*
 * Created by h4rdw1r3 at 1:11 PM on 2/8/18
 */
public class HolidayCalendarPresenter implements HolidayCalendarContract.Presenter {

    private static HolidayCalendarPresenter INSTANCE;
    private HolidayCalendarContract.View holidayCalendarView;

    private HolidayCalendarPresenter(HolidayCalendarContract.View view){
        holidayCalendarView = view;
        holidayCalendarView.setPresenter(this);
    }

    public static HolidayCalendarPresenter getInstance(HolidayCalendarContract.View view){
        if(INSTANCE == null){
            INSTANCE = new HolidayCalendarPresenter(view);
        }
        return INSTANCE;
    }

    public void updateViewReference(HolidayCalendarContract.View view){
        holidayCalendarView = view;
        holidayCalendarView.setPresenter(this);
    }


    @Override
    public void start() {
        holidayCalendarView.setSelectedDate(new Date());
        holidayCalendarView.setHolidayDetails("No Holiday");
        holidayCalendarView.setDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView materialCalendarView, @NonNull CalendarDay calendarDay, boolean b) {
                holidayCalendarView.setHolidayDetails(calendarDay.toString());
            }
        });
    }

}
