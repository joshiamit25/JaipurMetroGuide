package in.naveen.jaipurmetroguide;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
     mMap = googleMap;

        // LatLng to move the camera
        LatLng rmnagr = new LatLng(26.901941,75.774884);
      GoogleMapOptions options = new GoogleMapOptions();


        //to show marker
        MarkerOptions msor = new MarkerOptions();
        msor.title("Mansarovar (MSOR)");
        msor.position(new LatLng(26.879512,75.749981));
        msor.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMap.addMarker(msor);
        //to show marker
        MarkerOptions namt = new MarkerOptions();
       namt.title("New Atish Market (NAMT)");
        namt.position(new LatLng(26.880273,75.764755));
        namt.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        mMap.addMarker(namt);

        //to show marker
        MarkerOptions vivek = new MarkerOptions();
        vivek.title("Vivek Vihar (VKVR)");
        vivek.position(new LatLng(26.888949,75.768502));
        vivek.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mMap.addMarker(vivek);


        //to show marker
        MarkerOptions smnr = new MarkerOptions();
        smnr.title("Shyam Nagar (SMNR)");
        smnr.position(new LatLng(26.896643,75.770667));
        smnr.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        mMap.addMarker(smnr);
        //to show marker
        MarkerOptions rmnr = new MarkerOptions();
        rmnr.title("Ram Nagar (RMNR)");
        rmnr.position(new LatLng(26.901941,75.774883));
        rmnr.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        mMap.addMarker(rmnr);

        //to show marker
        MarkerOptions cljp = new MarkerOptions();
        cljp.title("Civil Lines (CLJP)");
        cljp.position(new LatLng(26.909416,75.781473));
        cljp.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mMap.addMarker(cljp);
        //to show marker
        MarkerOptions sicp = new MarkerOptions();
        sicp.title("Sindhi Camp (SICP)");
        sicp.position(new LatLng(26.922561,75.799748));
        sicp.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        mMap.addMarker(sicp);


        //to show marker
        MarkerOptions cdpe = new MarkerOptions();
        cdpe.title("Chandpole (CDPE)");
        cdpe.position(new LatLng(26.926369,75.807458));
        sicp.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mMap.addMarker(cdpe);







        //to set map type
        options.mapType(GoogleMap.MAP_TYPE_HYBRID);


        mMap.addMarker(new MarkerOptions().position(rmnagr).title(""));
       mMap.moveCamera(CameraUpdateFactory.newLatLng(rmnagr));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
