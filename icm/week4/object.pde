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
  void display(){
    noFill();

    stroke(colorCircle, colorCircle, colorCircle);
    ellipse(x,y,circleSize,circleSize);

  }
}



