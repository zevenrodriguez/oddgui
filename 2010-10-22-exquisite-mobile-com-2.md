---
title: Exquisite-mobile.com
slug: exquisite-mobile-com-2
date_published: 2010-10-22T20:49:07.000Z
date_updated:   2014-03-26T02:03:55.000Z
---

# Exquisite-mobile.com


Exquisite-mobile.com is a game based on the exquisite corpse model. The game is set as like call and response. A prompt is presented and the user responds with a text or picture depending on the round. This is The game is setup as a admin and user interaction. The admin sets up the game and introduces the first prompt.

This is how we create games.  
 [cc lang=”php”]  
<?php $tableName = $_POST["fname"];
$roundNumber = $_POST["roundNumber"];
$roundType = $_POST["roundType"];
$submission = $_POST["submission"];
$gameusers = $_POST["gameusers"];
//$tableName = "hello";

$mysql = sqlConnect();

$gametable = "CREATE TABLE  `exmob`.`$tableName` (
`gamesID` INT( 127 ) NOT NULL AUTO_INCREMENT ,
`gameID` INT( 127 ) NOT NULL ,
`roundNumber` INT( 127 ) NOT NULL ,
`roundType` VARCHAR( 127 ) NOT NULL ,
`submissionTable` VARCHAR( 127 ) NOT NULL ,
`userTable` VARCHAR( 127 ) NOT NULL ,
PRIMARY KEY (  `gamesID` )
)";

sqlQuery($gametable, $mysql);

$insertGameID = "INSERT INTO  `exmob`.`$tableName` (
`gamesID` ,
`gameID` ,
`roundNumber` ,
`roundType` ,
`submissionTable` ,
`userTable`
)
VALUES (
NULL ,  '$tableName',  '$roundNumber',  '$roundType',  '$submission',  '$gameusers'
);";

sqlQuery($insertGameID, $mysql);

$game = "CREATE TABLE  `exmob`.`$submission` (
`subID` INT( 127 ) NOT NULL AUTO_INCREMENT ,
`roundNumber` INT( 127 ) NOT NULL ,
`gameID` INT( 127 ) NOT NULL ,
`userID` INT( 127 ) NOT NULL ,
`media` VARCHAR( 127 ) NOT NULL ,
PRIMARY KEY (  `subID` )
)";

sqlQuery($game, $mysql);

$game1 = "CREATE TABLE  `exmob`.`$gameusers` (
`userID` INT( 127 ) NOT NULL AUTO_INCREMENT ,
`name` VARCHAR( 127 ) NOT NULL ,
`gameID` INT( 127 ) NOT NULL ,
PRIMARY KEY (  `userID` )
)";

sqlQuery($game1, $mysql);


$sql1 = "SHOW TABLES FROM `exmob`";

$result1 = mysql_query($sql1);

if (!$result1) {
    echo "DB Error, could not list tablesn";
    echo 'MySQL Error: ' . mysql_error();
    exit;
}

while ($row1 = mysql_fetch_row($result1)) {
    echo "Table: {$row1[0]}n";
}


header("Location: http://www.exquisite-mobile.com/admin.php"); /* Redirect browser */
??>

[/cc]

This is how we change levels. This type of script is a backbone for not only change levels, but also for adding players. You will notice when I use the var count I look at the current amount of tables in the database. I assume that the admin will create 3 tables: a game, player, and submissions table. The order is displayed alphabetically I assume that the total tables are divided by 3. So when I create the first game I have game1,sub1,user1. When I add another game, the table will look like this game1,game2,sub1,sub2,user1,user2. Thus total number of tables is 6 divide that by 3 you get 2. 2 is the latest table. Then by multiplying by 2 and 3, I get the index of the corresponding sub and user table.

[cc lang=”php”]  
<?php $i=1;
$tableArray = array();
//include 'creategame.php';

$round = $_POST["round"];
$roundType = $_POST["roundType"];
//echo $round;
//GENERAL SQL CONNECT
sqlConnect();

//SQL CONNECT WITH VAR
$mysql = sqlConnect();

//LOOK AT THE DATABASE AND PULL OUT THE TABLES
$sql1 = "SHOW TABLES FROM `exmob`";

$result1 = mysql_query($sql1);

if (!$result1) {
    echo "DB Error, could not list tablesn";
    echo 'MySQL Error: ' . mysql_error();
    exit;
}

while ($row1 = mysql_fetch_row($result1)) {
	//echo $row1[0];
	$tableArray[$i] = $row1[0];
	//echo $tableArray[$i];
    $i++;

}
//THE ADMIN SUBMITS 3 TABLES AT A TIME SO THE MORE TABLES 3 WOULD BE THE MULTIPLIER TO FIND THE MOST RECENT 3 THAT WERE ADDED
$count = count($tableArray);
//echo $count;
$mostrecent = ($count/3);
//echo $mostrecent;

$gameTableNum = ($mostrecent);
$subTableNum = ($mostrecent * 2);
$usersTableNum = ($mostrecent * 3);

$gameTable = $tableArray[$gameTableNum];
$subTable = $tableArray[$subTableNum];
$usersTable = $tableArray[$usersTableNum];

//echo $gameTable;
//echo $subTable;
//echo $usersTable;

// find the gamesID orderby
$changeround = "UPDATE  `exmob`.`$gameTable` SET  `roundNumber` =  '$round',
`roundType` =  '$roundType' WHERE  `$gameTable`.`gamesID` =1 LIMIT 1 ;";

sqlQuery($changeround, $mysql);

header("Location: http://www.exquisite-mobile.com/admin.php"); /* Redirect browser */
??>

[/cc]

This is the script we used for uploading images. One of the big issues with php is its default upload tmp dir. Sometimes you will not have access to read and write to the temp dir. To bypass this you need to put a new php.ini file where you set the upload_temp_dir to whatever directory you want to use. For dreamhost it wanted it in a cgi-bin folder on the same level dir as the rest of your files.

[cc lang=”php”]  
 if((!empty($_FILES[“uploaded_file”])) && ($_FILES[‘uploaded_file’][‘error’] == 0)) {  
 //Check if the file is JPEG image and it’s size is less than 350Kb  
 $filename = basename($_FILES[‘uploaded_file’][‘name’]);  
 $ext = substr($filename, strrpos($filename, ‘.’) + 1);  
 if (($ext == “jpg”) && ($_FILES[“uploaded_file”][“type”] == “image/jpeg”) &&  
 ($_FILES[“uploaded_file”][“size”]
