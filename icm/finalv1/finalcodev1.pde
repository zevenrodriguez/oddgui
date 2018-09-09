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


void setup() {

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

void draw() {
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

void timer(){
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


