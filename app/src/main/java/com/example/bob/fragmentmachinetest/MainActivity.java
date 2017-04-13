package com.example.bob.fragmentmachinetest;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String A_TAG="a_tag";
    private static final String B_TAG="b_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTest1Click(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = AFragment.newInstance("gaz","myas");
        transaction.add(R.id.fragmentContainer, fragment, A_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onTest2Click(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = BFragment.newInstance("rot","nogi");
        transaction.replace(R.id.fragmentContainer, fragment, B_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onTest3Click(View view){
        onTest1Click(null);
        onTest2Click(null);
        //getSupportFragmentManager().executePendingTransactions();

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        AFragment fragment=(AFragment) fragmentManager.findFragmentByTag(A_TAG);
//        Bundle bundle = fragment.getArguments();;
//        bundle.putString(AFragment.ARG_PARAM1,"wtf");
//        bundle.putString(AFragment.ARG_PARAM2,"man");
        //fragment.setArguments(bundle);
    }

    Dialog mDialog;
    public void onTest4Click(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Message")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        AlertDialog dialog = builder.create();

        dialog.show();
        mDialog=dialog;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mDialog!=null)
            mDialog.dismiss();
    }
}