package xyz.redbooks.kouluni.ui.gallery;


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

/*
 * A simple {@link Fragment} subclass.
 */

/**
 * Created by h4rdw1r3
 */

public class GalleryFragment extends Fragment implements GalleryContract.View{

    @BindView(R.id.grid_gallery) RecyclerView recyclerView;

    private Unbinder unbinder;
    private GalleryContract.Presenter presenter;

    public GalleryFragment() {
        // Required empty public constructor
    }


    public static GalleryFragment getInstance(){
       return new GalleryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Inject ButterKnife
        unbinder = ButterKnife.bind(this, view);

        presenter.start();

        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public Context giveContext() {
        return getActivity();
    }

    @Override
    public void setLayoutManager(RecyclerView.LayoutManager lm) {
        recyclerView.setLayoutManager(lm);
    }

    @Override
    public void setAdapter(GalleryAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setPresenter(GalleryContract.Presenter presenter) {
        if(this.presenter == null)
            this.presenter = presenter;
    }
}
