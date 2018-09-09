---
title: Lab 4 Servo and Tone
slug: lab-4-servo-and-tone
date_published: 2018-09-09T17:59:53.000Z
date_updated:   2014-03-29T23:34:32.000Z
draft: true
---

# Lab 4 Servo and Tone


The breadboard is wired with 2 photocells in series go to pin 0. The photocells give an average range in the resistance. Depending which photocell you choose it pushes the resistance either towards the ends of the range. They make sure that all the voltage does not reach the arduino. The speaker goes to pin 8. It does not go to the Pulse Width Modulation because PWM changes the volume of the speaker.

<div style=" text-align:center;"><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="src" value="http://vimeo.com/moogaloop.swf?clip_id=6990458&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=6990458&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Physcomp Lab4 – Photocell tone](http://vimeo.com/6990458) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).

This code is to check the range of the photocells

*<span style="color: #cc6600;">void</span><span style="color: #cc6600;">**setup**</span>() { <span style="color: #cc6600;">Serial</span>.<span style="color: #cc6600;">begin</span>(9600); } <span style="color: #cc6600;">void</span><span style="color: #cc6600;">**loop**</span>() { <span style="color: #cc6600;">int</span> sensorValue = <span style="color: #cc6600;">analogRead</span>(0); <span style="color: #cc6600;">Serial</span>.<span style="color: #cc6600;">println</span>(sensorValue, <span style="color: #006699;">DEC</span>); }* This code uses the 2 photocells to make a thermin *<span style="color: #7e7e7e;">/*</span><span style="color: #7e7e7e;"> Theremin</span><span style="color: #7e7e7e;"></span><span style="color: #7e7e7e;"> Plays tones based on a sensor reading</span><span style="color: #7e7e7e;"> uses Tone library by Brett Hagman</span><span style="color: #7e7e7e;">[http://code.google.com/p/arduino-tone/](http://code.google.com/p/arduino-tone/)</span><span style="color: #7e7e7e;"></span><span style="color: #7e7e7e;"> circuit:</span><span style="color: #7e7e7e;"> * photoresistor from +5V to analog in 0</span><span style="color: #7e7e7e;"> * photoresistor from analog pin 0 to ground</span><span style="color: #7e7e7e;"> * 8-ohm speaker on digital pin 8</span><span style="color: #7e7e7e;"></span><span style="color: #7e7e7e;"> created 10 Sep 2009</span><span style="color: #7e7e7e;"> by Tom Igoe </span><span style="color: #7e7e7e;"> */</span> #include <Tone.h> Tone noiseMaker; <span style="color: #7e7e7e;">// instance of the tone library</span><span style="color: #cc6600;">void</span><span style="color: #cc6600;">**setup**</span>() { <span style="color: #7e7e7e;">// start the music:</span> noiseMaker.<span style="color: #cc6600;">begin</span>(8); } <span style="color: #cc6600;">void</span><span style="color: #cc6600;">**loop**</span>() { <span style="color: #7e7e7e;">// get a sensor reading:</span><span style="color: #cc6600;">int</span> sensorReading = <span style="color: #cc6600;">analogRead</span>(0); <span style="color: #7e7e7e;">// map the results from the sensor reading's range</span><span style="color: #7e7e7e;">// to the desired pitch range:</span><span style="color: #cc6600;">int</span> pitch = <span style="color: #cc6600;">map</span>(sensorReading, 200, 900, 100, 1000); <span style="color: #7e7e7e;">// change the pitch:</span> noiseMaker.play(pitch); }*

This video shows using 3 analog resistors to make a make-shift instrument

<div style=" text-align:center;"><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="src" value="http://vimeo.com/moogaloop.swf?clip_id=6990488&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=6990488&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Phsycomp Lab4 - Three analog inputs](http://vimeo.com/6990488) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).  
 Here is the code

*<span style="color: #7e7e7e;">/*</span><span style="color: #7e7e7e;"></span><span style="color: #7e7e7e;"> circuit:</span><span style="color: #7e7e7e;"> * 3 force-sensing resistors from +5V to analog in 0 through 5</span><span style="color: #7e7e7e;"> * 3 10K resistors from analog in 0 through 5 to ground</span><span style="color: #7e7e7e;"> * 8-ohm speaker on digital pin 8</span><span style="color: #7e7e7e;"></span><span style="color: #7e7e7e;"> */</span> #include <Tone.h> Tone noiseMaker; <span style="color: #7e7e7e;">// instance of the tone library</span> const <span style="color: #cc6600;">int</span> threshold = 10; <span style="color: #7e7e7e;">// minimum reading of the sensors that generates a note</span><span style="color: #7e7e7e;">// notes to play, corresponding to the 3 sensors:</span><span style="color: #cc6600;">int</span> notes[] = { NOTE_A4, NOTE_B4,NOTE_C4 }; <span style="color: #cc6600;">void</span><span style="color: #cc6600;">**setup**</span>() { <span style="color: #7e7e7e;">// start the music:</span> noiseMaker.<span style="color: #cc6600;">begin</span>(8); } <span style="color: #cc6600;">void</span><span style="color: #cc6600;">**loop**</span>() { <span style="color: #cc6600;">for</span> (<span style="color: #cc6600;">int</span> thisSensor = 0; thisSensor < 3; thisSensor++) { <span style="color: #7e7e7e;">// get a sensor reading:</span><span style="color: #cc6600;">int</span> sensorReading = <span style="color: #cc6600;">analogRead</span>(thisSensor); <span style="color: #7e7e7e;">// if the sensor is pressed hard enough:</span><span style="color: #cc6600;">if</span> (sensorReading > threshold) { <span style="color: #7e7e7e;">// play the note corresponding to this sensor:</span> noiseMaker.play(notes[thisSensor]); } <span style="color: #cc6600;">else</span> { <span style="color: #7e7e7e;">// stop playing:</span> noiseMaker.<span style="color: #cc6600;">stop</span>(); } } }*

Finally I made an instrument

<div style=" text-align:center;"><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="src" value="http://vimeo.com/moogaloop.swf?clip_id=6990438&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=6990438&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Physcomp Lab4 - Musical Instrument](http://vimeo.com/6990438) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).  
*#include <Tone.h>*  
*Tone noiseMaker; // instance of the tone library*  
*int notes[] = {*  
*NOTE_D4, NOTE_E4,NOTE_C4,NOTE_C3 };*  
*int durations[] = {*  
*100, 100, 100, 100, 100};*  
*void setup() {*  
*// start the music:*  
*noiseMaker.begin(8);*  
*Serial.begin(9600);*  
*}*  
*void loop() {*  
*int pot = analogRead(5);*  
*pot = pot/4;*  
*Serial.println(pot);*  
*//depending on were the pot is play series of tones at differnt pitches*  
*if(pot > 204){*  
*for (int thisNote = 0; thisNote < 5; thisNote ++) {*  
*// change the pitch:*  
*noiseMaker.play(notes[0]);*  
*delay(durations[thisNote]);*  
*// stop for the next note:*  
*noiseMaker.stop();*  
*}*  
*}*  
*else if((pot < 204) && (pot > 153)){*  
*for (int thisNote = 0; thisNote < 5; thisNote ++) {*  
*// change the pitch:*  
*noiseMaker.play(notes[1]);*  
*delay(durations[thisNote]);*  
*// stop for the next note:*  
*noiseMaker.stop();*  
*}*  
*// hold before repeating:*  
*}*  
*else if((pot < 153) && (pot > 102)){*  
*for (int thisNote = 0; thisNote < 5; thisNote ++) {*  
*// change the pitch:*  
*noiseMaker.play(notes[2]);*  
*delay(durations[thisNote]);*  
*// stop for the next note:*  
*noiseMaker.stop();*  
*}*  
*// hold before repeating:*  
*}*  
*else if((pot < 102) && (pot > 51)){*  
*for (int thisNote = 0; thisNote < 5; thisNote ++) {*  
*// change the pitch:*  
*noiseMaker.play(notes[3]);*  
*delay(durations[thisNote]);*  
*// stop for the next note:*  
*noiseMaker.stop();*  
*}*  
*// hold before repeating:*  
*}*  
*else if((pot < 51) && (pot >= 0)){*  
*for (int thisNote = 0; thisNote < 5; thisNote ++) {*  
*// change the pitch:*  
*noiseMaker.play(notes[4]);*  
*delay(durations[thisNote]);*  
*// stop for the next note:*  
*noiseMaker.stop();*  
 }  
*// hold before repeating:*  
*}*  
*}*  
**  
 Now using the servo

The servo is connected directly to 5v rail on the breadboard. The servo goes to pin 2. The force sensor goes to analog in.

**

<div style=" text-align:center;"><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="src" value="http://vimeo.com/moogaloop.swf?clip_id=6990504&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=6990504&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Physcomp Lab4 – Using Pulse code](http://vimeo.com/6990504) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).

This code does not use the arduino servo library

*<span style="color: #7e7e7e;">/*</span><span style="color: #7e7e7e;"> Servo control from an analog input</span><span style="color: #7e7e7e;">The minimum (minPulse) and maxiumum (maxPulse) values</span><span style="color: #7e7e7e;">will be different depending on your specific servo motor.</span><span style="color: #7e7e7e;">Ideally, it should be between 1 and 2 milliseconds, but in practice,</span><span style="color: #7e7e7e;">0.5 - 2.5 milliseconds works well for me.</span><span style="color: #7e7e7e;">Try different values to see what numbers are best for you.</span><span style="color: #7e7e7e;">This program uses the millis() function to keep track of when the servo was</span><span style="color: #7e7e7e;">last pulsed. millis() produces an overflow error (i.e. generates a number</span><span style="color: #7e7e7e;">that's too big to fit in a long variable) after about 5 days. if you're</span><span style="color: #7e7e7e;">making a program that has to run for more than 5 days, you may need to</span><span style="color: #7e7e7e;">account for this.</span><span style="color: #7e7e7e;">by Tom Igoe</span><span style="color: #7e7e7e;">additions by Carlyn Maw & Rob Faludi</span><span style="color: #7e7e7e;">Created 28 Jan. 2006</span><span style="color: #7e7e7e;">Updated 10 Jun. 2008</span><span style="color: #7e7e7e;">*/</span><span style="color: #cc6600;">int</span> servoPin = 2; <span style="color: #7e7e7e;">// Control pin for servo motor</span><span style="color: #cc6600;">int</span> minPulse = 500; <span style="color: #7e7e7e;">// Minimum servo position</span><span style="color: #cc6600;">int</span> maxPulse = 2500; <span style="color: #7e7e7e;">// Maximum servo position</span><span style="color: #cc6600;">int</span> pulse = 0; <span style="color: #7e7e7e;">// Amount to pulse the servo</span><span style="color: #cc6600;">long</span> lastPulse = 0; <span style="color: #7e7e7e;">// the time in milliseconds of the last pulse</span><span style="color: #cc6600;">int</span> refreshTime = 20; <span style="color: #7e7e7e;">// the time needed in between pulses</span><span style="color: #cc6600;">int</span> analogValue = 0; <span style="color: #7e7e7e;">// the value returned from the analog sensor</span><span style="color: #cc6600;">int</span> analogPin = 0; <span style="color: #7e7e7e;">// the analog pin that the sensor's on</span><span style="color: #cc6600;">void</span><span style="color: #cc6600;">**setup**</span>() { <span style="color: #cc6600;">pinMode</span>(servoPin, <span style="color: #006699;">OUTPUT</span>); <span style="color: #7e7e7e;">// Set servo pin as an output pin</span> pulse = minPulse; <span style="color: #7e7e7e;">// Set the motor position value to the minimum</span><span style="color: #cc6600;">Serial</span>.<span style="color: #cc6600;">begin</span>(9600); } <span style="color: #cc6600;">void</span><span style="color: #cc6600;">**loop**</span>() { analogValue = <span style="color: #cc6600;">analogRead</span>(analogPin); <span style="color: #7e7e7e;">// read the analog input</span> pulse = <span style="color: #cc6600;">map</span>(analogValue,0,1023,minPulse,maxPulse); <span style="color: #7e7e7e;">// convert the analog value</span><span style="color: #7e7e7e;">// to a range between minPulse</span><span style="color: #7e7e7e;">// and maxPulse.</span><span style="color: #7e7e7e;">// pulse the servo again if rhe refresh time (20 ms) have passed:</span><span style="color: #cc6600;">if</span> (<span style="color: #cc6600;">millis</span>() - lastPulse >= refreshTime) { <span style="color: #cc6600;">digitalWrite</span>(servoPin, <span style="color: #006699;">HIGH</span>); <span style="color: #7e7e7e;">// Turn the motor on</span><span style="color: #cc6600;">delayMicroseconds</span>(pulse); <span style="color: #7e7e7e;">// Length of the pulse sets the motor position</span><span style="color: #cc6600;">digitalWrite</span>(servoPin, <span style="color: #006699;">LOW</span>); <span style="color: #7e7e7e;">// Turn the motor off</span> lastPulse = <span style="color: #cc6600;">millis</span>(); <span style="color: #7e7e7e;">// save the time of the last pulse</span> } } *This is servo part is using the Servo.h library <div style=" text-align:center;"><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="src" value="http://vimeo.com/moogaloop.swf?clip_id=6990466&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=6990466&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Physcomp Lab4 - Using Servo Library](http://vimeo.com/6990466) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com). *<span style="color: #7e7e7e;">/*</span><span style="color: #7e7e7e;">Servo control from an analog input using the Arduino Servo library</span><span style="color: #7e7e7e;">This example code uses the Arduino Servo library which comes packaged with the Arduino software.</span><span style="color: #7e7e7e;">In order to make this work, you must include the Servo.h library file, create an instance of the Servo object. </span><span style="color: #7e7e7e;">attach a pin to the Servo object, and then write an analog value to the Servo object to set its </span><span style="color: #7e7e7e;">position.</span><span style="color: #7e7e7e;">The difference between using the Servo library and the older method of pulsing a digital pin is that the library</span><span style="color: #7e7e7e;">handles a lot of the work for you. You no longer need to figure out the translation between pulse length and position. </span><span style="color: #7e7e7e;">You now can simply specify the angle you'd like your servo to be at and it will turn to that position.</span><span style="color: #7e7e7e;">Updated 08 Sep 2009</span><span style="color: #7e7e7e;">by Rory Nugent</span><span style="color: #7e7e7e;">Created 20 Jan 2009</span><span style="color: #7e7e7e;">by Tom Igoe</span><span style="color: #7e7e7e;">*/</span> #include <<span style="color: #cc6600;">Servo</span>.h> <span style="color: #7e7e7e;">// include the servo library</span><span style="color: #cc6600;">Servo</span> servoMotor; <span style="color: #7e7e7e;">// creates an instance of the servo object to control a servo</span><span style="color: #cc6600;">int</span> analogPin = 0; <span style="color: #7e7e7e;">// the analog pin that the sensor is on</span><span style="color: #cc6600;">int</span> analogValue = 0; <span style="color: #7e7e7e;">// the value returned from the analog sensor</span><span style="color: #cc6600;">int</span> servoPin = 2; <span style="color: #7e7e7e;">// Control pin for servo motor, may only be pin 9 or 10</span><span style="color: #cc6600;">void</span><span style="color: #cc6600;">**setup**</span>() { servoMotor.<span style="color: #cc6600;">attach</span>(servoPin); <span style="color: #7e7e7e;">// attaches the servo on pin 2 to the servo object</span> } <span style="color: #cc6600;">void</span><span style="color: #cc6600;">**loop**</span>() { analogValue = <span style="color: #cc6600;">analogRead</span>(analogPin); <span style="color: #7e7e7e;">// read the analog input (value between 0 and 1023)</span> analogValue = <span style="color: #cc6600;">map</span>(analogValue, 0, 1023, 0, 179); <span style="color: #7e7e7e;">// map the analog value (0 - 1023) to the angle of the servo (0 - 179)</span> servoMotor.<span style="color: #cc6600;">write</span>(analogValue); <span style="color: #7e7e7e;">// write the new mapped analog value to set the position of the servo</span><span style="color: #cc6600;">delay</span>(15); <span style="color: #7e7e7e;">// waits for the servo to get there </span> } *
