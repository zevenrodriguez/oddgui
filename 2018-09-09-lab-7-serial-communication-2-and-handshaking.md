---
title: Lab 7 - Serial Communication 2 and Handshaking
slug: lab-7-serial-communication-2-and-handshaking
date_published: 2018-09-09T17:59:53.000Z
date_updated:   2014-03-29T23:35:42.000Z
draft: true
---

# Lab 7 - Serial Communication 2 and Handshaking



For this lab we were doing more advanced serial communication with the arduino and processing. I used 2 pins of an accelerometer and a pot. The hardest part of this lab is the handshaking aspect. The reason it is tricky is because the different types, punctuation and handshaking. The handshaking makes sure that the information does not get backed up in the buffer.

This arduino code sends the information in this format 0,0,0. The punctuation method would just be the code with out this function establishContact(); and this if(Serial.available()>0) . With these 2 parts, we establish the handshake method between the arduino and processing. When the “hello” is sent from the arduino code, the processing code picks it up and sends back a character. This enables processing to get information when it needs it.

***Arduino Code***

int analogOne = 0; // analog input  
 int analogTwo = 1; // analog input  
 int analogThree = 2; // digital input

int sensorValue = 0; // reading from the sensor

void setup() {  
 // configure the serial connection:  
 Serial.begin(9600);  
 // configure the digital input:  
 // pinMode(digitalOne, INPUT);  
 establishContact();  
 }

void loop() {  
 if(Serial.available()>0){  
 // read the sensor:  
 sensorValue = analogRead(analogOne);  
 // print the results:  
 Serial.print(sensorValue, DEC);  
 Serial.print(“,”);

// read the sensor:  
 sensorValue = analogRead(analogTwo);  
 // print the results:  
 Serial.print(sensorValue, DEC);  
 Serial.print(“,”);

// read the sensor:  
 sensorValue = analogRead(analogThree);  
 // print the last sensor value with a println() so that  
 // each set of four readings prints on a line by itself:  
 Serial.println(sensorValue, DEC);  
 }  
 }  
 void establishContact() {  
 while (Serial.available() <= 0) {  
 Serial.println(“hello”); // send a starting message  
 delay(300);  
 }  
 }

***Processing Code***  
 import processing.serial.*; // import the Processing serial library  
 Serial myPort; // The serial port

float bgcolor; // Background color  
 float fgcolor; // Fill color  
 float xpos, ypos; // Starting position of the ball  
 boolean firstContact = false; // Whether we’ve heard from the microcontroller

void setup() {  
 size(640,480);  
 background(255);  
 smooth();  
 // List all the available serial ports  
 println(Serial.list());

// I know that the first port in the serial list on my mac  
 // is always my Arduino module, so I open Serial.list()[0].  
 // Change the 0 to the appropriate number of the serial port  
 // that your microcontroller is attached to.  
 myPort = new Serial(this, Serial.list()[0], 9600);

// read bytes into a buffer until you get a linefeed (ASCII 10):  
 myPort.bufferUntil(‘n’);

}

void draw() {

fill(random(255),fgcolor,random(255), random(255));  
 noStroke();  
 // Draw the shape  
 ellipse(xpos, ypos, 100, 100);  
 }

// serialEvent method is run automatically by the Processing applet  
 // whenever the buffer reaches the byte value set in the bufferUntil()  
 // method in the setup():

void serialEvent(Serial myPort) {  
 // read the serial buffer:  
 String myString = myPort.readStringUntil(‘n’);  
 // if you got any bytes other than the linefeed:  
 if (myString != null) {

myString = trim(myString);

if (firstContact == false) {  
 if (myString.equals(“hello”)) {  
 myPort.clear(); // clear the serial port buffer  
 firstContact = true; // you’ve had first contact from the microcontroller  
 myPort.write(‘A’); // ask for more  
 }  
 }

else{

// split the string at the commas  
 // and convert the sections into integers:  
 int sensors[] = int(split(myString, ‘,’));

// print out the values you got:  
 for (int sensorNum = 0; sensorNum < sensors.length; sensorNum++) {  
 print(“Sensor ” + sensorNum + “: ” + sensors[sensorNum] + “t”);  
 }  
 // add a linefeed after all the sensor values are printed:  
 println();  
 if (sensors.length > 1) {  
 xpos = map(sensors[0], 0,400,0,width/2);  
 ypos = map(sensors[1], 0,400,0,height/2);  
 fgcolor = sensors[2] / 4;  
 }

}  
 myPort.write(“A”);  
 }  
 }

<div style="text-align:center;"><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="src" value="http://vimeo.com/moogaloop.swf?clip_id=7302074&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=7302074&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Physcomp Lab7 – Serial Lab 2](http://vimeo.com/7302074) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).
