---
title: Android Sms Tracking
slug: android-sms-tracking
date_published: 2010-11-02T14:12:45.000Z
date_updated:   2014-03-29T23:30:01.000Z
---

# Android Sms Tracking

This application grabs gps location with on button and the second button sends a text message to my phone number.

[cc lang=”java”]

package com.zevenwolf.tracking;

import android.app.Activity;  
 import android.app.PendingIntent;  
 import android.content.BroadcastReceiver;  
 import android.content.Context;  
 import android.content.Intent;  
 import android.content.IntentFilter;  
 import android.location.Location;  
 import android.location.LocationListener;  
 import android.location.LocationManager;  
 import android.os.Bundle;  
 import android.telephony.SmsManager;  
 import android.util.Log;  
 import android.view.View;  
 import android.view.View.OnClickListener;  
 import android.widget.Button;  
 import android.widget.TextView;  
 import android.widget.Toast;

public class Tracking extends Activity implements LocationListener, OnClickListener {  
 /** Called when the activity is first created. */

 private LocationManager lm;

 Button gpsButton;  
 Button messageButton;  
 public String lat;  
 public String lon;  
 public String message;

 PendingIntent sentPI;  
 // The intent action we are using  
 String SENT = “SMS_SENT”;  
 BroadcastReceiver br;  
 TextView lats;  
 TextView lons;

 public void onCreate(Bundle savedInstanceState) {  
 super.onCreate(savedInstanceState);  
 setContentView(R.layout.main);

 lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);  
 lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000l, 5.0f, this);  
 lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000l, 5.0f, this);

 lats = (TextView) this.findViewById(R.id.lat);  
 lons = (TextView) this.findViewById(R.id.lon);

 sentPI = PendingIntent.getBroadcast(this, 0,  
 new Intent(SENT), 0);

 gpsButton = (Button) this.findViewById(R.id.gps);  
 messageButton = (Button) this.findViewById(R.id.message);

 // The important thing is to set the onclicklistner event with in the setOnClickListener  
 gpsButton.setOnClickListener(new OnClickListener() {  
 public void onClick(View v) {

 lats.setText(lat);

 lons.setText(lon);

 message = lat + ” ” + lon;  
 Log.d(“message”, message);

 Log.d(“view”, “hit”);

 }});

 messageButton.setOnClickListener(new OnClickListener() {  
 public void onClick(View v) {

 Log.d(“view”, “hit”);

 SmsManager sms = SmsManager.getDefault();  
 // send the message, passing in the pending intent, sentPI  
 sms.sendTextMessage(“phonenumber”, null, message, sentPI, null);

 registerReceiver(br, new IntentFilter(SENT));

 }});

 // this broadcastreceiver when sent a receive code sends back a specific code which you then display

 br = new BroadcastReceiver(){  
 @Override  
 public void onReceive(Context ctx, Intent intent) {  
 switch (getResultCode())  
 {  
 case Activity.RESULT_OK:  
 Toast.makeText(getBaseContext(), “SMS sent”,  
 Toast.LENGTH_SHORT).show();  
 break;  
 case SmsManager.RESULT_ERROR_GENERIC_FAILURE:  
 Toast.makeText(getBaseContext(), “SMS: Generic failure”,  
 Toast.LENGTH_SHORT).show();  
 break;  
 case SmsManager.RESULT_ERROR_NO_SERVICE:  
 Toast.makeText(getBaseContext(), “SMS: No service”,  
 Toast.LENGTH_SHORT).show();  
 break;  
 case SmsManager.RESULT_ERROR_NULL_PDU:  
 Toast.makeText(getBaseContext(), “SMS: Null PDU”,  
 Toast.LENGTH_SHORT).show();  
 break;  
 case SmsManager.RESULT_ERROR_RADIO_OFF:  
 Toast.makeText(getBaseContext(), “SMS: Radio off”,  
 Toast.LENGTH_SHORT).show();  
 break;  
 }

 unregisterReceiver(br);  
 }

 };

 }  
 public void onPause(){

 super.onPause();  
 finish();

}  
 // onPause  
 //super onpause  
 // run finish there

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
 public void onClick(View v) {  
 // TODO Auto-generated method stub

 }

}

[/cc]
