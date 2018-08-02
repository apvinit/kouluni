package xyz.redbooks.kouluni.ui.holidayCalendar;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.redbooks.kouluni.R;

/*
 * Created by h4rdw1r3
 */

public class HolidayCalendarFragment extends Fragment implements HolidayCalendarContract.View {

    private Unbinder unbinder;
    private HolidayCalendarContract.Presenter presenter;

    @BindView(R.id.holiday_calendar) MaterialCalendarView holidayCalendar;
    @BindView(R.id.holiday_details) TextView holidayDetails;

    public HolidayCalendarFragment() {
        // Required empty public constructor
    }

    public HolidayCalendarFragment getInstance(){
        return new HolidayCalendarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_holiday_calendar, container, false);

        // inject ButterKnife
        unbinder = ButterKnife.bind(this, view);

        presenter.start();
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void setHolidayDetails(String holidayDetails) {
        this.holidayDetails.setText(holidayDetails);
    }

    @Override
    public void setSelectedDate(Date date) {
        holidayCalendar.setSelectedDate(date);
    }

    @Override
    public void setDateSelectedListener(OnDateSelectedListener listener) {
        holidayCalendar.setOnDateChangedListener(listener);
    }

    @Override
    public Context giveContext() {
        return getActivity();
    }

    @Override
    public void setPresenter(HolidayCalendarContract.Presenter presenter) {
        if(this.presenter == null){
            this.presenter = presenter;
        }
    }

}
