package com.example.bob.fragmentmachinetest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public BFragment() {}

    public static BFragment newInstance(String param1, String param2) {
        BFragment fragment = new BFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        Log.i("DEBUG",getClass().getSimpleName()+" onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("DEBUG",getClass().getSimpleName()+" onCreate "+savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("DEBUG",getClass().getSimpleName()+" onCreateView "+savedInstanceState);
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("DEBUG",getClass().getSimpleName()+" onActivityCreated "+savedInstanceState);
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.i("DEBUG",getClass().getSimpleName()+" args "+mParam1+" "+mParam2);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Log.i("DEBUG",getClass().getSimpleName()+" onViewStateRestored "+savedInstanceState);
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("DEBUG",getClass().getSimpleName()+" onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("DEBUG",getClass().getSimpleName()+" onResume");
        super.onResume();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPause() {
        Log.i("DEBUG",getClass().getSimpleName()+" onPause");
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i("DEBUG",getClass().getSimpleName()+" onSaveInstanceState "+outState);
        super.onSaveInstanceState(outState);
        outState.putString("HELLOB","helloB");
    }

    @Override
    public void onStop() {
        Log.i("DEBUG",getClass().getSimpleName()+" onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i("DEBUG",getClass().getSimpleName()+" onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("DEBUG",getClass().getSimpleName()+" onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i("DEBUG",getClass().getSimpleName()+" onDetach");
        super.onDetach();
    }
}
