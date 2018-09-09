---
title: Traffic light
slug: traffic-light
date_published: 2009-09-15T06:20:51.000Z
date_updated:   2014-03-29T23:33:15.000Z
---

# Traffic light

So I tried to code a traffic light. This is a rough sketch. The idea is to have a toy car roll over the contacts and it initiate the traffic signaling.

<div style="text-align: center;"><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="src" value="http://vimeo.com/moogaloop.swf?clip_id=6582107&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=6582107&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Traffic Light](http://vimeo.com/6582107) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).

This is the code I used

int pinRed = 3;  
 int pinYellow = 4;  
 int pinGreen = 5;  
 int switchButton = 2; // button  
 int switchIni = 0; // Initial state of switch

void setup(){  
 pinMode(pinRed, OUTPUT);  
 pinMode(pinYellow, OUTPUT);  
 pinMode(pinGreen, OUTPUT);  
 pinMode(switchButton, INPUT); //takes in switch signal

}

void loop(){  
 switchIni = digitalRead(switchButton);

if (switchIni == 1){  
 digitalWrite(pinRed, HIGH);  
 digitalWrite(pinYellow, LOW);  
 digitalWrite(pinGreen, LOW);  
 delay(1000);  
 digitalWrite(pinYellow, HIGH);  
 digitalWrite(pinRed, LOW);  
 digitalWrite(pinGreen, LOW);  
 delay(1000);

digitalWrite(pinGreen, HIGH);  
 digitalWrite(pinYellow, LOW);  
 digitalWrite(pinRed, LOW);  
 delay(5000);

}

else{  
 digitalWrite(pinRed, HIGH);  
 digitalWrite(pinYellow, LOW);  
 digitalWrite(pinGreen, LOW);  
 }

}
