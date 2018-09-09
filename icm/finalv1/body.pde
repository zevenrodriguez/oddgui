class body{
  PImage source = loadImage("body.jpg");  // Source image
  int counter = 0;
  int[] arrayX = new int[5000];
  int[] arrayY = new int[5000];

  body(){


  }

  void drawBody(){
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


  void destroyBody(int increase){

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


