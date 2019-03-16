package com.certuit.agroapp.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MyLocationListener implements LocationListener {

    private Context context;
    private LocationCallback callback;

    public MyLocationListener(Context context) {
        this.context = context;
    }

    public void setCallback(LocationCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onLocationChanged(Location location) {

        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses;

        try {

            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),
                    1);
            if (!addresses.isEmpty()){
                callback.getLocationString(addresses.get(0).getLocality());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // metodo no necesario
    }

    @Override
    public void onProviderEnabled(String provider) {
        // metodo no necesario
    }

    @Override
    public void onProviderDisabled(String provider) {
        // metodo no necesario
    }

    public interface LocationCallback {
        void getLocationString(String address);
    }
}
