package xyz.redbooks.kouluni.ui.gallery;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.redbooks.kouluni.R;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * Created by h4rdw1r3
 */

public class GalleryFragment extends Fragment {

    @BindView(R.id.grid_gallery) RecyclerView recyclerView;

    private Unbinder unbinder;

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Inject ButterKnife
        unbinder = ButterKnife.bind(this, view);

        RecyclerView.LayoutManager lm = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(new GalleryAdapter());
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
