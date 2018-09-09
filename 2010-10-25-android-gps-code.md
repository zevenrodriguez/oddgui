---
title: Android GPS Code
slug: android-gps-code
date_published: 2010-10-25T23:47:02.000Z
date_updated:   2014-03-26T02:03:45.000Z
---


# Android GPS Code


[cc lang=”java”]

import android.app.Activity;  
 import android.content.Context;  
 import android.location.Location;  
 import android.location.LocationListener;  
 import android.location.LocationManager;  
 import android.os.Bundle;  
 import android.util.Log;  
 import android.view.View;  
 import android.view.View.OnClickListener;  
 import android.widget.Button;  
 import android.widget.TextView;

public class Tracking extends Activity implements LocationListener, OnClickListener {  
 /** Called when the activity is first created. */

 private LocationManager lm;

 Button gpsButton;

 public String lat;  
 public String lon;

 public void onCreate(Bundle savedInstanceState) {  
 super.onCreate(savedInstanceState);  
 setContentView(R.layout.main);

 lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);  
 lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000l, 5.0f, this);  
 lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000l, 5.0f, this);

 gpsButton = (Button) this.findViewById(R.id.gps);  
 gpsButton.setOnClickListener(this);

 }

 @Override  
 public void onLocationChanged(Location arg0) {  
 lat = String.valueOf(arg0.getLatitude());  
 lon = String.valueOf(arg0.getLongitude());

 Log.d(“GPS”, “location changed: lat=” + lat + “, lon=” + lon);  
 Log.d(“hello”, “stff”);  
 }

 public void onProviderDisabled(String arg0) {  
 Log.d(“GPS”, “provider disabled ” + arg0);  
 Log.d(“hello”, “stff”);

 }

 public void onProviderEnabled(String arg0) {  
 Log.d(“GPS”, “provider enabled ” + arg0);  
 Log.d(“hello”, “stff”);

 }

 public void onStatusChanged(String arg0, int arg1, Bundle arg2) {  
 Log.d(“GPS”, “status changed to ” + arg0 + ” [” + arg1 + “]”);  
 Log.d(“hello”, “stff”);

 }

 public void setGPS(String theText)  
 {

 }

 @Override  
 public void onClick(View arg0) {  
 // TODO Auto-generated method stub

 TextView lats = (TextView) this.findViewById(R.id.lat);  
 lats.setText(lat);

 TextView lons = (TextView) this.findViewById(R.id.lon);  
 lons.setText(lon);

 }  
 }

[/cc]
