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

public class php extends PApplet {

String[] stuff = loadStrings("http://www.zevenwolf.com/itp/icm/php/save.txt");
String check1 = "happy";
PFont font;


public void setup() {
  size(200,200);
//  println(stuff[0]);
  textAlign(CENTER);

    font = createFont("Arial", 32);
  if(stuff[0].equals(check1)){
    background(255,180,100); 
      textFont(font, 32);
    text(stuff[0], 100, 100);
  }
  
  else
  {
    background(40,35,100);
      textFont(font, 32);
    text(stuff[0], 100, 100);
  }


}

public void draw() {
noLoop();
}



  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "php" });
  }
}
