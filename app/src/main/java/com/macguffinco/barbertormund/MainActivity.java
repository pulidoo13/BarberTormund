package com.macguffinco.barbertormund;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.macguffinco.barbertormund.activities.DetailBarberActivity;
import com.macguffinco.barbertormund.fragments.AppointmentFragment;
import com.macguffinco.barbertormund.fragments.CameraFragment;
import com.macguffinco.barbertormund.fragments.MenuFragment;
import com.macguffinco.barbertormund.fragments.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements AppointmentFragment.OnListFragmentInteractionListener {


    private MenuFragment mMenuFragment;
    private AppointmentFragment mAppointmentFragment;
    private CameraFragment mPreferenceFragment;

    private FrameLayout mMainFrame;




    private void setFragment(Fragment fragment) {
        try{
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_frame,fragment);
            fragmentTransaction.commit();

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        mMainFrame= findViewById(R.id.main_frame);


        mMenuFragment=new MenuFragment();
        mPreferenceFragment=new CameraFragment();
        mAppointmentFragment=new AppointmentFragment();


        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        setFragment(mMenuFragment );

                        return true;
                    case R.id.navigation_dashboard:
                        setFragment(mAppointmentFragment );

                        return true;
                    case R.id.navigation_notifications:
                        setFragment(mPreferenceFragment );

                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

        Intent intent= new Intent(this, DetailBarberActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
