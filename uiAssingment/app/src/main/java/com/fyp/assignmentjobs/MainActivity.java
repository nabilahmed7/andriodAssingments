package com.fyp.assignmentjobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment1 fragment1 = new Fragment1();
        replaceFragmentMethod(fragment1, Fragment1.class.getSimpleName(), true, false, this);


    }


    public void replaceFragmentMethod(Fragment fragment, String tag, Boolean addToStack, Boolean clearStack, FragmentActivity fragmentActivity) {

        if (clearStack)
            fragmentActivity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction fragmentTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        if (addToStack)
            fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();

    }



}