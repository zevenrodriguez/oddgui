<html>
  <head>
    <title>The Form Output</title>
  </head>
  <body>
  
  <?
    // Get the stuff entered into a form
   // $name = $_GET["name"];
    $mood = $_GET["mood"];
    
  //  echo $name . ", ";
    
    // Based on what was selected in the form, pick an output
    if ($mood == "happy") {
      echo "Happy";
    } else {
      echo "Sad";
    }
 
 $myFile = "save.txt";
$fh = fopen($myFile, 'w') or die("can't open file");
$stringData = $mood;
fwrite($fh, $stringData);

fclose($fh);

 header( 'Location: http://www.zevenwolf.com/itp/icm/php/applet' ) ;
  ?>
  
  
  
  </body>
</html>
