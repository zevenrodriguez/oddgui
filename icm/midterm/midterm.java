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

public class midterm extends PApplet {

PImage source;
PImage destination;
String message = "message";
int x = 0;
int y = 0;
PFont f;
public void setup(){
  size(640,480);
 // size(404,500);
 source = loadImage("outline.png");
//  source = loadImage("penguin.jpg");
 // destination = createImage(source.width, source.height, RGB); 
 f = createFont("Arial", 14, true); 
 
 drawSilo();
}

public void drawSilo()
{
  background(255);
  float threshold= 200;
  source.loadPixels();
  //destination.loadPixels();
  
  textFont(f,16);
  
  for (int y = 0; y < source.height; y += 14)
  {
    for(int x = 0; x < source.width; x += 30)
    {
       int loc = x + y*source.width;
       
       if(brightness(source.pixels[loc]) < threshold)
       {
         //destination.pixels[loc] = color(255);
      fill(random(255));
    text(message, x, y);
    //println(destination.pixels[loc]);
       }
  }// end of for x
  
  
  }// end of for y
  
}

public void draw(){
  
  

}//end of draw
  



  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "midterm" });
  }
}
