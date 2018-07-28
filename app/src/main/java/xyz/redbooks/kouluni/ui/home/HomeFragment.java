package xyz.redbooks.kouluni.ui.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.redbooks.kouluni.R;
import xyz.redbooks.kouluni.data.model.others.School;
import xyz.redbooks.kouluni.utils.AppConstants;

/**
 * Created by h4rdw1r3
 */

public class HomeFragment extends Fragment {

    private School school;
    private Unbinder unbinder;

    @BindView(R.id.schoolIcon) ImageView schoolIcon;
    @BindView(R.id.schoolName) TextView schoolName;
    @BindView(R.id.schoolAddress) TextView schoolAddress;

    @BindView(R.id.carouselView) CarouselView carouselView;

    int[] schoolImages = {R.drawable.school1, R.drawable.school2, R.drawable.school3};

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        school = new School();
        school.setName("S.B.P Vidya Vihar");
        school.setAddress("Sirsa Katihar");
        school.setLogoResource("school_logo");

    }

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inject ButterKnife
        unbinder = ButterKnife.bind(this, view);

        carouselView.setPageCount(schoolImages.length);
        carouselView.setImageListener(imageListener);

        schoolIcon.setImageResource(
                getResources().getIdentifier(
                        school.getLogoResource(),"drawable", AppConstants.PACKAGE_NAME
                )
        );
        schoolName.setText(school.getName());
        schoolAddress = view.findViewById(R.id.schoolAddress);
        schoolAddress.setText(school.getAddress());

        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.get().load(schoolImages[position])
                    .into(imageView);
        }
    };


    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
