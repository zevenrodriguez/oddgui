import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class WheelchairViewer extends PApplet {

int boxH = 480; //Height of box
int boxW = 192; //Width of box
int leftTrigger = 192; // left boundary 
int rightTrigger = 832; // left boundary 
int scaleTrigger = 100; // scales in

int irelandX = 463;
int irelandY = 95;
PImage Map;
PImage Pin;
boolean ireland = false;
int threshold = 50;


PImage Dingle;
public void setup() {
  size(1024,480);
  background(0);
  smooth();
  Dingle = loadImage("Dingle.jpg");
  Map = loadImage("WorldMap.jpg");
  Pin = loadImage("smallpin.png");
}

public void draw() {

  image(Map,192,0);
  image(Pin, irelandX,irelandY); 

  if (ireland == true) {  
    image(Map,192,0);
    image(Pin, irelandX,irelandY); 

    pushMatrix();
    if (mouseY < scaleTrigger- 40){
      scale(1.5f);
      translate(-100,-100);
      


    }
    else if (mouseY < scaleTrigger- 30){
      scale(1.4f);
      translate(-80,-80);
      


    }
    else if (mouseY < scaleTrigger- 20){
      scale(1.3f);
      translate(-60,-60);
      


    }
    else if (mouseY < scaleTrigger- 10){
      scale(1.2f);
      translate(-40, -40);
      


    }
    else if(mouseY < scaleTrigger){
      scale(1.1f);
      translate(-20, -20);
      


    }
    else if(mouseY > scaleTrigger){
      scale(1);
      translate(0,0);
    }

    image(Dingle, 0,0);
    popMatrix();



    // left hand block
    if (mouseX < leftTrigger){
      fill(0);
      rect(mouseX -boxW,0,boxW,boxH);
    }
    else{
      fill(0);
      rect(0,0,boxW,boxH);
    }

    // right hand block
    if (mouseX >rightTrigger){
      fill(0);
      rect(mouseX ,0,192,boxH);
    }
    else{
      fill(0);
      rect(rightTrigger,0,boxW,boxH);
    }

  }

}




public void mouseClicked() {

  if (((mouseX > (irelandX - threshold)) && (mouseX < (irelandX + threshold))) && ((mouseY > (irelandY - threshold)) && (mouseY < (irelandY + threshold)))) {
    ireland = true;
    println ("clicked");
  }
}








  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#C0C0C0", "WheelchairViewer" });
  }
}
