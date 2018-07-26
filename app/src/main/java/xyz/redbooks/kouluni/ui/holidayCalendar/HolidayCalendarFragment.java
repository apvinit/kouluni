package xyz.redbooks.kouluni.ui.holidayCalendar;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.redbooks.kouluni.R;

/**
 * Created by h4rdw1r3
 */

public class HolidayCalendarFragment extends Fragment {


    public HolidayCalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_holiday_calendar, container, false);
        return view;
    }

}
