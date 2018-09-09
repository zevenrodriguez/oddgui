class letter{
  float x;
  float y;
  float letterWidth;
  float letterHeight;


 
  
  int totalAmount = 0;
  
  letter(float tempX, float tempY, float widthLetter, float heightLetter){
    
    x = tempX;
    y = tempY;
    letterWidth = widthLetter;
    letterHeight = heightLetter;

  }
  
  void display(){

   fill(totalAmount);
  noStroke();
 rect(x*106,y,letterWidth,letterHeight);   
  }
  
  /*
  void letterdisplay(char letterBig){
   //takes in a letter and displays it at the top right with a margin of 10 
    textFont(f,16);
textAlign(LEFT);
text(letterBig,x*106 + 10,y +10);
    
  }*/
void setAmount(int tempAmount){

totalAmount = tempAmount;
/*
takes the total amount and displays it


*/


}



} 

