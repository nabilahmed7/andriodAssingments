package com.fyp.assignmentjobs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment1 extends Fragment implements NabilAdapter.ItemClickListener {
    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    ArrayList<Items> clist =new ArrayList();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        for (int i=0; i<=10; i++ ) {

        {  clist.add(new Items(R.drawable.uber, "Staff Software Engineer - Remote", "Pismo","San Francisco, CA"));
            clist.add(new Items(R.drawable.ubermap, "Software Engineer - BackEnd", "Uber","San Francisco, CA"));
            clist.add(new Items(R.drawable.icongoogle, "Senior Engineer", "Google","Lahore, PK"));




        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        // view a bass
        adapter =new NabilAdapter(clist ,getContext() , this);

        recyclerView.setAdapter(adapter);

        return view;
    }

//    @Override
//    public void openDetail(Items items) {
//
//    }

    @Override
    public void openDetail(Items items, int position, View view) {

        Toast.makeText(getActivity(), items.cTextName, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("key_name",items.cTextName);
        bundle.putString("key_description",items.cTextDescription);
        bundle.putString("key_location",items.cTextLocation);
        bundle.putInt("key_images",items.cImages);


        Fragment2 fragment2 = new Fragment2();

        fragment2.setArguments(bundle);
        ((MainActivity )getActivity()).replaceFragmentMethod(fragment2, Fragment2.class.getSimpleName(), true, false, getActivity());

    }
}