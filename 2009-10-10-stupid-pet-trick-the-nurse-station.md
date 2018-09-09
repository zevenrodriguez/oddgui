---
title: "Stupid Pet Trick: The Nurse Station"
slug: stupid-pet-trick-the-nurse-station
date_published: 2009-10-10T21:53:36.000Z
date_updated:   2014-03-29T23:35:02.000Z
---

# Stupid Pet Trick: The Nurse Station


The Nurse Station is a beer nursing meter. It goes placed on a bar counter and is used to measure if the person who places their beer on the coaster has left their beer too long on the counter.

<div style="text-align:center"><object height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="movie" value="http://vimeo.com/moogaloop.swf?clip_id=7003116&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=7003116&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Stupid Pet Trick: The Nurse Station](http://vimeo.com/7003116) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).

<div style="text-align:center"><object height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="movie" value="http://vimeo.com/moogaloop.swf?clip_id=7003141&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=7003141&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Stupid Pet Trick: Internals](http://vimeo.com/7003141) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).

Here is the code

*#include <Servo.h>  
 Servo servoMotor;*

*int fsrPin = 0; // Analog input pin that the potentiometer is attached to  
 int fsrValue = 0; // value read from the pot  
 int fsrRef = 10; // value read from the pot  
 int redLed = 4;  
 int yellowLed = 3;  
 int greenLed = 2;  
 int servoPin = 8;  
 long time = 0;  
 long lastTime = 0;  
 boolean setTime=true;*

*void setup() {  
 // initialize serial communications at 9600 bps:  
 Serial.begin(9600);  
 // declare the led pin as an output:  
 pinMode(redLed, OUTPUT);  
 pinMode(greenLed, OUTPUT);  
 pinMode(yellowLed, OUTPUT);  
 //pinMode(speakerPin, OUTPUT);  
 pinMode(servoPin, OUTPUT); // Set servo pin as an output pin  
 // pulse = minPulse;  
 servoMotor.attach(servoPin);  
 //noiseMaker.begin(9);*

*}*

*void loop() {*

*fsrValue = analogRead(fsrPin); // read the pot value  
 Serial.println(fsrValue);  
 if(fsrValue < 60){  
 digitalWrite(redLed, LOW);  
 digitalWrite(yellowLed, LOW);  
 digitalWrite(greenLed, LOW);  
 // Serial.println(“this is when the fsr is not pressed”);  
 //Serial.println(time);  
 servoMotor.write(0);  
 setTime=true;  
 // Serial.println(lastTime);*

*}*

*if(fsrValue > 60 && setTime == true){  
 lastTime= millis();  
 //Serial.println(“START TIMER”);  
 setTime=false;  
 //Serial.println(lastTime);  
 }*

*if(fsrValue > 60) {  
 if(millis() – lastTime < 5000){  
 digitalWrite(greenLed, HIGH);  
 digitalWrite(redLed, LOW);  
 digitalWrite(yellowLed, LOW);  
 servoMotor.write(27);*

*}  
 if((millis() – lastTime >= 5000) && (millis() – lastTime <10000)){*

*digitalWrite(greenLed, LOW);  
 digitalWrite(redLed, LOW);  
 digitalWrite(yellowLed, HIGH);  
 servoMotor.write(50);  
 // Serial.println(“TEN SECOND LOOP”);  
 //Serial.println(lastTime);  
 }*

*if (millis() – lastTime >= 10000 ){  
 //Serial.println(“20 SECOND LOOP”);*

*digitalWrite(yellowLed, LOW);  
 digitalWrite(redLed, HIGH);  
 digitalWrite(greenLed, LOW);  
 servoMotor.write(75);  
 //Serial.println(lastTime);  
 }  
 delay(100);  
 }*

*//Serial.println(lastTime);  
 }*

The next step is to re-implement the code not using the Servo.h library so I could add tone. Because tone and servo libraries use the internal timers of the arduino it makes the servo movement erratic. Also I could like to make a more mobile unit.
