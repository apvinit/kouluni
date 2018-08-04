package xyz.redbooks.kouluni.ui.contact;

import xyz.redbooks.kouluni.data.AppDataManager;

/**
 * Created by h4rdw1r3 at 4:12 PM on 30/7/18
 */
public class ContactPresenter implements ContactContract.Presenter {

    private static ContactPresenter INSTANCE;

    private ContactContract.View contactView;
    private AppDataManager appDataManager;

    private ContactPresenter(ContactContract.View contactView, AppDataManager manager){
        this.contactView = contactView;
        this.contactView.setPresenter(this);
        appDataManager = manager;
    }

    public static void createInstance(ContactContract.View contactView, AppDataManager manager) {
        if(INSTANCE == null){
            INSTANCE = new ContactPresenter(contactView, manager);
        }
//        return INSTANCE;
    }

    @Override
    public void submitMessage(String email, String subject, String message) {
        // submit the message
    }

    @Override
    public void start() {
        // do initial data setup if required
        // it will be called in onResume method of fragment
        contactView.showErrorMessage();
    }
}
