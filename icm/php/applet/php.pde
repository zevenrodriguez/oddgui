String[] stuff = loadStrings("http://www.zevenwolf.com/itp/icm/php/save.txt");
String check1 = "happy";
PFont font;


void setup() {
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

void draw() {
noLoop();
}


