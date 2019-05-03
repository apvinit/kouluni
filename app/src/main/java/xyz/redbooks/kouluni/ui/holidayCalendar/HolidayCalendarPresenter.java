package xyz.redbooks.kouluni.ui.holidayCalendar;

import androidx.annotation.NonNull;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Date;

import xyz.redbooks.kouluni.data.AppDataManager;

/*
 * Created by h4rdw1r3 at 1:11 PM on 2/8/18
 */
public class HolidayCalendarPresenter implements HolidayCalendarContract.Presenter {

    private static HolidayCalendarPresenter INSTANCE;
    private HolidayCalendarContract.View holidayCalendarView;
    private AppDataManager appDataManager;

    private HolidayCalendarPresenter(HolidayCalendarContract.View view, AppDataManager manager){
        holidayCalendarView = view;
        holidayCalendarView.setPresenter(this);
        appDataManager = manager;
    }

    public static HolidayCalendarPresenter getInstance(HolidayCalendarContract.View view, AppDataManager manager){
        if(INSTANCE == null){
            INSTANCE = new HolidayCalendarPresenter(view, manager);
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
