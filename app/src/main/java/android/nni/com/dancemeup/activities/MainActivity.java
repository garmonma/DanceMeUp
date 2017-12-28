package android.nni.com.dancemeup.activities;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.nni.com.dancemeup.PagerAdapter;
import android.nni.com.dancemeup.R;
import android.nni.com.dancemeup.entities.GeoLocation;
import android.nni.com.dancemeup.entities.Profile;
import android.nni.com.dancemeup.service.ProfileService;
import android.nni.com.dancemeup.service.ServerCallback;
import android.nni.com.dancemeup.service.UserService;
import android.nni.com.dancemeup.utils.LocationUtils;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private LocationUtils locationUtils;
    private LocationManager locationManager;
    private Profile profile;
    private UserService userService;
    private ProfileService profileService;

    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        TabLayout tabLayout = (TabLayout)findViewById(R.id.main_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Connect"));
        tabLayout.addTab(tabLayout.newTab().setText("Events"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        userService = new UserService(this);
        profileService = new ProfileService(this);

        Intent i = this.getIntent();
        profile = (Profile)i.getSerializableExtra("profile");

        locationUtils = new LocationUtils();
        locationManager = locationUtils.getLocationManager(this);
        locationUtils.initLocationListener(locationManager, this);

        updateProfileLocation();
    }

    private void updateProfileLocation(){
        GeoLocation profileLocation = new GeoLocation();
        Location location = locationUtils.getLastKnownLocation(locationManager, this);
        profileLocation.setLatitude(location.getLatitude());
        profileLocation.setLongitude(location.getLongitude());
        profile.setLocation(profileLocation);

        if(profile.getId() == null){
            // get profile here by getting profile from server
        }

        profileService.updateProfile(profile, new ServerCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                Gson gson = new Gson();
                profile = gson.fromJson(result.toString(), Profile.class);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng myLocation = new LatLng(profile.getLocation().getLatitude(), profile.getLocation().getLongitude());
        googleMap.addMarker(new MarkerOptions().position(myLocation)
                .title("My Location"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
    }
}