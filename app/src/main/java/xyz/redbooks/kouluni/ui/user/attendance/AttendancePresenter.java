package xyz.redbooks.kouluni.ui.user.attendance;

import java.util.Date;

import xyz.redbooks.kouluni.data.AppDataManager;

/*
 * Created by h4rdw1r3 at 6:29 PM on 2/8/18
 */
public class AttendancePresenter implements AttendanceContract.Presenter {

    private AttendanceContract.View attendanceView;
    private AppDataManager appDataManager;
    private static AttendancePresenter INSTANCE;

    private AttendancePresenter(AttendanceContract.View view, AppDataManager manager){
        attendanceView = view;
        attendanceView.setPresenter(this);
        appDataManager = manager;
    }

    public static AttendancePresenter getInstance(AttendanceContract.View view, AppDataManager manager){
        if(INSTANCE == null){
            INSTANCE = new AttendancePresenter(view, manager);
        }
        return INSTANCE;
    }

    public void updateViewReference(AttendanceContract.View view){
        attendanceView = view;
        attendanceView.setPresenter(this);
    }

    @Override
    public void start() {
        attendanceView.setSelectedDate(new Date());
    }


}
