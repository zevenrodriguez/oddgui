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

public class week4 extends PApplet {

circlePulse[] circle = new circlePulse[100];
int sizeCircle = 0;
int colorOfcircle = 0;
int colorCounter = 0;

public void setup(){
  size(640,480);
  smooth(); 
    background(255);
 
}
public void draw(){

   for(int i = 0; i <circle.length; i++){
    sizeCircle = PApplet.parseInt(random(255));
    colorOfcircle = sizeCircle;
   circle[i] = new circlePulse(random(width),random(height), sizeCircle,colorOfcircle);
    
  }

    for (int i = 0; i < circle.length; i++) {
  circle[i].display();

    }

}




class circlePulse{
  //position x
  float x;
  // postion y
  float y;
  // how big circle gets
  float circleSize; 
  float colorCircle;



  circlePulse(float tempX, float tempY, float sizeOfcircle, float circleColor){
    x = tempX;
    y = tempY;
    circleSize = sizeOfcircle;
    colorCircle = circleColor;


  }
  public void display(){
    noFill();

    stroke(colorCircle, colorCircle, colorCircle);
    ellipse(x,y,circleSize,circleSize);

  }
}




  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "week4" });
  }
}
