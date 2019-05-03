package xyz.redbooks.kouluni.ui.user.profile;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.redbooks.kouluni.R;

/*
 * Created by h4rdw1r3
 */

public class ProfileFragment extends Fragment implements ProfileContract.View {

    private Unbinder unbinder;
    private ProfileContract.Presenter presenter;

    @BindView(R.id.std_name) TextView name;
    @BindView(R.id.std_fatherName) TextView fatherName;
    @BindView(R.id.std_mother_name) TextView motherName;
    @BindView(R.id.std_class) TextView std_class;
    @BindView(R.id.std_age) TextView age;
    @BindView(R.id.std_mobileNo) TextView contactNo;
    @BindView(R.id.std_address) TextView address;

//    @BindView(R.id.std_image_profile) CircleImageView profileImage;

    @BindView(R.id.card_reportCard) CardView reportCard;
    @BindView(R.id.card_syllabus) CardView syllabusCard;
    @BindView(R.id.card_timeTable) CardView timeTableCard;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //Inject ButterKnife
        unbinder = ButterKnife.bind(this, view);

        presenter.start();

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

    @Override
    public void setProfileImage() {
        //set the profile image to circleImageView
    }

    @Override
    public void setStudentName(String name) {
        this.name.setText(name);
    }

    @Override
    public void setFatherName(String fatherName) {
        this.fatherName.setText(fatherName);
    }

    @Override
    public void setMotherName(String motherName) {
        this.motherName.setText(motherName);
    }

    @Override
    public void setDateOfBirth(String dob) {
        this.age.setText(dob);
    }

    @Override
    public void setContactNo(String contactNo) {
        this.contactNo.setText(contactNo);
    }

    @Override
    public void setAddress(String address) {
        this.address.setText(address);
    }

    @Override
    public void setClassStandard(String classStandard) {
        std_class.setText(classStandard);
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        if(this.presenter == null)
            this.presenter = presenter;
    }
}
