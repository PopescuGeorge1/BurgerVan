package com.example.burgervan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment{

    MarkerOptions place_1, place_2;
    LatLng place_coordinate_1, place_coordinate_2;
    GoogleMap map;
    SupportMapFragment supportMapFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
//

        supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap)
            {
                map = googleMap;

                place_coordinate_1 = new LatLng(44, 26);
                place_coordinate_2 = new LatLng(43, 26);

                place_1 = new MarkerOptions().position(place_coordinate_1).title("Marker in Sydney");
                place_2 = new MarkerOptions().position(place_coordinate_2).title("Marker in Bucharest");
                // Add a marker, move the camera and zoom
                map.addMarker(place_1);
                map.addMarker(place_2);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(place_coordinate_2, 15f));

//                String url = getUrl(place_1.getPosition(), place_2.getPosition(), "driving");

                DisplayTrack("Bucharest", "Pitesti");

            }
        });
        return view;
    }

    private String getUrl (LatLng origin, LatLng destination, String directionMode){
        //origin of route
        String str_origin = "origin" + origin.latitude + "," + origin.longitude;
        //destination of route
        String str_destination = "destination" + destination.latitude + "," + destination.longitude;
        //Mode
        String mode = "mode" + directionMode;
        //Building parameters to the web service
        String parameters = str_origin + "&" + str_destination + "&" + mode;
        //Output format
        String output = "json";
        //Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters+"&key"+getString(R.string.google_maps_key);
        return url;
    }

    private void DisplayTrack (String origin, String destination) {
        try {
            Uri uri = Uri.parse("https://google.co.in/maps/dir/" + origin + "/" + destination);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}