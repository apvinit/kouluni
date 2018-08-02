package xyz.redbooks.kouluni.ui.user.login;

import android.util.Log;
import android.widget.Toast;

import java.io.InputStream;

/*
 * Created by h4rdw1r3 at 3:04 PM on 2/8/18
 */
public class LoginPresenter implements LoginContract.Presenter {
    
    private LoginContract.View loginView;
    private static  LoginPresenter INSTANCE;
    
    private LoginPresenter(LoginContract.View view) {
        loginView = view;
        loginView.setPresenter(this);
    }
    
    public static LoginPresenter getInstance(LoginContract.View view){
        if(INSTANCE == null)
            INSTANCE = new LoginPresenter(view);
        return INSTANCE;
    }
    
    public void updateViewReference(LoginContract.View view){
        loginView = view;
        loginView.setPresenter(this);
    }
    
    @Override
    public void requestLogin(String username, String password) {
        // request the login to the server
        Toast.makeText(loginView.giveContext(), "Trying to login", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void start() {

    }
}
