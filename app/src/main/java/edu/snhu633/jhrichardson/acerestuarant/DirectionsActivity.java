package edu.snhu633.jhrichardson.acerestuarant;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DirectionsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double restaurant_lat;
    private double restaurant_long;

    /**
     * Create an instance of a @SupportMapFragment and fetch the map asynchronously
     * @param savedInstanceState the saved state of the calling instance as a Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        this.restaurant_lat = extras.getDouble(getResources().getString(R.string.const_lat_key));
        this.restaurant_long = extras.getDouble(getResources().getString(R.string.const_long_key));
        setContentView(R.layout.activity_directions);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Set the created map
        mMap = googleMap;
        // Add a marker to the restaurant
        LatLng ace = new LatLng(this.restaurant_lat, this.restaurant_long);
        mMap.addMarker(new MarkerOptions().position(ace)
                .title(getResources().getString(R.string.title_activity_directions)));
        //Set the camera to the maker and zoom to street level
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ace));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15.0f));
    }
}