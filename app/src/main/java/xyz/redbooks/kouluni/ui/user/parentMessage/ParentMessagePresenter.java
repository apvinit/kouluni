package xyz.redbooks.kouluni.ui.user.parentMessage;

import android.support.v7.widget.LinearLayoutManager;

import xyz.redbooks.kouluni.data.AppDataManager;

/*
 * Created by h4rdw1r3 at 2:37 PM on 2/8/18
 */
public class ParentMessagePresenter implements ParentMessageContract.Presenter {

    private ParentMessageContract.View parentMessageView;
    private AppDataManager appDataManager;
    private static ParentMessagePresenter INSTANCE;

    private ParentMessagePresenter(ParentMessageContract.View view, AppDataManager manager){
        parentMessageView = view;
        parentMessageView.setPresenter(this);
        appDataManager = manager;
    }

    public static ParentMessagePresenter getInstance(ParentMessageContract.View view, AppDataManager manager){
        if(INSTANCE == null){
            INSTANCE = new ParentMessagePresenter(view, manager);
        }

        return INSTANCE;
    }

    public void updateViewReference(ParentMessageContract.View view){
        parentMessageView = view;
        parentMessageView.setPresenter(this);
    }

    @Override
    public void start() {
        parentMessageView.setLayoutManager(new LinearLayoutManager(parentMessageView.giveContext()));
        parentMessageView.setAdapter(new ParentMessageAdapter());
    }


}
