circlePulse[] circle = new circlePulse[100];
int sizeCircle = 0;
int colorOfcircle = 0;
int colorCounter = 0;

void setup(){
  size(640,480);
  smooth(); 
    background(255);
 
}
void draw(){

   for(int i = 0; i <circle.length; i++){
    sizeCircle = int(random(255));
    colorOfcircle = sizeCircle;
   circle[i] = new circlePulse(random(width),random(height), sizeCircle,colorOfcircle);
    
  }

    for (int i = 0; i < circle.length; i++) {
  circle[i].display();

    }

}




