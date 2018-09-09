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

public class assignment2 extends PApplet {

float[] numbers = new float[8];
float[] colorNum = new float[4];
float time = 0;
public void setup(){
  size(620,460);
  smooth();
  background(255);



};

public void draw(){

  time = random(0, mouseX);
  // call random 8 times give random value


  for(int i = 0; i < 8; i++){
    numbers[i] = random(0,320);

  } 
  for(int i = 0; i < 4; i++){
    colorNum[i] = random(0,255);
  }

fill(colorNum[0], colorNum[1], colorNum[2],colorNum[3]);
for(int j = 0; j<PApplet.parseInt(time); j++){
ellipse(mouseX+numbers[0] + 10, mouseY+numbers[1] + 10, 10+time,10+time);
ellipse(mouseX+numbers[2] + 10, mouseY+numbers[3] + 10, 10+time,10+time);
ellipse(mouseX+numbers[4] + 10, mouseY+numbers[5] + 10, 10+time,10+time);
ellipse(mouseX+numbers[6] + 10, mouseY+numbers[7] + 10, 10+time,10+time);
}
  fill(colorNum[0], colorNum[1], colorNum[2],colorNum[3] +40);
  noStroke();
  quad(mouseX+numbers[0], mouseY+numbers[1], mouseX+numbers[2], mouseY+numbers[3], mouseX+numbers[4], mouseY+numbers[5], mouseX+numbers[6], mouseY+numbers[7]); 
delay(PApplet.parseInt(time));

}



  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "assignment2" });
  }
}
