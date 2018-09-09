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

public class elpirata2 extends PApplet {

float x  = 0;
public void setup(){
  size(640, 480);




}

public void draw(){
    background(255,255,255);
  //bandana
  fill(255,0,0);
  noStroke();
  ellipse(330,180,330,330);

  fill(255,255,255);
  noStroke();
  ellipse(290,180,330,330);

  fill(255,0,0);
  noStroke();
  ellipse(250,180,330,330);

  fill(255,255,255);
  noStroke();
  ellipse(210,180,330,330);

  fill(255,0,0);
  noStroke();
  ellipse(170,180,330,330);
  // face
  fill(180);
  rectMode(CENTER);
  rect(320,240,320,260);

  // sides
  fill(255);
  rect(80,240,160,480);

  fill(255);
  rect(560,240,160,480);

  //goatee
  fill(255,255,0);
  triangle(250,370,315,475,370,370);

  fill(255,255,100);
  triangle(260,365,315,475,370,365);



  //side of face
  fill(130);
  rect(142,240,35,260);

  //patch string
  noFill();
  stroke(255);
  strokeWeight(3);
  arc(300,120,350,100,0,PI);

  //eyepatch
  noStroke();
  fill(0);
  ellipse(230,200,120,100);

  noStroke();
  fill(0);
  rect(230,180,120,60);

  //side of bandana
  fill(255,0,0);
  arc(170, 110, 90, 190, PI, TWO_PI-PI/2);
  
   x =random(0,10); 
   //mouth
  rectMode(CORNER);
   fill(0);
 // rect(190,275-x,260,70);
  
  quad(450,275-x, 190,275-x, 190,345+x, 450,345+x);
  
  fill(255,255,0);
  rect(190,275 - x,50,30);


  fill(255,255,0);
  rect(290,275 - x,50,30);

  fill(255,255,0);
  rect(400,275 - x,50,30);

  fill(255,255,0);
  rect(250,315 + x,50,30);

  fill(255,255,0);
  rect(350,315 + x,50,30);

  


  if(x< 5){
   
     //eye
    noStroke();
    fill(255);
    ellipse(400,200,120,120);

    noStroke();
    fill(0);
    ellipse(390,215,80,80);
   
   
    //eyelid
    fill(110);
    arc(400,180,120,90,PI,TWO_PI);

    delay(800);


  }

  else if(x>5){
      //eye
    noStroke();
    fill(255);
    ellipse(400,200,120,120);

    noStroke();
    fill(0);
    ellipse(390,215,80,80);
    
    //eyelid closed
    noStroke();
    fill(110);
    ellipse(400,198,130,130);

    delay(500);

  }


}









  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "elpirata2" });
  }
}
