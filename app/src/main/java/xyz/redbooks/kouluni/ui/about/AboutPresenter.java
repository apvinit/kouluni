package xyz.redbooks.kouluni.ui.about;

import xyz.redbooks.kouluni.R;

/**
 * Created by h4rdw1r3 at 7:19 PM on 29/7/18
 */
public class AboutPresenter implements AboutContract.Presenter {
    private AboutContract.View aboutView;

    private static AboutPresenter INSTANCE;

    private AboutPresenter(AboutContract.View aboutView){
        this.aboutView = aboutView;
        this.aboutView.setPresenter(this);
    }

    public static AboutPresenter getInstance(AboutContract.View aboutView) {

        if(INSTANCE == null) {
            return new AboutPresenter(aboutView);
        }

        return INSTANCE;
    }

    @Override
    public void start() {
        aboutView.showSchoolName("S.B.P Vidya Vihar");
        aboutView.showPrincipalMessage("This is principal Message");
        aboutView.showPrincipalName("Abhijeet Khaton");
        aboutView.showSchoolAbout("Lorem Ipsum dolor site am te color blue nine we met size here now where I hair tongue ");
    }
}
