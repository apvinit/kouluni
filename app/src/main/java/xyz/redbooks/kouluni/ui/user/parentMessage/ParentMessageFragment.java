package xyz.redbooks.kouluni.ui.user.parentMessage;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.redbooks.kouluni.R;

/**
 * Created by h4rdw1r3
 */

public class ParentMessageFragment extends Fragment implements ParentMessageContract.View{

    private Unbinder unbinder;
    private ParentMessageContract.Presenter presenter;

    @BindView(R.id.parent_message_list) RecyclerView recyclerView;

    public ParentMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parent_message, container, false);

        //Inject ButterKnife
        unbinder = ButterKnife.bind(this, view);

        presenter.start();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setLayoutManager(RecyclerView.LayoutManager lm) {
        recyclerView.setLayoutManager(lm);
    }

    @Override
    public void setAdapter(ParentMessageAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @Override
    public Context giveContext() {
        return getActivity();
    }

    @Override
    public void setPresenter(ParentMessageContract.Presenter presenter) {
        if(this.presenter == null){
            this.presenter = presenter;
        }
    }
}
