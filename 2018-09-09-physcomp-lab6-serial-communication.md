---
title: Physcomp Lab6 - Serial Communication
slug: physcomp-lab6-serial-communication
date_published: 2018-09-09T17:59:53.000Z
date_updated:   2014-03-29T23:35:21.000Z
draft: true
---

# Physcomp Lab6 - Serial Communication


Using Serial Communication with Arduino and Processing was not too bad.

The arduino code is simple. We are using a Pot put in pin0 and doing a basic analogread. The import things about this whole lab is that you make sure you always close the serial monitor, because only one application could read the serial stream.

<span style="color: #cc6600;">int</span> analogPin = 0; <span style="color: #cc6600;">int</span> analogValue = 0; <span style="color: #cc6600;">void</span><span style="color: #cc6600;">**setup**</span>() { <span style="color: #7e7e7e;">// start serial port at 9600 bps:</span><span style="color: #cc6600;">Serial</span>.<span style="color: #cc6600;">begin</span>(9600); } <span style="color: #cc6600;">void</span><span style="color: #cc6600;">**loop**</span>() { <span style="color: #7e7e7e;">// read analog input, divide by 4 to make the range 0-255:</span> analogValue = <span style="color: #cc6600;">analogRead</span>(analogPin); analogValue = analogValue / 4; <span style="color: #cc6600;">Serial</span>.<span style="color: #cc6600;">print</span>(analogValue, <span style="color: #006699;">BYTE</span>); <span style="color: #7e7e7e;">// pause for 10 milliseconds:</span><span style="color: #cc6600;">delay</span>(10); }

Once you upload close the Arduino application. So you avoid any serial issues. Open processing. I simply altered some code and made a sort of paint brush. Here is the code.  
 import processing.serial.*;

Serial myPort; // The serial port  
 int graphXPos = 1; // the horizontal position of the graph:  
 float randNum = 0;  
 void setup () {  
 size(640, 480); // window size

// List all the available serial ports  
 println(Serial.list());  
 // I know that the fisrt port in the serial list on my mac  
 // is usually my Arduino module, so I open Serial.list()[0].  
 // Open whatever port is the one you’re using.  
 myPort = new Serial(this, Serial.list()[0], 9600);

// set inital background:  
 background(255);  
 smooth();  
 }  
 void draw () {  
 // nothing happens in draw. It all happens in SerialEvent()  
 }

void serialEvent (Serial myPort) {  
 // get the byte:  
 int inByte = myPort.read();  
 randNum = random(255);  
 // print it:  
 println(inByte);  
 // set the drawing color. Pick a pretty color:  
 fill(randNum, randNum);  
 noStroke();  
 // draw the ellipse:  
 ellipse(graphXPos, inByte*2, 100, 100);

// at the edge of the screen, go back to the beginning:  
 if (graphXPos >= width) {  
 graphXPos = 0;

}  
 else {  
 // increment the horizontal position for the next reading:  
 graphXPos++;  
 }  
 }

<div style="text-align:center;"><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="src" value="http://vimeo.com/moogaloop.swf?clip_id=7165637&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=7165637&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Physcomp Lab6 – Serial Communication](http://vimeo.com/7165637) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).
