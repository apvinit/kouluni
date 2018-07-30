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

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.redbooks.kouluni.R;

/**
 * Created by h4rdw1r3
 */

public class HomeFragment extends Fragment implements HomeContract.View {

    private Unbinder unbinder;
    private HomeContract.Presenter presenter;

    @BindView(R.id.schoolIcon) ImageView schoolIcon;
    @BindView(R.id.schoolName) TextView schoolName;
    @BindView(R.id.schoolAddress) TextView schoolAddress;
    @BindView(R.id.carouselView) CarouselView carouselView;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment getInstance(){
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inject ButterKnife
        unbinder = ButterKnife.bind(this, view);

        // setup the data
        presenter.start();

        return view;
    }


    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void setSchoolName(String schoolName) {
        this.schoolName.setText(schoolName);
    }

    @Override
    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress.setText(schoolAddress);
    }

    @Override
    public void setSchoolIcon(int iconId) {
        schoolIcon.setImageResource(iconId);
    }

    @Override
    public void setCarouselImagesPageCount(int pageCount) {
        carouselView.setPageCount(pageCount);
    }

    @Override
    public void setCarouselImageListener(ImageListener listener) {
        carouselView.setImageListener(listener);
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        if(this.presenter == null)
            this.presenter = presenter;
    }
}
