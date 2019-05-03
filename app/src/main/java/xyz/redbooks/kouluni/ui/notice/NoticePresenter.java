package xyz.redbooks.kouluni.ui.notice;

import androidx.recyclerview.widget.LinearLayoutManager;

import xyz.redbooks.kouluni.data.AppDataManager;

/*
 * Created by h4rdw1r3 at 2:21 PM on 2/8/18
 */
public class NoticePresenter implements NoticeContract.Presenter {

    private NoticeContract.View noticeView;
    private AppDataManager appDataManager;

    private static NoticePresenter INSTANCE;

    private NoticePresenter(NoticeContract.View view, AppDataManager manager){
        noticeView = view;
        noticeView.setPresenter(this);
        appDataManager = manager;
    }

    public void updateViewReference(NoticeContract.View view){
        noticeView = view;
        noticeView.setPresenter(this);
    }

    public static NoticePresenter getInstance(NoticeContract.View view, AppDataManager manager){
        if(INSTANCE == null){
            INSTANCE = new NoticePresenter(view, manager);
        }

        return INSTANCE;
    }

    @Override
    public void start() {
        noticeView.setLayoutManager(new LinearLayoutManager(noticeView.giveContext()));
        noticeView.setAdapter(new NoticeAdapter());
    }


}
