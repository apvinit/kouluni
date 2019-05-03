package xyz.redbooks.kouluni.ui.user.attendance;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.redbooks.kouluni.R;

/*
 * A simple {@link Fragment} subclass.
 */

/**
 * Created by h4rdw1r3
 */

public class AttendanceFragment extends Fragment implements AttendanceContract.View{

    private Unbinder unbinder;
    private AttendanceContract.Presenter presenter;

    @BindView(R.id.attendanceCalendar)
    MaterialCalendarView attendanceCalendar;

    public AttendanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);

        // inject ButterKnife
        unbinder = ButterKnife.bind(this,view);

        attendanceCalendar.setSelectionMode(MaterialCalendarView.SELECTION_MODE_NONE);
        presenter.start();
        return view;
    }

    @Override
    public void setSelectedDate(Date date) {
        attendanceCalendar.setSelectedDate(date);
    }

    @Override
    public void setPresenter(AttendanceContract.Presenter presenter) {
        if(this.presenter == null){
            this.presenter = presenter;
        }
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
