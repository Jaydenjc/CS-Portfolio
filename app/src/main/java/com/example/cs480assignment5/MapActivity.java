package com.example.cs480assignment5;


import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback
{
    GoogleMap mapAPI;
    SupportMapFragment mapFragment;
    private Geocoder gc;
    private double lat;
    private double lon;
    private LatLng position = null;

    private int locations = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapAPI);

        mapFragment.getMapAsync(this);

        gc = new Geocoder(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mapAPI = googleMap;

        LatLng USF = new LatLng(37.7766, -122.4507);
        LatLng SFState = new LatLng(37.7241, -122.4799);
        LatLng Stanford = new LatLng(37.4275,-122.1697);
        LatLng Berkeley = new LatLng(37.8715,-122.2730);
        LatLng Center = new LatLng(37.60,-122.27);

        mapAPI.addMarker(new MarkerOptions().position(USF).title("University of San Francisco"));
        mapAPI.addMarker(new MarkerOptions().position(SFState).title("San Francisco State"));
        mapAPI.addMarker(new MarkerOptions().position(Stanford).title("Stanford University"));
        mapAPI.addMarker(new MarkerOptions().position(Berkeley).title("Berkeley University"));

        mapAPI.animateCamera(CameraUpdateFactory.newLatLngZoom(Center, 10.0f));


        mapAPI.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {

            public boolean onMarkerClick(Marker m)
            {
                String title = m.getTitle();
                String schoolUrl;
                Toast.makeText(getApplicationContext(), title, Toast.LENGTH_LONG).show();

                switch (m.getTitle())
                {
                    case "University of San Francisco":
                    {
                        schoolUrl = "https://www.usfca.edu";
                        break;
                    }
                    case "San Francisco State":
                    {
                        schoolUrl = "https://www.sfsu.edu";
                        break;
                    }
                    case "Stanford University":
                    {
                        schoolUrl = "https://www.stanford.edu";
                        break;
                    }
                    case "Berkeley University":
                    {
                        schoolUrl = "https://www.berkeley.edu";
                        break;
                    }
                    default:
                    {
                        schoolUrl = "https://www.google.com/";
                        break;
                    }
                }
                switchTabToWeb(schoolUrl);
                return true;
            }
        });
    }

    public void switchTabToWeb(String urlToSearch)
    {
        MainActivity parentActivity;
        parentActivity = (MainActivity) this.getParent();
        parentActivity.switchToWeb(urlToSearch);
    }
}


