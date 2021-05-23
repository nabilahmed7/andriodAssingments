package com.fyp.assignmentjobs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {


    TextView textView_name, textView_des,textView_loc;
    ImageView imageView;
    String names;
    String des;
    String location;
    int images;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        names = getArguments().getString("key_name");
        des = getArguments().getString("key_description");
        location = getArguments().getString("key_location");
        images = getArguments().getInt("key_images", -1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView_name = view.findViewById(R.id.name_show);
        textView_des = view.findViewById(R.id.companyName_show);
        textView_loc = view.findViewById(R.id.location_show);
        imageView = view.findViewById(R.id.imageView_show);

        textView_name.setText(names);
        textView_des.setText(des);
        textView_loc.setText(location);
        imageView.setImageResource(images);
    }
}