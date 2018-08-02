package xyz.redbooks.kouluni.ui.user.login;


import android.content.Context;
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

/*
 * Created by h4rdw1r3
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    private Unbinder unbinder;
    private LoginContract.Presenter presenter;

    @BindView(R.id.username) EditText username;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.login_submit) Button submit;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Inject ButterKnife
        unbinder = ButterKnife.bind(this, view);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.requestLogin(username.getText().toString(), password.getText().toString());
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
    public void showLoginError(String errorMessage) {
        Toast.makeText(getActivity(), "Username or Password is wrong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLogoutOption() {
        //show logout option
    }

    @Override
    public Context giveContext() {
        return getActivity();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        if(this.presenter == null)
            this.presenter = presenter;
    }
}
