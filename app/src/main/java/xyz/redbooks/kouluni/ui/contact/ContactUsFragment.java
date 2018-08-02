package xyz.redbooks.kouluni.ui.contact;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.redbooks.kouluni.R;

/**
 * Created by h4rdw1r3
 */

public class ContactUsFragment extends Fragment implements ContactContract.View {

    private ContactContract.Presenter contactPresenter;
    private Unbinder unbinder;

    @BindView(R.id.sender_email) EditText email;
    @BindView(R.id.message_subject) EditText subject;
    @BindView(R.id.message) EditText message;
    @BindView(R.id.msg_submit) Button submit;
    @BindView(R.id.call) Button call;

    public ContactUsFragment() {
        // Required empty public constructor
    }

    public static ContactUsFragment getInstance() {
        return new ContactUsFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        // do initial setup here by calling presenter.start()
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        //Inject butterKnife here
        unbinder = ButterKnife.bind(this, view);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactPresenter.start();// Just for testing
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getActivity(), "Show some error message", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(ContactContract.Presenter presenter) {
        if(contactPresenter == null)
            contactPresenter = presenter;
    }
}
