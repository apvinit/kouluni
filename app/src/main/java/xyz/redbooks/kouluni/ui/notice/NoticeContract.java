package xyz.redbooks.kouluni.ui.notice;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import xyz.redbooks.kouluni.ui.base.BasePresenter;
import xyz.redbooks.kouluni.ui.base.BaseView;

/*
 * Created by h4rdw1r3 at 5:22 PM on 30/7/18
 */
public interface NoticeContract {

    interface View extends BaseView<Presenter> {

        void setLayoutManager(RecyclerView.LayoutManager lm);

        void setAdapter(NoticeAdapter adapter);

        Context giveContext();

    }

    interface Presenter extends BasePresenter {

    }
}
