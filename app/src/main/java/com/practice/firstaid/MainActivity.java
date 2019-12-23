package com.practice.firstaid;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CallToAmbulanceDialog.CallToAmbulanceDialogListener{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_first_aid:

                    return true;
                case R.id.navigation_tests:

                    return true;
                case R.id.navigation_manual:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sos_call:
                callToAmbulance();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void callToAmbulance() {
        DialogFragment dialog = new CallToAmbulanceDialog();
        dialog.show(getSupportFragmentManager(), "CallToAmbulanceDialog");
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,
//                R.style.Theme_Sphinx_Dialog_Alert);
//                builder.setTitle("Вызов скорой помощи")
//                .setMessage("Вызвать скорую помощь?")
//                .setIcon(R.drawable.ic_first_aid_24dp)
//                .setPositiveButton("Да",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:112")));
//                            }
//                        })
//                .setNegativeButton("Нет",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//        AlertDialog alert = builder.create();
//        alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        alert.show();
//
//        TextView textView = (TextView)alert.findViewById(android.R.id.message);
//        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
//
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); //create a new one
//        layoutParams.weight = 10;
//        alert.getButton(AlertDialog.BUTTON_POSITIVE).setLayoutParams(layoutParams);
//        alert.getButton(AlertDialog.BUTTON_NEGATIVE).setLayoutParams(layoutParams);
    }

}
