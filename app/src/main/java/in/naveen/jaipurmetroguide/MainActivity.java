package in.naveen.jaipurmetroguide;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.format.DateFormat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView tvTime;
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvTime = (TextView) findViewById(R.id.timeview);
        //set the static map on main activity
        wv = (WebView) findViewById(R.id.webview);
       wv.getSettings().setBuiltInZoomControls(true);

        wv.setInitialScale(100);

        wv.loadUrl("file:///android_asset/map.html");

        //to run current system time

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                            Calendar cal = Calendar.getInstance();

                                int currentHour = cal.get(Calendar.HOUR);
                                int currentMinutes = cal.get(Calendar.MINUTE);
                                int currentSeconds = cal.get(Calendar.SECOND);





                                tvTime.setText(" "+currentHour+":"+currentMinutes+":"+currentSeconds+"");



                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.fare) {
            Intent i=new Intent(MainActivity.this,Fare_Class.class);
            startActivity(i);
        } else if (id == R.id.map) {

            Intent i=new Intent(MainActivity.this,MapsActivity.class);
            startActivity(i);
        } else if (id == R.id.recharge_online) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jaipurmetrosmartcard.in"));
            startActivity(browserIntent);


        } else if (id == R.id.dev_contact) {
            Intent broswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/snghnaveen/"));
            startActivity(broswerIntent);
        } else if (id == R.id.contact) {
            Intent i=new Intent(MainActivity.this,Contact_jaipur_Metro.class);
            startActivity(i);


        } else if (id == R.id.website) {
            Intent broswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jaipurmetrorail.in/"));
            startActivity(broswerIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

