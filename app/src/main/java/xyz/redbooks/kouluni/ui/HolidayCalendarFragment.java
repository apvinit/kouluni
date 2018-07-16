package xyz.redbooks.kouluni.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.redbooks.kouluni.R;
import xyz.redbooks.kouluni.adapter.HolidayCalendarAdapter;

public class HolidayCalendarFragment extends Fragment {


    public HolidayCalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_holiday_calendar, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.holiday_calendar_days);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new HolidayCalendarAdapter());
        return view;
    }

}
