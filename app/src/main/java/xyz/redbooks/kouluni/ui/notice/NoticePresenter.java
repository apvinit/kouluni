package xyz.redbooks.kouluni.ui.notice;

import android.support.v7.widget.LinearLayoutManager;

/*
 * Created by h4rdw1r3 at 2:21 PM on 2/8/18
 */
public class NoticePresenter implements NoticeContract.Presenter {

    private NoticeContract.View noticeView;

    private static NoticePresenter INSTANCE;

    private NoticePresenter(NoticeContract.View view){
        noticeView = view;
        noticeView.setPresenter(this);
    }

    public void updateViewReference(NoticeContract.View view){
        noticeView = view;
        noticeView.setPresenter(this);
    }

    public static NoticePresenter getInstance(NoticeContract.View view){
        if(INSTANCE == null){
            INSTANCE = new NoticePresenter(view);
        }

        return INSTANCE;
    }

    @Override
    public void start() {
        noticeView.setLayoutManager(new LinearLayoutManager(noticeView.giveContext()));
        noticeView.setAdapter(new NoticeAdapter());
    }


}
