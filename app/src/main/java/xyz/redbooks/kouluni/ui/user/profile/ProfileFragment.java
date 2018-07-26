package xyz.redbooks.kouluni.ui.user.profile;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import xyz.redbooks.kouluni.R;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * Created by h4rdw1r3
 */

public class ProfileFragment extends Fragment {

    CardView reportCard, syllabusCard, timeTableCard;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        reportCard = view.findViewById(R.id.card_reportCard);
        reportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Show Report Card", Toast.LENGTH_SHORT).show();
            }
        });

        syllabusCard = view.findViewById(R.id.card_syllabus);
        syllabusCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Show Syllabus Card", Toast.LENGTH_SHORT).show();
            }
        });

        timeTableCard = view.findViewById(R.id.card_timeTable);
        timeTableCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Show Timetable", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
