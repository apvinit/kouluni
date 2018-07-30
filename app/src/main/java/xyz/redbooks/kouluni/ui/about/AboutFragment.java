package xyz.redbooks.kouluni.ui.about;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.redbooks.kouluni.R;

/**
 * Created by h4rdw1r3
 */

public class AboutFragment extends Fragment implements AboutContract.View{

    private Unbinder unbinder;
    private AboutContract.Presenter presenter;

    @BindView(R.id.schoolImage) ImageView schoolImage;
    @BindView(R.id.about_school_description) TextView aboutSchoolDescription;
    @BindView(R.id.principalName) TextView principalName;
    @BindView(R.id.principalMessage) TextView principalMessage;
    @BindView(R.id.aboutSchoolName) TextView schoolName;

    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment getInstance(){
        return new AboutFragment();
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void showSchoolImage(int imageId) {
        schoolImage.setImageResource(imageId);
    }

    @Override
    public void showSchoolAbout(String aboutSchool) {
        aboutSchoolDescription.setText(aboutSchool);
    }

    @Override
    public void showPrincipalMessage(String principalMessage) {
        this.principalMessage.setText(principalMessage);
    }

    @Override
    public void showPrincipalName(String principalName) {
        this.principalName.setText(principalName);
    }

    @Override
    public void showSchoolName(String schoolName) {
        this.schoolName.setText(schoolName);
    }

    @Override
    public void setPresenter(AboutContract.Presenter presenter) {
        if(this.presenter == null){
            this.presenter = presenter;
        }
    }
}
