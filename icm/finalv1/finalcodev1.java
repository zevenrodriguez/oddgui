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

public class finalcodev1 extends PApplet {

//PImage source;      // Source image
//int counter = 0;
int multi = 0;
int hours;
int minutes;
int seconds;
PFont myFont;
PFont myFont2;
body Body;
heart Heart;
hello Hello;
kidney Kidney;
lungs Lungs;

//int[] arrayX = new int[5000];
//int[] arrayY = new int[5000];


public void setup() {

  size(495,700);
  smooth();
  myFont = createFont("Arial", 32);
  myFont2 = createFont("Arial", 18);
  Body = new body();
  Heart = new heart();
  Hello = new hello();
  Kidney = new kidney();
  Lungs = new lungs();

  //source = loadImage("body.jpg");


  Body.drawBody();
  Lungs.drawBody();
  Heart.drawBody();
  Hello.drawBody();
  Kidney.drawBody();
}

public void draw() {
  background(255);
  if(seconds<5){
    Body.destroyBody(0);
  }
  else{
    Body.destroyBody(multi);
    multi+=2;
  }
  
  if(seconds<6){
    Heart.destroyBody(0);
  }
  else{
    Heart.destroyBody(multi);
    multi+=2;

  }
  if(seconds<7){
    Kidney.destroyBody(0);
  }
  else{
    Kidney.destroyBody(multi);
    multi+=2;

  }
  if(seconds<8){
    Lungs.destroyBody(0);
  }
  else{
    Lungs.destroyBody(multi);
    multi+=2;

  }
/*
  if(seconds> 12){
    Hello.destroyBody(0);
  }
   
   else{
   Hello.destroyBody(multi);
   multi+=.8;
   }
  */ 
  timer();
}

public void timer(){
  seconds = millis()/1000;
  minutes = seconds/60;
  hours = minutes/60; 

  fill(0);
  noStroke();
  textFont(myFont2);
  text("How long does it take to destroy a human body", 380, 470, 100, 400);

  textFont(myFont);
  text(seconds, 440, 650); 
  text(minutes, 410, 650); 
  text(hours, 380, 650); 
}


class body{
  PImage source = loadImage("body.jpg");  // Source image
  int counter = 0;
  int[] arrayX = new int[5000];
  int[] arrayY = new int[5000];

  body(){


  }

  public void drawBody(){
    float threshold = 127;

    // We are going to look at both image's pixels
    source.loadPixels();


    for (int x = 0; x < source.width; x++ ) {
      for (int y = 0; y < source.height; y++ ) {
        int loc = x + y*source.width;
        // Test the brightness against the threshold
        if (brightness(source.pixels[loc]) > threshold){
        } 
        else {
          arrayX[counter] = x +50;
          arrayY[counter] = y;
          counter++;
        }
      }
    }
  }//end of draw body


  public void destroyBody(int increase){

    for (int i = 0; i < arrayX.length; i++){

      if((i%10) == 0){
        fill(0);
        noStroke();
        //ellipse(arrayX[i] +increase,arrayY[i]+increase,5,5);
        // println(increase);

        if (arrayX[i] <= 247 && arrayY[i] <= 350){
          arrayX[i]+= random(increase) *(-1);
          arrayY[i]+= random(increase) *(-1);
          ellipse(arrayX[i],arrayY[i],5,5);  
          //ellipse(arrayX[i] + (random(increase) * (-1)),arrayY[i]+(random(increase) * (-1)),5,5);  
        }

        if (arrayX[i] >= 248 && arrayY[i] <= 350){
          arrayX[i]+= random(increase) *(1);
          arrayY[i]+= random(increase) *(-1);
          ellipse(arrayX[i],arrayY[i],5,5); 
          //ellipse(arrayX[i] + (increase * (1)),arrayY[i]+(increase * (-1)),5,5); 
        }

        if (arrayX[i] <= 247 && arrayY[i] >= 350){
          arrayX[i]+= random(increase) *(-1);
          arrayY[i]+= random(increase) *(1);
          ellipse(arrayX[i],arrayY[i],5,5); 
          //ellipse(arrayX[i] + (increase * (-1)),arrayY[i]+(increase * (1)),5,5); 
        }

        if (arrayX[i] >=248 && arrayY[i]>=350){
          arrayX[i]+= random(increase) *(1);
          arrayY[i]+= random(increase) *(1);
          ellipse(arrayX[i],arrayY[i],5,5); 
          //ellipse(arrayX[i] + (increase * (1)),arrayY[i]+(increase * (1)),5,5); 
        }

      }

    }
  }// end of destroyBody

}


class heart{
  PImage source = loadImage("heart.jpg");  // Source image
  int counter = 0;
  int[] arrayX = new int[5000];
  int[] arrayY = new int[5000];

  heart(){


  }

  public void drawBody(){
    float threshold = 127;

    // We are going to look at both image's pixels
    source.loadPixels();


    for (int x = 0; x < source.width; x++ ) {
      for (int y = 0; y < source.height; y++ ) {
        int loc = x + y*source.width;
        // Test the brightness against the threshold
        if (brightness(source.pixels[loc]) > threshold){
        } 
        else {
          arrayX[counter] = x +20;
          arrayY[counter] = y +150 ;
          counter++;
        }
      }
    }
  }//end of draw body


  public void destroyBody(int increase){

    for (int i = 0; i < arrayX.length; i++){

      if((i%5) == 0){
        fill(0);
        noStroke();
        //ellipse(arrayX[i] +increase,arrayY[i]+increase,5,5);
        // println(increase);

        if (arrayX[i] <= 247 && arrayY[i] <= 350){
          arrayX[i]+= random(increase) *(-1);
          arrayY[i]+= random(increase) *(-1);
          ellipse(arrayX[i],arrayY[i],2,2);  
          //ellipse(arrayX[i] + (random(increase) * (-1)),arrayY[i]+(random(increase) * (-1)),5,5);  
        }

        if (arrayX[i] >= 248 && arrayY[i] <= 350){
          arrayX[i]+= random(increase) *(1);
          arrayY[i]+= random(increase) *(-1);
          ellipse(arrayX[i],arrayY[i],2,2); 
          //ellipse(arrayX[i] + (increase * (1)),arrayY[i]+(increase * (-1)),5,5); 
        }

        if (arrayX[i] <= 247 && arrayY[i] >= 350){
          arrayX[i]+= random(increase) *(-1);
          arrayY[i]+= random(increase) *(1);
          ellipse(arrayX[i],arrayY[i],2,2); 
          //ellipse(arrayX[i] + (increase * (-1)),arrayY[i]+(increase * (1)),5,5); 
        }

        if (arrayX[i] >=248 && arrayY[i]>=350){
          arrayX[i]+= random(increase) *(1);
          arrayY[i]+= random(increase) *(1);
          ellipse(arrayX[i],arrayY[i],2,2); 
          //ellipse(arrayX[i] + (increase * (1)),arrayY[i]+(increase * (1)),5,5); 
        }

      }

    }
  }// end of destroyBody

}


class hello{
  PImage source = loadImage("hello.jpg");  // Source image
  int counter = 0;
  int[] arrayX = new int[5000];
  int[] arrayY = new int[5000];

  hello(){


  }

  public void drawBody(){
    float threshold = 127;

    // We are going to look at both image's pixels
    source.loadPixels();


    for (int x = 0; x < source.width; x++ ) {
      for (int y = 0; y < source.height; y++ ) {
        int loc = x + y*source.width;
        // Test the brightness against the threshold
        if (brightness(source.pixels[loc]) > threshold){
        } 
        else {
          arrayX[counter] = x+50;
          arrayY[counter] = y+250;
          counter++;
        }
      }
    }
  }//end of draw body


  public void destroyBody(int increase){

    for (int i = 0; i < arrayX.length; i++){

      if((i%5) == 0){
        fill(0);
        noStroke();
        //ellipse(arrayX[i] +increase,arrayY[i]+increase,5,5);
        // println(increase);

        if (arrayX[i] <= 247 && arrayY[i] <= 350){
          arrayX[i]+= random(increase) *(-1);
          arrayY[i]+= random(increase) *(-1);
          ellipse(arrayX[i],arrayY[i],1,1);  
          //ellipse(arrayX[i] + (random(increase) * (-1)),arrayY[i]+(random(increase) * (-1)),5,5);  
        }

        if (arrayX[i] >= 248 && arrayY[i] <= 350){
          arrayX[i]+= random(increase) *(1);
          arrayY[i]+= random(increase) *(-1);
          ellipse(arrayX[i],arrayY[i],1,1); 
          //ellipse(arrayX[i] + (increase * (1)),arrayY[i]+(increase * (-1)),5,5); 
        }

        if (arrayX[i] <= 247 && arrayY[i] >= 350){
          arrayX[i]+= random(increase) *(-1);
          arrayY[i]+= random(increase) *(1);
          ellipse(arrayX[i],arrayY[i],1,1); 
          //ellipse(arrayX[i] + (increase * (-1)),arrayY[i]+(increase * (1)),5,5); 
        }

        if (arrayX[i] >=248 && arrayY[i]>=350){
          arrayX[i]+= random(increase) *(1);
          arrayY[i]+= random(increase) *(1);
          ellipse(arrayX[i],arrayY[i],1,1); 
          //ellipse(arrayX[i] + (increase * (1)),arrayY[i]+(increase * (1)),5,5); 
        }

      }

    }
  }// end of destroyBody

}


class kidney{
  PImage source = loadImage("kidney.jpg");  // Source image
  int counter = 0;
  int[] arrayX = new int[5000];
  int[] arrayY = new int[5000];

  kidney(){


  }

  public void drawBody(){
    float threshold = 127;

    // We are going to look at both image's pixels
    source.loadPixels();


    for (int x = 0; x < source.width; x++ ) {
      for (int y = 0; y < source.height; y++ ) {
        int loc = x + y*source.width;
        // Test the brightness against the threshold
        if (brightness(source.pixels[loc]) > threshold){
        } 
        else {
          arrayX[counter] = x +50;
          arrayY[counter] = y +300 ;
          counter++;
        }
      }
    }
  }//end of draw body


  public void destroyBody(int increase){

    for (int i = 0; i < arrayX.length; i++){

      if((i%5) == 0){
        fill(0);
        noStroke();
        //ellipse(arrayX[i] +increase,arrayY[i]+increase,5,5);
        // println(increase);

        if (arrayX[i] <= 247 && arrayY[i] <= 350){
          arrayX[i]+= random(increase) *(-1);
          arrayY[i]+= random(increase) *(-1);
          ellipse(arrayX[i],arrayY[i],2,2);  
          //ellipse(arrayX[i] + (random(increase) * (-1)),arrayY[i]+(random(increase) * (-1)),5,5);  
        }

        if (arrayX[i] >= 248 && arrayY[i] <= 350){
          arrayX[i]+= random(increase) *(1);
          arrayY[i]+= random(increase) *(-1);
          ellipse(arrayX[i],arrayY[i],2,2); 
          //ellipse(arrayX[i] + (increase * (1)),arrayY[i]+(increase * (-1)),5,5); 
        }

        if (arrayX[i] <= 247 && arrayY[i] >= 350){
          arrayX[i]+= random(increase) *(-1);
          arrayY[i]+= random(increase) *(1);
          ellipse(arrayX[i],arrayY[i],2,2); 
          //ellipse(arrayX[i] + (increase * (-1)),arrayY[i]+(increase * (1)),5,5); 
        }

        if (arrayX[i] >=248 && arrayY[i]>=350){
          arrayX[i]+= random(increase) *(1);
          arrayY[i]+= random(increase) *(1);
          ellipse(arrayX[i],arrayY[i],2,2); 
          //ellipse(arrayX[i] + (increase * (1)),arrayY[i]+(increase * (1)),5,5); 
        }

      }

    }
  }// end of destroyBody

}


class lungs{
  PImage source = loadImage("lungs.jpg");  // Source image
  int counter = 0;
  int[] arrayX = new int[5000];
  int[] arrayY = new int[5000];

  lungs(){


  }

  public void drawBody(){
    float threshold = 127;

    // We are going to look at both image's pixels
    source.loadPixels();


    for (int x = 0; x < source.width; x++ ) {
      for (int y = 0; y < source.height; y++ ) {
        int loc = x + y*source.width;
        // Test the brightness against the threshold
        if (brightness(source.pixels[loc]) > threshold){
        } 
        else {
          arrayX[counter] = x +50;
          arrayY[counter] = y +130 ;
          counter++;
        }
      }
    }
  }//end of draw body


  public void destroyBody(int increase){

    for (int i = 0; i < arrayX.length; i++){

      if((i%5) == 0){
        fill(0);
        noStroke();
        //ellipse(arrayX[i] +increase,arrayY[i]+increase,5,5);
        // println(increase);

        if (arrayX[i] <= 247 && arrayY[i] <= 350){
          arrayX[i]+= random(increase) *(-1);
          arrayY[i]+= random(increase) *(-1);
          ellipse(arrayX[i],arrayY[i],2,2);  
          //ellipse(arrayX[i] + (random(increase) * (-1)),arrayY[i]+(random(increase) * (-1)),5,5);  
        }

        if (arrayX[i] >= 248 && arrayY[i] <= 350){
          arrayX[i]+= random(increase) *(1);
          arrayY[i]+= random(increase) *(-1);
          ellipse(arrayX[i],arrayY[i],2,2); 
          //ellipse(arrayX[i] + (increase * (1)),arrayY[i]+(increase * (-1)),5,5); 
        }

        if (arrayX[i] <= 247 && arrayY[i] >= 350){
          arrayX[i]+= random(increase) *(-1);
          arrayY[i]+= random(increase) *(1);
          ellipse(arrayX[i],arrayY[i],2,2); 
          //ellipse(arrayX[i] + (increase * (-1)),arrayY[i]+(increase * (1)),5,5); 
        }

        if (arrayX[i] >=248 && arrayY[i]>=350){
          arrayX[i]+= random(increase) *(1);
          arrayY[i]+= random(increase) *(1);
          ellipse(arrayX[i],arrayY[i],2,2); 
          //ellipse(arrayX[i] + (increase * (1)),arrayY[i]+(increase * (1)),5,5); 
        }

      }

    }
  }// end of destroyBody

}



  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "finalcodev1" });
  }
}
