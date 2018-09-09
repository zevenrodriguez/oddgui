---
title: istheflooropen
slug: istheflooropen
date_published: 2010-09-20T23:39:18.000Z
date_updated:   2014-03-29T23:50:59.000Z
---

# istheflooropen

istheflooropen is a sms app that checks if the ITP floor is open. By texting istheflooropen to 41411, when an sms is received the script posts the date and time to the database. It later retrieves the date and time. Then after checking the day and time, it responds back. This app uses textmarks.  
 [cc lang=”php”]

 $mySql = null;  
 $phone = $_GET[‘phone’];  
 function sqlConnect()  
 {  
 # Configuration Variables  
 $hostname = “localhost”;  
 $dbname = “*****”;  
 $username = “*****”;  
 $password = “*****”;  
 $mySql = mysql_connect($hostname, $username, $password) or die (mysql_error());  
 mysql_select_db($dbname, $mySql) or die(mysql_error());  
 return $mySql;  
 }  
 function sqlQuery($query){  
 global $mySql;  
 $data = null;  
 $result = mysql_query($query, $mySql);  
 # This set’s up an associative array (key->value pair) for all of the data returned  
 if (sizeof($result) > 0){  
 $num_fields = mysql_num_fields($result);  
 $row_cnt = 0;  
 while ($row_data = mysql_fetch_array($result)){  
 for ($cnt = 0; $cnt < $num_fields; $cnt++){  
 $field_name = mysql_field_name($result, $cnt);  
 $data[$row_cnt][$field_name] = $row_data[$cnt];  
 }  
 $row_cnt++;  
 }  
 }  
 return $data;  
 }  
 // set the default timezone to use. Available since PHP 5.1  
 date_default_timezone_set(‘EDT’);  
 $date = date(“Y-m-d”);  
 $dayOfWeek = date(“l”);  
 $time = date(“H:i”);  
 $mySql = sqlConnect();  
 $insertPhone = “INSERT INTO `flooropen`.`phoneinfo` (`ID`, `phone`, `date`, `dayOfWeek`, `time`) VALUES (NULL, ‘$phone’, ‘$date’, ‘$dayOfWeek’, ‘$time’)”;  
 $insertQuery = mysql_query($insertPhone,$mySql) or die(mysql_error());  
 $output = “SELECT * FROM phoneinfo WHERE phone = ‘$phone’ ORDER BY ID DESC LIMIT 1”;  
 $sql = “SELECT * FROM phoneinfo ORDER BY ID DESC”;  
 $data = sqlQuery($output);  
 $day = NULL;  
 $phoneNumber = $data[0][‘phone’];  
 $outputdayOfWeek = $data[0][‘dayOfWeek’];  
 $outputTime = $data[0][‘time’];  
 $stringStart = 0;  
 $stringEnd = 2;  
 $tempString = substr($outputTime,$stringStart,$stringEnd);  
 $timeInt = (int)$tempString;  
 //echo($timeInt);  
 if($outputdayOfWeek == ‘Sunday’){  
 if($timeInt < 12){  
 echo (“The floor is closed. The floor will re-open Monday from 9am-12am “);  
 }  
 else{  
 echo(“The floor is open. Please come in!”);  
 }  
 }  
 elseif($outputdayOfWeek == ‘Monday’){  
 if($timeInt < 9){  
 echo (“The floor is closed. The floor will re-open Tuesday from 9am-12am “);  
 }  
 else{  
 echo(“The floor is open. Please come in!”);  
 }  
 }  
 elseif($outputdayOfWeek == ‘Tuesday’){  
 if($timeInt < 9){  
 echo (“The floor is closed. The floor will re-open Wednesday from 9am-12am “);  
 }  
 else{  
 echo(“The floor is open. Please come in!”);  
 }  
 }  
 elseif($outputdayOfWeek == ‘Wednesday’){  
 if($timeInt < 9){  
 echo (“The floor is closed. The floor will re-open Thursday from 9am-12am “);  
 }  
 else{  
 echo(“The floor is open. Please come in!”);  
 }  
 }  
 elseif($outputdayOfWeek == ‘Thursday’){  
 if($timeInt < 9){  
 echo (“The floor is closed. The floor will re-open Friday from 9am-12am “);  
 }  
 else{  
 echo(“The floor is open. Please come in!”);  
 }  
 }  
 elseif($outputdayOfWeek == ‘Friday’){  
 if($timeInt < 9){  
 echo (“The floor is closed. The floor will re-open Saturday from 12pm-12am “);  
 }  
 else{  
 echo(“The floor is open. Please come in!”);  
 }  
 }  
 elseif($outputdayOfWeek == ‘Saturday’){  
 if($timeInt < 12){  
 echo (“The floor is closed. The floor will re-open Sunday from 12pm-12am “);  
 }  
 else{  
 echo(“The floor is open. Please come in!”);  
 }  
 }  
 ?>  
 $mySql = null;$phone = $_GET[‘phone’];  
 function sqlConnect(){# Configuration Variables$hostname = “localhost”;$dbname = “flooropen”;$username = “flooropen”;$password = “flooropen1”;  
 $mySql = mysql_connect($hostname, $username, $password) or die (mysql_error());mysql_select_db($dbname, $mySql) or die(mysql_error());  
 return $mySql;}  
 function sqlQuery($query){global $mySql;$data = null;$result = mysql_query($query, $mySql);  
 # This set’s up an associative array (key->value pair) for all of the data returnedif (sizeof($result) > 0){$num_fields = mysql_num_fields($result);$row_cnt = 0;  
 while ($row_data = mysql_fetch_array($result)){  
 for ($cnt = 0; $cnt < $num_fields; $cnt++){  
 $field_name = mysql_field_name($result, $cnt);$data[$row_cnt][$field_name] = $row_data[$cnt];}  
 $row_cnt++;}}return $data;}

// set the default timezone to use. Available since PHP 5.1date_default_timezone_set(‘EDT’);  
 $date = date(“Y-m-d”);$dayOfWeek = date(“l”);$time = date(“H:i”);  
 $mySql = sqlConnect();  
 $insertPhone = “INSERT INTO `flooropen`.`phoneinfo` (`ID`, `phone`, `date`, `dayOfWeek`, `time`) VALUES (NULL, ‘$phone’, ‘$date’, ‘$dayOfWeek’, ‘$time’)”;$insertQuery = mysql_query($insertPhone,$mySql) or die(mysql_error());$output = “SELECT * FROM phoneinfo WHERE phone = ‘$phone’ ORDER BY ID DESC LIMIT 1”;$sql = “SELECT * FROM phoneinfo ORDER BY ID DESC”;$data = sqlQuery($output);  
 $day = NULL;$phoneNumber = $data[0][‘phone’];$outputdayOfWeek = $data[0][‘dayOfWeek’];$outputTime = $data[0][‘time’];$stringStart = 0;$stringEnd = 2;

$tempString = substr($outputTime,$stringStart,$stringEnd);  
 $timeInt = (int)$tempString;//echo($timeInt);  
 if($outputdayOfWeek == ‘Sunday’){if($timeInt < 12){  
 echo (“The floor is closed. The floor will re-open Monday from 9am-12am “);}else{echo(“The floor is open. Please come in!”);}

}  
 elseif($outputdayOfWeek == ‘Monday’){if($timeInt < 9){  
 echo (“The floor is closed. The floor will re-open Tuesday from 9am-12am “);}else{echo(“The floor is open. Please come in!”);}

}  
 elseif($outputdayOfWeek == ‘Tuesday’){if($timeInt < 9){  
 echo (“The floor is closed. The floor will re-open Wednesday from 9am-12am “);}else{echo(“The floor is open. Please come in!”);}  
 }  
 elseif($outputdayOfWeek == ‘Wednesday’){if($timeInt < 9){  
 echo (“The floor is closed. The floor will re-open Thursday from 9am-12am “);}else{echo(“The floor is open. Please come in!”);}

}  
 elseif($outputdayOfWeek == ‘Thursday’){if($timeInt < 9){  
 echo (“The floor is closed. The floor will re-open Friday from 9am-12am “);}else{echo(“The floor is open. Please come in!”);}}  
 elseif($outputdayOfWeek == ‘Friday’){if($timeInt < 9){  
 echo (“The floor is closed. The floor will re-open Saturday from 12pm-12am “);}else{echo(“The floor is open. Please come in!”);}}  
 elseif($outputdayOfWeek == ‘Saturday’){  
 if($timeInt < 12){  
 echo (“The floor is closed. The floor will re-open Sunday from 12pm-12am “);}else{echo(“The floor is open. Please come in!”);}}

?>

[/cc]
