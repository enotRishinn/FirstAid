package com.practice.firstaid;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements CallToAmbulanceDialog.CallToAmbulanceDialogListener{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_first_aid:
                    fragment = new FirstAidFragment();
                    break;
                case R.id.navigation_tests:
                    fragment = new TestsFragment();
                    break;
                case R.id.navigation_manual:
                    fragment = new ManualFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new FirstAidFragment());

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
    }

    public boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace( R.id.fragment_container,  fragment)
                    .commit();
            return true;
        }
        return false;
    }

}
