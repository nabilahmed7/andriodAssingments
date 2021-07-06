package com.fyp.assignmentjobs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment1 extends Fragment implements Adapter.ItemClickListener {
    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    ArrayList<Items> clist = new ArrayList();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        clist.add(new Items(R.drawable.android, "Android Dev - Remote", "Sr. Android Developer ", "Lahore, PK"));
        clist.add(new Items(R.drawable.web, "Web Engineer - BackEnd", "WEB Back-End Developer", "Karachi, PK"));
        clist.add(new Items(R.drawable.photoshop, "Photo Shop", "Photo Shop Editor and Video Editor", "Islamabad, PK"));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        // view a bass
        adapter = new Adapter(clist, getContext(), this);

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
        bundle.putString("key_name", items.cTextName);
        bundle.putString("key_description", items.cTextDescription);
        bundle.putString("key_location", items.cTextLocation);
        bundle.putInt("key_images", items.cImages);


        Fragment2 fragment2 = new Fragment2();

        fragment2.setArguments(bundle);
        ((MainActivity) getActivity()).replaceFragmentMethod(fragment2, Fragment2.class.getSimpleName(), true, false, getActivity());

    }
}