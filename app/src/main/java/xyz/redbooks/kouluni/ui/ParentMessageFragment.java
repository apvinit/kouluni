package xyz.redbooks.kouluni.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import xyz.redbooks.kouluni.R;
import xyz.redbooks.kouluni.adapter.ParentMessageAdapter;


public class ParentMessageFragment extends Fragment {


    public ParentMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parent_message, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.parent_message_list);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);

        final ParentMessageAdapter parentMessageAdapter = new ParentMessageAdapter();
        recyclerView.setAdapter(parentMessageAdapter);
        return view;
    }

}
