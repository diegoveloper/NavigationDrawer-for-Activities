package pe.diegoveloper.belatrix.desafiobelatrix5_2017.activities.base;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import pe.diegoveloper.belatrix.desafiobelatrix5_2017.R;
import pe.diegoveloper.belatrix.desafiobelatrix5_2017.activities.Page1Activity;
import pe.diegoveloper.belatrix.desafiobelatrix5_2017.activities.Page2Activity;
import pe.diegoveloper.belatrix.desafiobelatrix5_2017.activities.Page3Activity;

public abstract class AbstractDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getCustomTitle());
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.main_content);
        getLayoutInflater().inflate(getLayoutId(), frameLayout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public abstract int getLayoutId();

    public abstract String getCustomTitle();

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.page_1) {
            launchActivity(Page1Activity.class);
        } else if (id == R.id.page_2) {
            launchActivity(Page2Activity.class);
        } else if (id == R.id.page_3) {
            launchActivity(Page3Activity.class);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void launchActivity(Class _class) {
        //Avoid launch the same activity
        if (this.getClass() != _class) {
            startActivity(makePageIntent(_class));
            overridePendingTransition(0,0);
            finish();
        }
    }

    public Intent makePageIntent(Class _class) {
        Intent intent = new Intent(this, _class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
}
