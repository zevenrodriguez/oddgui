import simpleML.*;
letter[] table = new letter[26];
char[] rssTemp;
int rssLength = 0;
String[] headlines;
String headlinesTemp;
int row = 0;
int modInterval = 6;
int modNumber = 0;
int[] letterAmount = new int[26];
PFont f;
int letterPosX = 0;
int letterPosY = 0;

void setup(){
  size(635,480);
  smooth();
  background(255);
  f = createFont( " Arial " ,3,true); // Loading font
  for(int i = 0; i <table.length; i++){

    if(i < 6){
      row = 0;
      table[i] = new letter( i , row ,106,96);
    }

    if((i >=6) && (i<12)){
      row = 96;
      modNumber = i%modInterval;
      table[i] = new letter( modNumber , row ,106,96);   
    }

    if((i >=12) && (i<18)){
      row = 192;
      modNumber = i%modInterval;
      table[i] = new letter( modNumber , row ,106,96);    
    }

    if((i >=18) && (i<24)){
      row = 288;
      modNumber = i%modInterval;
      table[i] = new letter( modNumber , row ,106,96);
    }

    if(i>=24){
      row = 384;
      modNumber = i%modInterval;
      table[i] = new letter( modNumber , row ,106,96); 
    }

  }

  //end of array parsing
  XMLRequest xreq = new XMLRequest(this,"http://rss.netflix.com/Top100RSS");
  xreq.makeRequest();


}



void draw(){
  for(int i = 0; i <table.length; i++){
    table[i].display();
  }
}


void netEvent(XMLRequest ml) {
  headlines = ml.getElementArray("title");
  println("Request completed!");  // Print message
  headlinesTemp = join(headlines," ");
  headlinesTemp = headlinesTemp.toLowerCase();
  //rssTemp = headlinesTemp.toCharArray();
  rssLength = headlinesTemp.length();//rssTemp.length;

  if(rssLength>0){
    for(int i =0; i< rssLength;i++){
      char c = headlinesTemp.charAt(i);
      if (c >= 97 && c <= 122) {
        letterAmount[c-97]++; 
      }
      //println(c);
    }// end of i for loop



  }//end of b loop


  for(int i = 0; i < letterAmount.length; i++){
    //println((char) (z+97) + " " + letterAmount[z]);
    table[i].setAmount(letterAmount[i]);

    textFont(f,16);
    textAlign(LEFT);
    text(letterAmount[i],letterPosX + 10,letterPosY +10);
    /*
    if(i < 6){
     letterPosY = 0;
     letterPosX = i*106;
     
     }
     
     if((i >=6) && (i<12)){
     letterPosY = 96;
     letterPosX = ((i%modInterval)*106);
     
     
     }
     
     if((i >=12) && (i<18)){
     letterPosY = 192;
     letterPosX = ((i%modInterval)*106);
     
     }
     
     if((i >=18) && (i<24)){
     letterPosY = 288;
     letterPosX = ((i%modInterval)*106);
     
     }
     
     if(i>=24){
     letterPosY = 384;
     letterPosX = ((i%modInterval)*106);
     
     }
     
     
     */



  }



}








