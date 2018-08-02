package xyz.redbooks.kouluni.ui.user.parentMessage;

import android.support.v7.widget.LinearLayoutManager;

/*
 * Created by h4rdw1r3 at 2:37 PM on 2/8/18
 */
public class ParentMessagePresenter implements ParentMessageContract.Presenter {

    private ParentMessageContract.View parentMessageView;
    private static ParentMessagePresenter INSTANCE;

    private ParentMessagePresenter(ParentMessageContract.View view){
        parentMessageView = view;
        parentMessageView.setPresenter(this);
    }

    public static ParentMessagePresenter getInstance(ParentMessageContract.View view){
        if(INSTANCE == null){
            INSTANCE = new ParentMessagePresenter(view);
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
