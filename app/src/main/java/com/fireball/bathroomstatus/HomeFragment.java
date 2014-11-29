package com.fireball.bathroomstatus;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 11/28/14.
 */
public class HomeFragment extends Fragment {

    private Button statusButton;
    private Button checkInButton;

    private RecyclerView bathroomRecyclerView;
    private BathroomAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        bathroomRecyclerView = (RecyclerView) rootView.findViewById(R.id.bathroom_recyclerView);
        bathroomRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        bathroomRecyclerView.setItemAnimator(new DefaultItemAnimator());

        Bathroom bathroom = new Bathroom();
        bathroom.setName("Hall");
        bathroom.setStatus("L");

        List<Bathroom> bathrooms = new ArrayList<>();
        bathrooms.add(bathroom);

        bathroom = new Bathroom();
        bathroom.setName("Sala");
        bathroom.setStatus("O");

        bathrooms.add(bathroom);

        bathroom = new Bathroom();
        bathroom.setName("AWS");
        bathroom.setStatus("D");

        bathrooms.add(bathroom);

        adapter = new BathroomAdapter(bathrooms, R.layout.card_bathroom, getActivity());
        bathroomRecyclerView.setAdapter(adapter);

        return rootView;
    }
}
