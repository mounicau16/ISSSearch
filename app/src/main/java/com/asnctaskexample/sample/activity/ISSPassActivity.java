package com.asnctaskexample.sample.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.asnctaskexample.sample.api.PassTime;
import com.asnctaskexample.sample.api.PassTimesResponse;
import com.asnctaskexample.sample.iss_search.R;
import com.asnctaskexample.sample.services.IssPassService;
import com.asnctaskexample.sample.utils.IssConstants;
import com.asnctaskexample.sample.utils.IssUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mounica on 3/14/2018.
 */

public class ISSPassActivity extends AppCompatActivity  implements LocationListener{

    LocationManager locationManager;
    private Location location;

    double latitude;
    double longitude;
    double altitude;

    private static final String[] INITIAL_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    private static final int INITIAL_REQUEST = 1337;

    @Override
    public void onCreate(Bundle savedInstancesBundle){
        super.onCreate(savedInstancesBundle);
        setContentView(R.layout.isspass_list);

        ListView list = (ListView)findViewById(R.id.simpleListView);
        List<String> items = new ArrayList<String>();
        setCurrentLocation();
        PassTimesResponse passTimesResponse = IssPassService.getIssPassList(latitude, longitude, IssConstants.ISS_DEFAULLT_PASSES);

        if(null != passTimesResponse){
            List<PassTime> passTimesList = passTimesResponse.getPassTimes();
            for(PassTime passTime: passTimesList){
                String riseTimeStr = IssUtils.convertLongtoTimestamp(passTime.getRiseTime() * 1000);
                String temp = passTime.getDuration()/1000f + "   " + riseTimeStr;
                items.add(temp);
            }
        }else{
            items.add("No Results");
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listview_item, items);
        list.setAdapter(adapter);
    }

    /**
     * It gives current location's Latitude and Longitude values.
     */
    private void setCurrentLocation(){
        try {
            if (!canAccessLocation()) {
                requestPermissions(INITIAL_PERMS, INITIAL_REQUEST);
            }
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 2, this);
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * It returns true when GPS or Location services enabled on Device else returns false.
     * @return
     */
    private boolean canAccessLocation() {
        return(PackageManager.PERMISSION_GRANTED == checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION));
    }

    public void toast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
