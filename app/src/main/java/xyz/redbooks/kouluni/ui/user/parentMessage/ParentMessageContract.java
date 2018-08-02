package xyz.redbooks.kouluni.ui.user.parentMessage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import xyz.redbooks.kouluni.ui.base.BasePresenter;
import xyz.redbooks.kouluni.ui.base.BaseView;

/*
 * Created by h4rdw1r3 at 5:25 PM on 30/7/18
 */
public interface ParentMessageContract {

    interface View extends BaseView<Presenter> {

        void setLayoutManager(RecyclerView.LayoutManager lm);

        void setAdapter(ParentMessageAdapter adapter);

        Context giveContext();

    }

    interface Presenter extends BasePresenter {

    }
}
