package xyz.redbooks.kouluni.ui.user.attendance;

import java.util.Date;

/*
 * Created by h4rdw1r3 at 6:29 PM on 2/8/18
 */
public class AttendancePresenter implements AttendanceContract.Presenter {

    private AttendanceContract.View attendanceView;
    private static AttendancePresenter INSTANCE;

    private AttendancePresenter(AttendanceContract.View view){
        attendanceView = view;
        attendanceView.setPresenter(this);
    }

    public static AttendancePresenter getInstance(AttendanceContract.View view){
        if(INSTANCE == null){
            INSTANCE = new AttendancePresenter(view);
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
