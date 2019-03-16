package com.certuit.agroapp.ui.dashboard;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.Notification;
import com.certuit.agroapp.ui.add_product.AddProductFragment;
import com.certuit.agroapp.ui.buyers.BuyersFragment;
import com.certuit.agroapp.ui.notification.NotificationFragment;
import com.certuit.agroapp.ui.productor_home.landing.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener {

    @BindView(R.id.drawerLayout)
    protected DrawerLayout drawerLayout;
    @BindView(R.id.navigation)
    protected NavigationView navigationView;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    private CircleImageView profilePic;
    private Fragment loadedFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(null);
        }


        initNavigationView();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_notifications:
                NotificationFragment notificationFragment = new NotificationFragment();
                notificationFragment.setListener(new NotificationFragment.NotificationClickListener() {
                    @Override
                    public void onNotificationClick(Notification notification) {
                        switch (notification.getNotificationType()) {
                            case BUYER:
                                loadFragment(new BuyersFragment());
                                break;
                            default:
                        }
                    }
                });
                loadFragment(notificationFragment);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initNavigationView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        profilePic = headerView.findViewById(R.id.profilePic);

        profilePic.setOnClickListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setListener(new HomeFragment.ProductorHomeListener() {
            @Override
            public void showAddFragment() {
                loadFragment(new AddProductFragment());
            }
        });

        loadFragment(homeFragment);
    }

    private void loadFragment(Fragment fragment) {
        boolean replace = true;
        if (loadedFragment != null && fragment.getClass().toString().equals(loadedFragment.getClass().toString())) {
            replace = false;
        }

        if (replace) {
            loadedFragment = fragment;
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
//                    R.anim.exit_to_right, R.anim.enter_from_left);
            fragmentTransaction.replace(R.id.content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (fragmentManager.getBackStackEntryCount() != 0) {
                fragmentManager.popBackStack();
                loadedFragment = null;
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setListener(new HomeFragment.ProductorHomeListener() {
                    @Override
                    public void showAddFragment() {
                        loadFragment(new AddProductFragment());
                    }
                });

                loadFragment(homeFragment);
                break;
            default:

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
