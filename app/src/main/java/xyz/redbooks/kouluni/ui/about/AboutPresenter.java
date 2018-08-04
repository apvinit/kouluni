package xyz.redbooks.kouluni.ui.about;

import xyz.redbooks.kouluni.R;
import xyz.redbooks.kouluni.data.AppDataManager;

/**
 * Created by h4rdw1r3 at 7:19 PM on 29/7/18
 */
public class AboutPresenter implements AboutContract.Presenter {

    private AboutContract.View aboutView;
    private AppDataManager appDataManager;

    private static AboutPresenter INSTANCE;

    private AboutPresenter(AboutContract.View aboutView, AppDataManager manager){
        this.aboutView = aboutView;
        this.aboutView.setPresenter(this);
        appDataManager = manager;
    }

    public static AboutPresenter getInstance(AboutContract.View aboutView, AppDataManager manager) {

        if(INSTANCE == null) {
            INSTANCE =  new AboutPresenter(aboutView, manager);
        }

        return INSTANCE;
    }

    public void updateViewReference(AboutContract.View view){
        aboutView = view;
        aboutView.setPresenter(this);
    }

    @Override
    public void start() {
        aboutView.showSchoolName("S.B.P Vidya Vihar");
        aboutView.showPrincipalMessage("This is principal Message");
        aboutView.showPrincipalName("Abhijeet Khaton");
        aboutView.showSchoolAbout("Lorem Ipsum dolor site am te color blue nine we met size here now where I hair tongue ");
    }
}
