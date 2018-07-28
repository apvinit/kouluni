package xyz.redbooks.kouluni.ui.user.profile;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import xyz.redbooks.kouluni.R;
import xyz.redbooks.kouluni.data.model.db.Student;

/**
 * Created by h4rdw1r3
 */

public class ProfileFragment extends Fragment {

    private Student student;
    private Unbinder unbinder;


    @BindView(R.id.std_name) TextView name;
    @BindView(R.id.std_fatherName) TextView fatherName;
    @BindView(R.id.std_mother_name) TextView motherName;
    @BindView(R.id.std_class) TextView std_class;
    @BindView(R.id.std_age) TextView age;
    @BindView(R.id.std_mobileNo) TextView mobileNo;
    @BindView(R.id.std_address) TextView address;

//    @BindView(R.id.std_image_profile) CircleImageView profile;

    @BindView(R.id.card_reportCard) CardView reportCard;
    @BindView(R.id.card_syllabus) CardView syllabusCard;
    @BindView(R.id.card_timeTable) CardView timeTableCard;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        student = new Student();
        student.setName("Rahul Anand");
        student.setFatherName("Anand Singh");
        student.setMotherName("Alisha Singh");
        student.setClassStandard("12 (D)");
        student.setDob("8-09-1998");
        student.setContactNo("9876543210");
        student.setAddress("H-No: 29, Police Colony Patna 800001");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //Inject ButterKnife
        unbinder = ButterKnife.bind(this, view);

        name.setText(student.getName());

        fatherName.setText(student.getFatherName());

        motherName.setText(student.getMotherName());

        std_class.setText(student.getClassStandard());

        age.setText(student.getDob());

        mobileNo.setText(student.getContactNo());

        address.setText(student.getAddress());

        reportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Show Report Card", Toast.LENGTH_SHORT).show();
            }
        });

        syllabusCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Show Syllabus Card", Toast.LENGTH_SHORT).show();
            }
        });

        timeTableCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Show Timetable", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
