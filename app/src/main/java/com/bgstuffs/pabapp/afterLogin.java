package com.bgstuffs.pabapp;


import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class afterLogin extends AppCompatActivity {

    // Initialization of the fragment
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        // initialization of Bottom Navigation Bar
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment = new Home();
                        break;
                    case R.id.navigation_notifications:
                        fragment = new Notifications();
                        break;
                    case R.id.navigation_profile:
                        fragment = new ProfileActivity();
                        break;
                }
                return loadFragment(fragment);
            }
        };

        // declaration of Bottom Navigation Bar
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new Home());
    }

    // for loading fragment which we created using Frame Layout in xml file
    private boolean loadFragment(Fragment fragment){
        if (fragment!=null){
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }

    // when back button is pressed
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Voulez-vous vraiment quitter ?");
        alert.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // finish() just lets the system know that the programmer wants the
                // current Activity to be finished. And hence, it calls up onDestroy() after that
                finish();
                // start the profile activity
                startActivity(new Intent(afterLogin.this,MainActivity.class));
            }
        });
        alert.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do nothing
            }
        });

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}
