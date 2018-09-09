---
title: Lab2 Working with Pots
slug: lab2-working-with-pots
date_published: 2018-09-09T17:59:53.000Z
date_updated:   2014-03-29T23:34:15.000Z
draft: true
---


# Lab 2 Working with Pots


This Lab worked with analog circuits. This first part was not too challenging. Here is the code that I used for this.

int potPin = 0; // analog pin that pot attaches too “blue wire”  
 int potValue = 0; //value initial  
 int led = 9; // displays what the pot is doing

void setup(){

Serial.begin(9600);

}

void loop(){

potValue = analogRead(potPin); //read pot value  
 analogWrite(led, potValue/4); //pwm led w/ pot value  
 Serial.println(potValue);//print value  
 delay(10);

}

<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="src" value="http://vimeo.com/moogaloop.swf?clip_id=6656078&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=6656078&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object>

[Physcomp Lab2 part1](http://vimeo.com/6656078) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).

For more info about this lab [click here](http://itp.nyu.edu/physcomp/Intro/HomePage)
