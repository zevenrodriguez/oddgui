---
title: Working with Rotary Encoders
slug: working-with-rotary-encoders
date_published: 2012-02-07T18:51:57.000Z
date_updated:   2014-03-29T23:26:09.000Z
---

# Working with Rotary Encoders

A rotary encoder is a digital rotary sensor. It has the capability of rotating 360 degrees and can tell you direction. This tutorial is based on [Paul Stoffregen’s Encoder library and explanations](http://www.pjrc.com/teensy/td_libs_Encoder.html).

[![Rotary Encoder](http://farm8.staticflickr.com/7011/6835975655_208d31ab2a.jpg)](http://www.flickr.com/photos/zevenrodriguez/6835975655/ "Rotary Encoder by zevenwolf, on Flickr")

[![encoder](http://farm8.staticflickr.com/7050/6870530335_732d52a5e9.jpg)](http://www.flickr.com/photos/zevenrodriguez/6870530335/ "encoder by zevenwolf, on Flickr")

Inside of a rotary encoder are 2 contacts that are read by the arduino and the center contact grounds the encoder. The rotary encoder has a built in pattern that helps determine the direction you are spinning. The rotary encoder isÂ essentiallyÂ 2 switches. When Pin 1 goes high you are moving left. When Pin 2 goes high you are going right.

![Rotary Encoder](http://www.pjrc.com/teensy/td_libs_Encoder_pos1.png)

Pin 1 == Low & Pin 2 == Low ==> Position 1

![Rotary Encoder](http://www.pjrc.com/teensy/td_libs_Encoder_pos2.png)

Pin 1 == High & Pin 2 == Low ==> Position 2. Â We know that we have moved left.

The arduino pins read the Â HIGH and LOW of the pins to determine the direction. To simplify this process we are using this library [http://www.pjrc.com/teensy/td_libs_Encoder.html](http://www.pjrc.com/teensy/td_libs_Encoder.html "Encoder Library"). I used the basic code in the library example.

**Arduino**

[cc lang=”c”]  
 /* Encoder Library – Basic Example

* http://www.pjrc.com/teensy/td_libs_Encoder.html

This example code is in the public domain.  
 */  
 #include <Encoder.h>  
 // Change these two numbers to the pins connected to your encoder.  
 // Â  Best Performance: both pins have interrupt capability  
 // Â  Good Performance: only the first pin has interrupt capability  
 // Â  Low Performance: Â neither pin has interrupt capability  
 Encoder myEnc(5, 6);  
 // Â  avoid using pins with LEDs attached  
 void setup() {  
 Serial.begin(9600);  
 Serial.println(“Basic Encoder Test:”);  
 }  
 long oldPosition Â = -999;  
 void loop() {  
 long newPosition = myEnc.read();  
 if (newPosition != oldPosition) {  
 oldPosition = newPosition;  
 Serial.println(newPosition);  
 }  
 }  
 [/cc]  
 As you can see above Pin 5 and Pin 6 are the pins the arduino is going to read in order to determine which pin is high or which pin is low.

[  
](http://www.flickr.com/photos/zevenrodriguez/6870530335/ "encoder by zevenwolf, on Flickr")

[![encoder serial monitor](http://farm8.staticflickr.com/7051/6871360321_3fecd7c33a.jpg)](http://www.flickr.com/photos/zevenrodriguez/6871360321/ "encoder serial monitor by zevenwolf, on Flickr")

**Advanced Topic: Inverse Logic and Arduino Pull-up**

The Rotary Encoder isÂ essentiallyÂ 2 switches. This library sets both pins as INPUTS, followed by setting a digitalWrite to HIGH. This engages the arduino’s pull-up resistor for that pin. What the pull-up resistor does it allows a small trickle of positive voltage into the pin. Setting that pin to constantly read HIGH until you rotate the knob where the state would change to LOW. We normally think in HIGH being On and LOW being Off. With Inverse Logic HIGH is your Off state and LOW is your On state. In the case of the rotary encoder, when the pin makes contact with the white area, the encoder makes a connection to ground. Ground is now the path of leaseÂ resistance. So no electricity is flowing through the pull-up resistor, thus the pin goes Low. The orange represents the path of least resistance and the flow of electricity.

[![pullupresistor](http://farm8.staticflickr.com/7008/6836949291_14212bd4e4.jpg)](http://www.flickr.com/photos/zevenrodriguez/6836949291/ "pullupresistor by zevenwolf, on Flickr")

*Note: This library can use the [arduinoÂ interrupt](http://arduino.cc/playground/Code/Interrupts) pins for better performance.*
